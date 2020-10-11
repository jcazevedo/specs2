package org.specs2
package matcher

import text.Sentences._
import execute.{ResultExecution, AsResult, Result}

trait ExpectationsDescription extends ExpectationsCreation:

  extension [T : AsResult](description: String):
    def ==>(result: =>T): Result = <==>(result)
    def <==>(result: =>T): Result = checkResultFailure {
      val r = ResultExecution.execute(AsResult(result))
      r match
        case i if i.isError || i.isFailure => i.mapMessage(m => negateSentence(description)+" because "+m)
        case other                         => other.mapMessage(m => description+" <=> "+m)
    }

  /** describe a value with the aka method */
  extension [T](value: => T)
    /**
     * @return an expectable with its toString method as an alias description
     *         this is useful to preserve the original value when the matcher using
     *         it is adapting the value
     */
    def aka: Expectable[T] = aka(value.toString)

    /** @return an expectable with an alias description */
    def aka(alias: => String): Expectable[T] = createExpectable(value, alias)

    /** @return an expectable with an alias description, after the value string */
    def post(alias: => String): Expectable[T] = as((_: String) + " " + alias)

    /** @return an expectable with an alias description, after the value string */
    def as(alias: String => String): Expectable[T] = createExpectable(value, alias)

    /** @return an expectable with a function to show the element T */
    def showAs(implicit show: T => String): Expectable[T] =
      lazy val v = value
      createExpectableWithShowAs(v, show(v))


object ExpectationsDescription extends ExpectationsDescription
