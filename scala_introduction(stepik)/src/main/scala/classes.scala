object classes extends App {
  class Waiter(name: String, order: List[String]) {
    if (order.isEmpty) println(s"My name $name")
    def giveMe(dish: String): Waiter = new Waiter(name, dish :: order)
    def complete(): List[String] = order.reverse
  }
  val waiter = new Waiter("Иван", List())
  val positions = waiter.giveMe("борщ").giveMe("хлеб").complete()
}
