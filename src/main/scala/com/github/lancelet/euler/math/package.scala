package com.github.lancelet.euler

import scala.annotation.tailrec
import scala.collection.Iterator
import scala.collection.immutable.List
import scala.collection.immutable.Vector
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
      val lastPrime = primeList.last
      primeList = primeList :+ sieve(lastPrime)
      lastPrime
    }
    private [this] var primeList: Vector[T] = Vector(two)
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
  
  /** Computes the prime factors of a number.  The prime factors are returned
   *  in increasing order.
   * 
   *  @param x number for which to compute the prime factors
   *  @param primeStream stream of prime numbers to use for the computation.
   *  The stream can be re-used among multiple calls to primeFactorsS, so that
   *  the primes are cached.
   *  @return the prime factors of `x`, sorted in increasing order. */
  def primeFactorsS[T: Integral](x: T, primeStream: Stream[T]): List[T] = {
    val integralType = implicitly[Integral[T]]
    import integralType._
    require(x >= fromInt(2), "x must be >= 2")
    @tailrec
    def accumFactors(factors: List[T], cands: Stream[T], x: T): List[T] = {
      if (x == 1) {
        factors
      } else {
        val ncands = cands.dropWhile(x % _ != 0)
        val nprime = ncands.head
        accumFactors(nprime :: factors, ncands, x / nprime)
      }
    }
    accumFactors(List.empty[T], primeStream, x).reverse
  }
  
  /** Computes the prime factors of a number.  The prime factors are returned
   *  in increasing order.
   *  
   *  @param x number for which to compute the prime factors
   *  @return the prime factors of `x`, sorted in increasing order. */
  def primeFactors[T: Integral](x: T): List[T] = 
    primeFactorsS(x, primeIteratorSieve[T].toStream)
  
}
