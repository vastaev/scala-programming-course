import scala.io.StdIn.readLine

object ex1 extends App {
  def makeCoins(): Unit = {
    val Array(n, m, k) = readLine().split(" ").map(_.toInt)
    val coinsToMake = m / k
    val leftFromCoins = m % k
    def f(silverLeft: Int, coins: Int = 0): Int = {
      if (silverLeft < m) coins
      else {
        val billet = silverLeft - m
        f(billet + leftFromCoins, coins + coinsToMake)
      }
    }
    println(f(n))
  }
  makeCoins()
}
