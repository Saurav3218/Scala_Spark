package com.scala.basic_program

object scala_basics {

  def StringCheck(str:String):String={
    if (str.startsWith("Itunes"))"Paid " + str else "free " +str

  }
  def main(args: Array[String]): Unit = {

    println("Result " + StringCheck("Itunes"))
    println("Result " + StringCheck("Macbook_Pro"))

  }

}
