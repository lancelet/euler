package com.github.lancelet.euler.problems
import com.github.lancelet.euler.EulerProblem

import com.github.lancelet.euler.math._

/** Find the largest prime factor of 600851475143. */
object P0003 extends EulerProblem {
  val number = 3
  override val expected = Some("6857")
  def solution: String = {
    primeFactors[Long](600851475143L).last.toString
  }
}