import scala.io.StdIn.readLine

object collections4 extends App {
  val list = Iterator.continually(readLine).takeWhile(_ != "END")
  println(list.
    zipWithIndex.
    collect{ case (x, i) if i % 2 != 0 => x.toInt * 2 }.
    sum)
}
