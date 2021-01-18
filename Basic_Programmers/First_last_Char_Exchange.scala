package com.scala.basic_program

//Scala program to exchange the first and last characters in a given string and return the new string
object scala_basics {

  def exchangeChar(s1:String):String={

    var len=s1.length;
    if(len <=1) s1
    else s1.charAt(len-1) +s1.substring(1,len-1)+s1.charAt(0)

  }

  def main(args: Array[String]): Unit = {
    println("Exchanged Result "+ exchangeChar("Siddharth"));
    println("Exchanged Result "+ exchangeChar("GAURAV"));
    println("Exchanged Result "+ exchangeChar("Saurav"));
  }
}

