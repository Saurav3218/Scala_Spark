object scala_basic {
   def test(str1: String, n: Int): String = {
    str1 * n;
  }

   def main(args: Array[String]): Unit = {
      println("Result: " + test("Scala", 2));
      println("Result: " + test("Python",1));
      println("Result: " + test("JS",6));      
    }
  }
