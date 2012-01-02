package com.github.lancelet.euler.problems
import com.github.lancelet.euler.EulerProblem

import java.math.BigInteger
import scala.io.Source

/** Work out the first ten digits of the sum of a given set of one-hundred 
 *  50-digit numbers. */
object P0013 extends EulerProblem {
  val number = 13
  override val expected = Some("5537376230")
  def solution: String = {
    
    // Read in the numbers
    val numStream = getClass.getResourceAsStream("/P0013/numbers.txt")
    val tnumbers: Vector[BigInteger] = { 
      val ns = Source.fromInputStream(numStream).getLines.map(
        new BigInteger(_))
      Vector.empty[BigInteger] ++ ns
    }
    numStream.close
    
    // Sum and print the first 10 digits
    val zero = BigInteger.ZERO
    tnumbers.foldLeft(zero)(_.add(_)).toString.take(10)

  }
}