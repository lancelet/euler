package com.github.lancelet.euler

import scala.collection.immutable.Set

case class EulerExecutor(problems: List[EulerProblem]) {

  // check there are no duplicate problem numbers
  private [this] val numbers = problems.map(_.number)
  private [this] val numberSet = Set.empty[Int] ++ numbers
  require(numbers.size == numberSet.size, 
    "Problems numbers are duplicated.")  
  
  def execute() {
    val sortedProblems = problems.sortBy(_.number)
    for (problem <- sortedProblems) {
      val number = problem.number
      val solution = problem.solution
      println("Problem: %d" format number)
      println("  Solution: %s" format solution)
      val expected = problem.expected
      if (expected.isDefined) {
        val e = expected.get
        if (e != solution) {
          println("  WARNING: Expected solution differs: %s" format e)
        }
      }
    }
  }

}
