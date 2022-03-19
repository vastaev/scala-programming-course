import scala.io.StdIn.readInt

object ex01 extends App {
  val a = readInt()
  val b = readInt() / readInt()
  if (a > b) println("Yes") else println("No")
}
