package com.github.lancelet.euler.problems
import com.github.lancelet.euler.EulerProblem

import scala.annotation.tailrec

/** Sum numbers less than 1000 that are divisible by either 3 or 5. */
object P0001 extends EulerProblem {
  val number = 1
  override val expected = Some("233168")
  def solution: String = {
    def divTest(x: Int): Boolean = (x % 3 == 0) || (x % 5 == 0)
    (1 until 1000).filter(divTest).sum.toString
  }
}
