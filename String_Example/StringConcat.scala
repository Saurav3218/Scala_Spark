object Scala_String {

  def main(args: Array[String]): Unit = {
    val s1="Scala Exercise and "
    val s2="Python Exercise"

    println("Orignal strings")
    println("String 1 "+ s1)
    println("String 2 "+s2)

    val str3=s1.concat(s2);
    println("The concatenated String "+str3);

  }

}
