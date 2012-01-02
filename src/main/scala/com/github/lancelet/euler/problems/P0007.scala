package com.github.lancelet.euler.problems
import com.github.lancelet.euler.EulerProblem
import com.github.lancelet.euler.math._

/** What is the 10001st prime number. */
object P0007 extends EulerProblem {
  val number = 7
  override val expected = Some("104743")
  def solution: String = 
    primeIteratorSieve[Int].take(10001).toList.last.toString
}