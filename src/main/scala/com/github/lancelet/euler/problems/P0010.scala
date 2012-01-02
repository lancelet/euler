package com.github.lancelet.euler.problems
import com.github.lancelet.euler.EulerProblem

import java.math.BigInteger
import com.github.lancelet.euler.math._

/** Find the sum of all the primes below 2000000. */
object P0010 extends EulerProblem {
  val number = 10
  override val expected = Some("142913828922")
  def solution: String = {
    eratosthenes(2000000).foldLeft(BigInteger.ZERO)((a, b) => {
      a.add(BigInteger.valueOf(b))
    }).toString
  }
}