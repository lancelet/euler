package com.github.lancelet.euler

import com.github.lancelet.euler.problems._

object EulerMain {

  val p0001to0025 = List(P0001)
  
  val problems: List[EulerProblem] = p0001to0025 ::: List.empty[EulerProblem]
  
  def main(args: Array[String]) {
    val executor = EulerExecutor(problems)
    executor.execute()
  }
  
}
