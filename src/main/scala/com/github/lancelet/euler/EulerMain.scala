package com.github.lancelet.euler

import com.github.lancelet.euler.problems._

object EulerMain {

  val p0001to0025 = List(
    P0001, P0002, P0003, P0004, P0005,
    P0006, P0007, P0008, P0009, P0010,
    P0011, P0012
  )
  
  val problems: List[EulerProblem] = p0001to0025 ::: List.empty[EulerProblem]
  
  def main(args: Array[String]) {
    val executor = EulerExecutor(problems)
    executor.execute()
  }
  
}
