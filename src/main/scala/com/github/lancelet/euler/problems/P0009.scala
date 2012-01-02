package com.github.lancelet.euler.problems
import com.github.lancelet.euler.EulerProblem

/** There exists exactly one Pythagorean triple for which a + b + c = 1000,
 *  and a < b < c.  Find the product a * b * c. */
object P0009 extends EulerProblem {
  val number = 9
  override val expected = Some("31875000")
  def solution: String = {
    
    val maxNum = 1000
    val (a,b,c) = (for {
      i <- 1 to maxNum
      j <- i to (maxNum - i)
      k <- j to (maxNum - i - j)
      if (i + j + k == 1000)
      if (i * i + j * j == k * k)
    } yield (i, j, k)).head
    
    (a * b * c).toString

  }
}
