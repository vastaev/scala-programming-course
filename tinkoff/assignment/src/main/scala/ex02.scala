import scala.annotation.tailrec
import scala.io.StdIn.readLine

object ex02 extends App {
  def findSquares(n: BigInt, m: BigInt): BigInt =
  {
    @tailrec def f(x: BigInt, y:BigInt, acc: BigInt = 0): BigInt=
    {
      if (x == y) acc + 1
      else if (x > y) f(x - y, y, acc + 1)
      else f(x, y - x, acc + 1)
    }
    f(n, m)
  }
  val Array(n, m) = readLine().split(" ").map(_.toInt)
  println(findSquares(n, m))
}
