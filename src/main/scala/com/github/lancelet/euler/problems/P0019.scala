package com.github.lancelet.euler.problems
import com.github.lancelet.euler.EulerProblem

/** How many Sundays fell on the first of the month during the 20th century
 *  (1 Jan 1901 to 31 Dec 2000)? */
object P0019 extends EulerProblem {
  val number = 19
  override val expected = Some("171")
  def solution: String = {
    
    // Checks if a year is a leap year
    def isLeapYear(year: Int): Boolean = {
      val is4 = (year % 4 == 0)
      val isCentury = (year % 100 == 0)
      val is4Century = (year % 400 == 0)
      is4 && (!isCentury || is4Century)
    }
    
    // Returns number of days in month (1 = Jan, ..., 12 = Dec).
    def nDaysInMonth(month: Int, year: Int): Int = {
      require(month >= 1 && month <= 12)
      val days30: List[Int] = List(4, 6, 9, 11)
      if (month == 2) {
        if (isLeapYear(year)) 29 else 28
      } else if (days30 contains month) {
        30
      } else {
        31
      }
    }    
    
    // Number of days per month from 1 Jan 1900 to 1 Jan 1901
    val daysFrom1900To1901: Int = {
      (1 to 12).map(nDaysInMonth(_, 1900)).sum
    }
    // Day of the week corresponding to 1 Jan 1901 (0 = Sun, 1 = Mon, 6 = Sat)
    //  (NB: We know that 1 Jan 1900 was a Monday; from the problem statement.)
    val jan1_1901 = daysFrom1900To1901 % 7 + 1 // (should be 2 = Tuesday)
    
    // Accumulate number of days per month from 1 Jan 1901 to 1 Dec 2000
    val accumDays = for {
      year <- 1901 to 2000
      month <- 1 to 12
    } yield nDaysInMonth(month, year)
    // Find cumulative sum
    val cumSum = accumDays.scanLeft(0)(_ + _).drop(1)
    // Add the starting day offset to the cumulative sum
    val cumSumOfs = cumSum.map(_ + jan1_1901)
    
    // Determine how many elements of cumSumOfs are divisible by 7
    val nSundays = cumSumOfs.count(_ % 7 == 0)
    
    nSundays.toString
    
  }
}
