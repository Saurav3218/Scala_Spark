object Scala_String {

  def main(args: Array[String]): Unit = {
    val s1="The quick brown fox jumps over the lazy dog."
// Replace all the d characters with 'f' characters
    val new_str=s1.replace('d','f')
    println("Orignial String:" +s1)
    println("New String :" + new_str)

  }
}
