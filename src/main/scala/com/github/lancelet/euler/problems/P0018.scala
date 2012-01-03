package com.github.lancelet.euler.problems
import com.github.lancelet.euler.EulerProblem

import scala.annotation.tailrec
import scala.collection.immutable.Vector
import scala.io.Source
import scala.math.max

/** Find the maximum total moving from top to bottom in a triangle of
 *  numbers. */
object P0018 extends EulerProblem {
  val number = 18
  override val expected = Some("1074")
  def solution: String = {
    trisol("/P0018/triangle.txt").toString
  }
  
  def trisol(resource: String): Int = {
  
    // Read in the triangle from resource file
    val triangle: Vector[Vector[Int]] = {
      val stream = getClass.getResourceAsStream(resource)
      val lines = Source.fromInputStream(stream).getLines
      val intLines = (Vector.empty[Vector[Int]] ++ lines.map(
        Vector.empty[Int] ++ _.trim.split(" ").map(_.toInt)
      )).reverse
      stream.close
      intLines
    }
    
    // Process a pair of vectors to find the optimal sum path from one to the
    //  next.
    def optimalPath(longer: Vector[Int], shorter: Vector[Int]): Vector[Int] = {
      require(longer.length == shorter.length + 1)
      val maxPair = Vector.empty[Int] ++ longer.sliding(2,1).map {
        case Vector(a,b) => max(a,b)
      }
      maxPair.zip(shorter).map { case (a,b) => a + b }
    }
 
    // Process the triangle, eliminating the top row until nothing is left
    @tailrec def processTri(t: Vector[Vector[Int]]): Int = {
      if (t.length == 1) {
        require(t(0).length == 1)
        t(0)(0)
      } else {
        val newTri = (Vector.empty[Vector[Int]] :+ 
          optimalPath(t(0), t(1))) ++ t.drop(2)
        processTri(newTri)
      }
    }

    processTri(triangle)
    
  }
  
}
