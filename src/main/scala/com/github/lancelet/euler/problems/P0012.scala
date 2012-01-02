package com.github.lancelet.euler.problems
import com.github.lancelet.euler.EulerProblem

import com.github.lancelet.euler.math._

/** What is the first triangle number to have over 500 divisors? */
object P0012 extends EulerProblem {
  val number = 12
  override val expected = Some("76576500")
  def solution: String = {
    
    // stream of prime numbers
    val primes = primeIteratorSieve[Int].toStream
    
    // triangle numbers (drop the first number (1))
    val tnum = triangleNumbers[Int].toStream.drop(1)
    
    // the first triangle number that has >500 divisors
    tnum.dropWhile(nDivisorsS(_, primes) <= 500).head.toString
  }
}
