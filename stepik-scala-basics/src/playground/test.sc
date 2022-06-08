val res = List(List("1", "3", "6"), List("22", "03", "07"))
def sum(a: String, b: String): String = {
  val t1 = a.toList
  val t2 = b.toList
  def myToInt(num: List[Char], acc: Int = 0): Int = {
    if (num.isEmpty) acc
    else myToInt(num.tail, (num.head - '0') + acc * 10)
  }
  (myToInt(t1) + myToInt(t2)).toString
}
sum("25", "3")
