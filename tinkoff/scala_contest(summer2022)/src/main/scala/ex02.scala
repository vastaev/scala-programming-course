import scala.io.StdIn.readLine

case class letter(character: String, weight: Int) {
  def incrementIndex: letter = this.copy(weight = this.weight + 1)
  override def toString(): String = this.character
}

object ex02 extends App {
  val ac = readLine()
  val ab = readLine()
  val bc = readLine()
  def calculateIndex(sign: String, first: letter, second: letter): (letter, letter) = {
    if (sign == ">") (first.incrementIndex, second)
    else if (sign == "<") (first, second.incrementIndex)
    else (first, second)
  }
  if (ac == "=" && ab == "=" && bc == "=") {
    println("abc\nacb\nbac\nbca\ncab\ncba")
  }
  else {
    val (a1, c1) = calculateIndex(ac, letter("a", 0), letter("c", 0))
    val (a2, b1) = calculateIndex(ab, a1, letter("b", 0))
    val (b2, c2) = calculateIndex(bc, b1, c1)
    val res = List(a2, b2, c2).sortBy(_.weight)
    println(res.mkString(""))
    if (ac == "=" || ab == "=" || bc == "=") {
      if (res(2).weight == 1) {
        val splitRes = res.splitAt(1)
        println((splitRes._1 ++ splitRes._2.reverse).mkString(""))
      }
      else {
        val splitRes = res.splitAt(2)
        println((splitRes._1.reverse ++ splitRes._2).mkString(""))
      }
    }
  }
}
