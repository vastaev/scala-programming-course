import objects.Point.show

object objects extends App {
  class Point(val x: Double, val y: Double, val z: Double) {
    def +(rhs: Point): Point = {
      new Point(this.x + rhs.x, this.y + rhs.y, this.z + rhs.z)
    }
  }
  object Point {
    def apply(x: Double, y: Double, z: Double): Point = new Point(x, y, z)
    def average(points: List[Point]): Point = {
      points match {
        case Nil => Point(0, 0, 0)
        case _ =>
          val numOfPoints = points.length
          val summed = points.foldLeft(Point(0, 0, 0))(_ + _)
          new Point(summed.x / numOfPoints, summed.y / numOfPoints, summed.z / numOfPoints)
      }
    }
    def show(point: Point): String = s"${point.x} ${point.y} ${point.z}"
  }
  val p1 = new Point(1, 2.5, 4)
  val p2 = new Point(4, 3.5, 6)
  val pList = List(p1, p2)
  val avg = Point.average(pList)
  println(show(avg))
}
