package com.scala.basic_program

//Write a Scala program to remove the character in a given position of a given string.
// The given position will be in the range 0...string length -1 inclusive.
object scala_basics {
  def removeStr(s1:String ,n: Int):String={
    s1.take(n)+ s1.drop(n+1);
    //

  }

  def main(args: Array[String]): Unit = {
    println(removeStr("Saurav",4))
    println(removeStr("Siddharth",2))
  }
}
