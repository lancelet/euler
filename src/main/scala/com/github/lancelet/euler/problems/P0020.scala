package com.github.lancelet.euler.problems
import com.github.lancelet.euler.EulerProblem

import scala.annotation.tailrec
import scala.collection.immutable.Seq
import scala.collection.immutable.Vector
import java.math.BigInteger

/** Find the sum of the digits in the number 100! */
object P0020 extends EulerProblem {
  val number = 20
  override val expected = Some("648")
  def solution: String = {
    
    // Factorial function
    def factorial(n: Int): BigInteger = {
      @tailrec
      def prodFactorial(product: BigInteger, n: Int): BigInteger = {
        if (n == 1) product
        else prodFactorial(product.multiply(BigInteger.valueOf(n)), n - 1)
      }
      prodFactorial(BigInteger.ONE, n)
    }
    
    // Finds the sum of digits in a BigInteger
    def sumOfDigits(n: BigInteger): Int = {
      val ten = BigInteger.valueOf(10)
      @tailrec def accDig(d: Vector[Int], rem: BigInteger): Seq[Int] = {
        if (rem.equals(BigInteger.ZERO)) d
        else accDig(d :+ rem.mod(ten).intValue, rem.divide(ten))
      }
      accDig(Vector.empty[Int], n).sum
    }
    
    sumOfDigits(factorial(100)).toString
    
  }
}
