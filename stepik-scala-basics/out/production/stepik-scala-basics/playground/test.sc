val res = List(List("1", "3", "6"), List("22", "03", "07"))
def sum(a: String, b: String): String = {
  val t1 = a.toList.map(_.asDigit)
  val t2 = b.toList.map(_.asDigit)
  println(t1, t2)
  val length = a.length min b.length
  println(length)
  def loop(len: Int, acc: List[Int],
           t1: List[Int], t2: List[Int]): List[Int] = {
    if (len < 0) acc
    else loop(len - 1, (t1.last + t2.last) +: acc, t1.init, t2.init)
  }
//  List(a, b).filter(_.length != length)
  loop(length - 1, List(), t1, t2).mkString
}
sum("25", "3")
