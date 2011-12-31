package com.github.lancelet.euler.problems
import com.github.lancelet.euler.EulerProblem

import com.github.lancelet.euler.math._

/** Sums even values of the Fibonacci sequence that are less than 4 million. */
object P0002 extends EulerProblem {
  val number: Int = 2
  def solution: String = {
    fibonacci[Int].takeWhile(_ < 4000000).filter(_ % 2 == 0).sum.toString
  }
}