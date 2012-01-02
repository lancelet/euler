package com.github.lancelet.euler.problems
import com.github.lancelet.euler.EulerProblem

import scala.collection.immutable.Map

/** If all the numbers from 1 to 1000 inclusive were written out in words,
 *  how many letters would be used?  (Don't count spaces or hyphens.) */
object P0017 extends EulerProblem {
  val number = 17
  override val expected = Some("21124")
  def solution: String = {
    
    val baseNumbers = Map(
      1  -> "one",
      2  -> "two",
      3  -> "three",
      4  -> "four",
      5  -> "five",
      6  -> "six",
      7  -> "seven",
      8  -> "eight",
      9  -> "nine",
      10 -> "ten",
      11 -> "eleven",
      12 -> "twelve",
      13 -> "thirteen",
      14 -> "fourteen",
      15 -> "fifteen",
      16 -> "sixteen",
      17 -> "seventeen",
      18 -> "eighteen",
      19 -> "nineteen",
      20 -> "twenty",
      30 -> "thirty",
      40 -> "forty",
      50 -> "fifty",
      60 -> "sixty",
      70 -> "seventy",
      80 -> "eighty",
      90 -> "ninety"
    )
    
    def numberBelow100(x: Int): String = {
      require(x < 100)
      if (x <= 20) baseNumbers(x)
      else {
        val decStr = baseNumbers(x / 10 * 10)
        val uni = x % 10
        if (uni == 0) decStr else decStr + "-" + baseNumbers(uni)
      }
    }
    
    def numberAboveOrAt100(x: Int): String = {
      require(x >= 100)
      if (x == 1000) "one thousand"
      else {
        val hun = x / 100
        val dec = x - (hun * 100)
        if (dec == 0) {
          baseNumbers(hun) + " hundred "
        } else {
          baseNumbers(hun) + " hundred and " + numberBelow100(dec)
        }
      }
    }
    
    def numToStr(x: Int): String = {
      if (x < 100) numberBelow100(x) else numberAboveOrAt100(x)
    }
    
    def numToStrCompact(x: Int): String = {
      numToStr(x).filterNot(y => y == ' ' || y == '-')
    }
    
    (1 to 1000).map(numToStrCompact(_)).map(_.length).sum.toString
    
  }
}
