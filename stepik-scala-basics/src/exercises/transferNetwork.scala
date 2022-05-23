package exercises

object transferNetwork extends App {
  // добавляет локацию в маршрутную сеть
  def add(network: Map[String, Set[String]], location: String): Map[String, Set[String]] = network + (location -> Set())

  // удаляет локацию из маршрутной сети
  def remove(network: Map[String, Set[String]], location: String) = {
    def loop(destinations: Set[String], acc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (destinations.isEmpty) acc
      else loop(destinations.tail, disconnect(acc, location, destinations.head))
    val disconnected = loop(network(location), network)
    disconnected - location
  }

  // связывает две локации между собой (учитывать, что связь действует в обе стороны, т.е. становится доступным маршрут как туда, так и обратно)
  def connect(network: Map[String, Set[String]], pointA: String, pointB: String) = {
    val routesForA: Set[String] = network(pointA)
    val routesForB: Set[String] = network(pointB)
    network + (pointA -> (routesForA + pointB)) + (pointB -> (routesForB + pointA))
  }

  // удалят маршрут
  def disconnect(network: Map[String, Set[String]], pointA: String, pointB: String) = {
    val routesForAMWithoutB: Set[String] = network(pointA) - pointB
    val routesForBWithoutA: Set[String] = network(pointB) - pointA
    network + (pointA -> routesForAMWithoutB) + (pointB -> routesForBWithoutA)
  }

  // возвращает количество доступных прямых перелетов из заданной точки
  def nFlights(network: Map[String, Set[String]], location: String) = network(location).size

  // возвращает точку, из которой доступно больше всего прямых перелетов
  def mostFlights(network: Map[String, Set[String]]) = network.maxBy(location => location._2.size)._1

  // возвращает количество точек, не включенных ни в один маршрут
  def nLocationsWithNoFlights(network: Map[String, Set[String]]) = network.count(_._2.isEmpty)

  // проверяет, связаны ли две точки между собой (учитывать возможные пересадки, необходимые чтобы перелететь из одной заданной точки в другую)
  def isConnected(network: Map[String, Set[String]], pointA: String, pointB: String) =  {
    def bfs(target: String,
            pointA: Set[String],
            pointB: Set[String]): Boolean = {
      if (pointB.isEmpty) false
      else {
        val location = pointB.head
        if (location == target) true
        else if (pointA.contains(location))
          bfs(target, pointA, pointB.tail)
        else bfs(target, pointA + location,
          pointB.tail ++ network(location))
      }
    }
    bfs(pointB, Set(), network(pointA) + pointA)
  }


  import Console.{GREEN, RED, RESET}
  def printTest(name: String, network: Map[String, Set[String]]) = println(s"$RESET\n$GREEN$name$RESET\n$network")
  def printTest(name: String, network: Map[String, Set[String]], res: Any) = println(s"$RESET\n$RED$name$RESET\nResult: $res\n$network")

  val network = add(add(add(Map("Moscow" -> Set("Spb", "Ekb")), "Africa"), "Baykal"), "Mars")
  printTest("Creating network", network)

  val conMars = connect(network, "Moscow", "Mars")
  printTest("Connect Mars and Moscow", conMars)

  val disMars = disconnect(conMars, "Moscow", "Mars")
  printTest("Disconnect Mars and Moscow", disMars)

  val removeConMars = remove(conMars, "Mars")
  printTest("Remove Mars connected with Moscow ", removeConMars)

  val flightsNum = nFlights(conMars, "Moscow")
  printTest("Number of flights in Moscow", conMars, flightsNum)

  val mostFlightsRes = mostFlights(conMars)
  printTest("Most flights", conMars, mostFlightsRes)

  val emptyPoints = nLocationsWithNoFlights(conMars)
  printTest("Locations without flights", conMars, emptyPoints)

  val conMscAfricaBaykal = connect(connect(conMars, "Moscow", "Africa"), "Africa", "Baykal")
  val mscAfricaIsConnected = isConnected(conMscAfricaBaykal, "Moscow", "Africa")
  printTest("Is Connected Africa and Moscow", conMscAfricaBaykal, mscAfricaIsConnected)

  val mscBaykalIsConnected = isConnected(conMscAfricaBaykal, "Moscow", "Baykal")
  printTest("Is Connected Baykal and Moscow through Africa", conMscAfricaBaykal, mscAfricaIsConnected)
}
