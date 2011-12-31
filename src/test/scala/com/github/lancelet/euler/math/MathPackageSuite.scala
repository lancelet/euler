package com.github.lancelet.euler.math

import org.scalatest.FunSuite

/** Tests for the com.github.lancelet.euler.math package. */
class MathPackageSuite extends FunSuite {

  import com.github.lancelet.euler.math._
  
  test("primeIteratorSieve produces the correct first 20 primes") {
	val correct = List( 2,  3,  5,  7, 11, 13, 17, 19, 23, 29,
					   31, 37, 41, 43, 47, 53, 59, 61, 67, 71)
    val primes = primeIteratorSieve[Int].take(20).toList
    assert(primes === correct)
  }
  
  test("fibonacci produces the correct first 20 numbers") {
    val correct = List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 
                       55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181)
    val fibs = fibonacci[Int].take(20).toList
    assert(fibs === correct)
  }
  
}