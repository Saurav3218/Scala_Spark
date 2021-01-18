//Scala program to check whether a given positive number is a multiple of 3 or a multiple of 7.
object scala_basics {

  def  checkedNumber(n:Int):Boolean={

    n%3==0 || n%7==0
  }

  def main(args: Array[String]): Unit = {
    println(checkedNumber(32))
    println(checkedNumber(21))
    println(checkedNumber(33))
    println(checkedNumber(59))
  }
}
