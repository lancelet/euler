package com.github.lancelet.euler.problems
import com.github.lancelet.euler.EulerProblem

/** Find the maximum total moving from top to bottom in a triangle of
 *  numbers (same as problem 18). */
object P0067 extends EulerProblem {
  val number = 67
  override val expected = Some("7273")
  def solution: String = {
    import P0018.trisol
    trisol("/P0067/triangle.txt").toString
  }
}