package com.github.lancelet.euler.problems
import com.github.lancelet.euler.EulerProblem
import com.github.lancelet.euler.math._

import scala.annotation.tailrec
import scala.collection.immutable.Set

/** Find the smallest positive number that is evenly divisible by all of the
 *  numbers from 1 to 20. */
object P0005 extends EulerProblem {
  val number: Int = 5
  def solution: String = {
    
    val testNum = List.range(2, 21)
    @tailrec def sdn(x: Int): Int = 
      if (testNum.forall(x % _ == 0)) x else sdn(x + 20)
    
    sdn(20).toString
    
  }
}