package lectures.week1basics

object Recursion extends App {
  def powerOfTwo(power: Int): BigInt = {
    def loop(n: Int, acc: BigInt = 1): BigInt = {
      if (n < 1) acc
      else loop(n - 1, 2 * acc)
    }
    loop(power)
  }

  def task(x: Int, y: Int, n: Int): Unit = {
    def sumNTimes(x: Int, y: Int, n: Int): Int = {
      def loop(acc: Int, y: Int, n: Int): Int = {
        if (n < 1) acc
        else loop(y + acc, y, n - 1)
      }
      loop(x, y, n)
    }
    val res = sumNTimes(x, y, n)
    (0 until res.toString.length).foreach(_ => print(res + " "))
    println("is the result")
  }

  def task1(input: String): String = {
    input.split(' ').filter(_.nonEmpty).reverse.mkString(" ")
  }
  println(task1("I like    Scala"))
}
