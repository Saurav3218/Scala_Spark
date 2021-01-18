package com.scala.basic_program

object scala_basics {

  def greatestNumber(x:Int,y:Int,z:Int):Int={
    //List[x,y,z].reverse
    List(x,y,z).max

  }

  def main(args: Array[String]): Unit = {
    println(greatestNumber(1,3,7))
    println(greatestNumber(23,31,7))
    println(greatestNumber(56,3,7))
    println(greatestNumber(34,78,7))
  }
}
