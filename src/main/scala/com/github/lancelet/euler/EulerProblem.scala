package com.github.lancelet.euler

/** Defines a Project Euler problem. */
trait EulerProblem {
  def number: Int
  def solution: String
  
  /** The expected solution should be filled in once the problem has been
   *  completed, so that it can be checked (similar to a test case). */
  def expected: Option[String] = None
}
