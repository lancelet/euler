package com.github.lancelet.euler

import scala.annotation.tailrec
import scala.collection.Iterator
import scala.collection.immutable.List
import scala.math.Integral

package object math {

  /** Computes the sequence of prime numbers using the ''Sieve of 
   *  Eratosthenes'' algorithm.
   *  
   *  @return an infinite Iterator, in which the `next()` method produces the
   *  next prime number. */
  def primeIteratorSieve[T: Integral] = new Iterator[T] {
	val integralType = implicitly[Integral[T]]
	import integralType._
	val two = integralType.fromInt(2)
	val three = integralType.fromInt(3)
    override val hasNext: Boolean = true
    override def next(): T = {
      @tailrec def sieve(x: T): T = {
        if (x == two) {
          three
        } else {
          val xn = x + two
          if (primeList.forall(xn % _ != 0)) {
            xn
          } else {
            sieve(xn)
          }
        }
      }
      val lastPrime = primeList.head
      primeList = sieve(lastPrime) :: primeList
      lastPrime
    }
    private [this] var primeList: List[T] = List(two)
  }
  
}