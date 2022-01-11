object CJ04 extends App {
  val weight = Array(89, 46, 134, 78, 79, 67, 63, 81)
  val weight1 = Array(210, 210, 210, 210, 210, 210, 210, 210, 210)
  val weight2 = Array(105, 105, 210, 210, 210)
  def getResult(weight: Array[Int]): Int = {
    def findTriplet(weights: List[Int], closestSum: List[Int] = List(777, 777, 777)): List[Int] = {
      def sumHeadLastInt(list: List[Int], n: Int): Int = list.head + list.last + n

      def f(weightsTail: List[Int], weightsHead: Int, closestSum: List[Int]): List[Int] = {
        if (weightsTail.length < 2) closestSum
        else {
          val sum = sumHeadLastInt(weightsTail, weightsHead)
          if (sum == 210) List(weightsTail.head, weightsTail.last, weightsHead)
          else if (sum < 210 && (210 - sum).abs < (210 - closestSum.sum).abs) f(weightsTail, weightsHead, List(weightsTail.head, weightsTail.last, weightsHead))
          else if (sum > 210) f(weightsTail.init, weightsHead, closestSum)
          else f(weightsTail.tail, weightsHead, closestSum)
        }
      }

      weights match {
        case Nil => closestSum
        case x :: xs =>
          val res = f(xs, x, closestSum)
          if (sumHeadLastInt(res, x) == 210) List(res.head, res.last, x)
          else findTriplet(xs, res)
      }
    }
    def findDoublet(weights: List[Int], closestSum: List[Int] = List(777, 777)): List[Int] = {
      if (weights.length < 2) closestSum
      else {
        val listHead = weights.head
        val listLast = weights.last
        val sum = listHead + listLast
        if (sum == 210) List(listHead, listLast)
        else if (sum < 210 && sum.abs < closestSum.sum.abs) findDoublet(weights, List(listHead, listLast))
        else if (sum > 210) findDoublet(weights.init, closestSum)
        else findDoublet(weights.tail, closestSum)
      }
    }
    val sortedWeights = weight.sortWith(_ < _).toList
    def carsNeeded(weights: List[Int]): Int = {
      def f(weights: List[Int], carsCounter: Int = 0): Int = {
        if (weights.length == 1) carsCounter + 1
        else if (weights.isEmpty) carsCounter
        else {
          val listWithoutHeaviest = weights.init
          val triplet = findTriplet(listWithoutHeaviest)
          if (triplet.sum <= 210) f(listWithoutHeaviest.diff(triplet), carsCounter + 1)
          else {
            val doublet = findDoublet(listWithoutHeaviest)
            if (doublet.sum <= 210) f(listWithoutHeaviest.diff(doublet), carsCounter + 1)
            else f(listWithoutHeaviest.init, carsCounter + 1)
          }
        }
      }
      f(weights)
    }
    carsNeeded(sortedWeights)
  }
  println(getResult(weight) + " " + "2")
  println(getResult(weight1) + " " + "5")
  println(getResult(weight2) + " " + "2")
}
