object collections3 extends App {
  val list = List(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150)
  list.filter(x => x % 4 == 0 && x < 100).map(x => x / 4).dropRight(1).foreach(println)
}
