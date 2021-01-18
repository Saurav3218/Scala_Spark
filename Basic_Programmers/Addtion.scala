package com.scala.basic_program

// Write a Scala program to compute the sum of the two given integer values. If the two values are the same, then return triples their sum.

object Addition {
  def test(x:Int, y:Int) : Int =
  {
    if (x == y) (x + y) * 3 else x + y
  }

  def main(args: Array[String]): Unit = {
    println("Result: " + test(1, 2));
    println("Result: " + test(2, 2));
  }
}
