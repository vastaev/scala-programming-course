object genericMethods extends App {
  import scala.annotation.tailrec
  @tailrec
  def fibs(n: Int, currentNumber: Int = 1, f1: BigInt = 0, f2: BigInt = 1): BigInt = {
    if (n == currentNumber)
      f2
    else {
      fibs(n - 1, currentNumber, f2, f1 + f2)
    }
  }
  val n = 10
  println(fibs(n))
}
