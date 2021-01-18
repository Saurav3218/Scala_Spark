object scala_basics {

  def test(str1: String): String =
  {
    val len = str1.length
    val last = str1.charAt(len - 1)
    last + str1 + last
  }

  def main(args: Array[String]): Unit = {
    println("Result: " + test("Scala"));
    println("Result: " + test("abcd"));
    println("Result: " + test("ab"));
    println("Result: " + test("a"));
  }
}
