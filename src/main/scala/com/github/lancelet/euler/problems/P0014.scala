package com.github.lancelet.euler.problems
import com.github.lancelet.euler.EulerProblem

import scala.annotation.tailrec
import scala.collection.mutable.{Map => MMap}

/** For a given sequence, find the starting value under 1000000 that
 *  produces the longest chain.
 *  
 *  The following sequence is defined for the set of +ve integers:
 *   n -> n / 2  if n is even
 *   n -> 3n + 1 if n is odd
 *  It is thought that all starting numbers of this sequence finish at 1.
 *  Which starting number, under 1000000, produces the longest chain?
 *  Note that, once a sequence is started, numbers may exceed 1000000. */
object P0014 extends EulerProblem {
  val number = 14
  def solution: String = {
   
    // Finds the length of the sequence, given a particular starting value.
    //  We use some caching to avoid re-computing sequences dozens of times.
    val sequenceLengthCache = MMap.empty[Long, Int]
    def calcSequenceLength(x: Long): Int = {
      @tailrec def seqLenTR(x: Long, count: Int): Int = {
        if (x == 1L) {
          1 + count
        } else if (sequenceLengthCache.contains(x)) {
          sequenceLengthCache(x) + count
        } else {
          val nextX = if (x % 2 == 0) x / 2 else 3 * x + 1
          seqLenTR(nextX, count + 1)
        }
      }
      val l = seqLenTR(x, 0)
      if (!sequenceLengthCache.contains(x)) sequenceLengthCache(x) = l
      l
    }
    
    // Determine the longest chain
    var x = 2
    var maxSeqNum = x
    var maxSeqLen = calcSequenceLength(x)
    while (x < 1000000) {
      val l = calcSequenceLength(x)
      if (l > maxSeqLen) {
        maxSeqLen = l
        maxSeqNum = x
      }
      x = x + 1
    }
    
    maxSeqNum.toString
    
  }
}

