package com.github.lancelet.euler.problems
import com.github.lancelet.euler.EulerProblem

import java.math.BigInteger

/** What is the sum of the digits in the number 2^1000. */
object P0016 extends EulerProblem {
  val number = 16
  override val expected = Some("1366")
  def solution: String = {
    val p = BigInteger.valueOf(2).pow(1000)
    p.toString.map(_.toInt - 48).sum.toString
  }
}