package com.github.lancelet.euler.problems
import com.github.lancelet.euler.EulerProblem

/** Find the largest palindrome made from the product of 2 x 3 digit numbers.
 */
object P0004 extends EulerProblem {
  val number = 4
  override val expected = Some("906609")
  def solution: String = {
    
    // Maximum possible number obtained from multiplying 2 x 3 digit numbers
    val maxNum: Int = 999 * 999
    
    // Checks if a number has two three digit factors.
    def has3DFactors(x: Int): Boolean = {
      if (x < (100*100) || (x > maxNum)) {
        false
      } else {
        val n = Stream.range(100, 999)
        def is3DigitNum(x: Int): Boolean = (x >= 100 && x <= 999)
        n.find(d => (x % d == 0) && is3DigitNum(x / d)).isDefined
      }
    }
    
    // Checks if a number is a palindrome.
    def isPalindrome(x: Int): Boolean = {
      val s = x.toString
      s == s.reverse
    }

    // Find the maximum number which is a palindrome with 2 x 3 digit factors
    val ns = (maxNum to 100 by -1)
    ns.find(x => isPalindrome(x) && has3DFactors(x)).get.toString
    
  }
}
