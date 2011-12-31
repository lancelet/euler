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
	private [this] val integralType = implicitly[Integral[T]]
	import integralType._
	private [this] val two = fromInt(2)
	private [this] val three = fromInt(3)
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
  
  /** Computes the Fibonacci sequence: 0, 1, 2, 3, 5, 8, ...
   * 
   *  @return an infinite Iterator, in which the `next()` method produces the
   *  next number of the Fibonacci sequence. */
  def fibonacci[T: Integral] = new Iterator[T] {
    private [this] val integralType = implicitly[Integral[T]]
    import integralType._
    private [this] var s: Tuple2[T, T] = (fromInt(0), fromInt(1)) 
    override val hasNext: Boolean = true
    override def next(): T = {
      val (s0, s1) = s
      s = (s1, s0 + s1)
      s0
    }
  }
  
}
