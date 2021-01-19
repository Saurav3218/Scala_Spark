package com.scala.basic_program

object Scala_String {

  def main(args: Array[String]): Unit = {
  val s1="The Quick BroWn FoX"

    // Convert the above string to all lowercase and uppercase.

    val lowstr=s1.toLowerCase
    val upperStr=s1.toUpperCase

    // Display of two strings for comparison.

    println("Orginal String: "+s1)
    println("String in lowercase: "+lowstr)
    println("String in upperCase: "+upperStr)

  }
}

