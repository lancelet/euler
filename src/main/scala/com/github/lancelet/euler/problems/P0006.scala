package com.github.lancelet.euler.problems
import com.github.lancelet.euler.EulerProblem

import scala.collection.immutable.Seq

/** Find the difference between the sum of the squares of the first 100
 *  natural numbers and the square of the sum.
 *  
 *  Using the multi-nomial theorem (or manual expansion), this problem
 *  reduces to the expression:
 *    2 * sum(a * b)
 *  where (a, b) are unique multiples from the set {1, 2, 3, ..., N}, N = 100.
 *  Eg. if N = 4, (a, b) are:
 *    (1, 2), (1, 3), (1, 4),
 *    (2, 3), (2, 4),
 *    (3, 4) */
object P0006 extends EulerProblem {
  val number = 6
  override val expected = Some("25164150")
  def solution: String = {
    
    val N: Int = 100
    
    val result = 2 * (for {
      i <- 1 to N
      j <- (i + 1) to N
    } yield (i * j)).sum 
    
    result.toString
    
  }
}
