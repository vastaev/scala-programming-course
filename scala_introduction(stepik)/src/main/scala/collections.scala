object collections {
  def main(args: Array[String]) {
    val ints: List[Int] = List(0, 1, 1, 0, 0)
    val res = ints.partition(x => x % 10 == 0)
    println(res._1.mkString(" "))
    println(res._2.mkString(" "))
  }
}
