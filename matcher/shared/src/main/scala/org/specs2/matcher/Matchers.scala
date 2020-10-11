package org.specs2
package matcher

/**
 * Trait aggregating the most common specs2 matchers
 */
trait Matchers extends AnyMatchers
                  with BeHaveMatchers
                  with TraversableMatchers
                  with MapMatchers
                  with StringMatchers
                  with ExceptionMatchers
                  with NumericMatchers
                  with OptionMatchers
                  with EitherMatchers
                  with TryMatchers
                  with EventuallyMatchers
                  with FutureMatchers
                  with MatchersImplicits
                  with ValueChecks

trait Matchers1 extends
       AnyBaseMatchers
  with TraversableBaseMatchers
  with StringBaseMatchers
  with ExceptionBaseMatchers
  with NumericBaseMatchers
  with OptionBaseMatchers
  with EitherBaseMatchers
  with TryBaseMatchers
  with EventuallyMatchers
  with FutureBaseMatchers
  with ValueChecksBase

object Matchers extends Matchers

trait MustMatchers extends Matchers with MustExpectations
object MustMatchers extends MustMatchers with NoMatchResultStackTrace

trait ShouldMatchers extends Matchers with ShouldExpectations
object ShouldMatchers extends ShouldMatchers with NoMatchResultStackTrace

trait MustThrownMatchers extends Matchers with MustThrownExpectations
object MustThrownMatchers extends MustThrownMatchers with NoMatchResultStackTrace

trait ShouldThrownMatchers extends Matchers with ShouldThrownExpectations
object ShouldThrownMatchers extends ShouldThrownMatchers with NoMatchResultStackTrace
