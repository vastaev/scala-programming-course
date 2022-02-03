import scala.io.StdIn.readLine

object ex01 extends App {
  val Array(a, b, n) = readLine().split(" ").map(_.toInt)
  if (a - b == n + 1) println("YES")
  else println("NO")
}
