package exercises

import java.lang.annotation.Target
import javax.swing.tree.TreeNode
import scala.annotation.tailrec

abstract class BinaryTree[+T] {
  def value: T

  def leftChild: BinaryTree[T]

  def rightChild: BinaryTree[T]

  def isEmpty: Boolean

  def isLeaf: Boolean

  def collectLeaves: List[BinaryTree[T]]

  def nodesAtLevel(level: Int): List[BinaryTree[T]]

  def collectNodes(): List[T] = List()
}

case class Node[+T](
                     override val value: T,
                     override val leftChild: BinaryTree[T],
                     override val rightChild: BinaryTree[T])
  extends BinaryTree[T] {

  override def isEmpty: Boolean = false

  override def isLeaf: Boolean = leftChild.isEmpty && rightChild.isEmpty

  override def collectLeaves: List[BinaryTree[T]] = {
    def loop(toInspect: List[BinaryTree[T]] = List(this), leaves: List[BinaryTree[T]] = List()): List[BinaryTree[T]] = toInspect match {
      case Nil => leaves
      case x :: xs => x match {
        case TreeEnd => loop(xs, leaves)
        case Node(_, TreeEnd, TreeEnd) => loop(xs, leaves :+ x)
        case _ => loop(x.leftChild :: x.rightChild :: xs, leaves)
      }
    }

    loop()
  }

  override def nodesAtLevel(level: Int): List[BinaryTree[T]] = {
    @tailrec
    def loop(toInspect: List[BinaryTree[T]] = List(this), point: Int = level): List[BinaryTree[T]] = toInspect match {
      case Nil => toInspect
      case _ if point == 0 => toInspect
      case _ => loop(toInspect.flatMap { n => List(n.leftChild, n.rightChild) }.filterNot(_.isEmpty), point - 1)
    }

    loop()
  }

  override def collectNodes(): List[T] = {
    def loop(toInspect: List[BinaryTree[T]] = List(this),
             acc: List[BinaryTree[T]] = List()): List[BinaryTree[T]] = toInspect match {
      case Nil => acc
      case _ => loop(toInspect.flatMap { n => List(n.leftChild, n.rightChild) }.filterNot(_.isEmpty), acc ++ toInspect)
    }

    loop().map(_.value)
  }
}

case object TreeEnd extends BinaryTree[Nothing] {
  override def value: Nothing = throw new NoSuchElementException

  override def leftChild: BinaryTree[Nothing] = throw new NoSuchElementException

  override def rightChild: BinaryTree[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true

  override def isLeaf: Boolean = false

  override def collectLeaves: List[BinaryTree[Nothing]] = List()

  override def nodesAtLevel(level: Int): List[BinaryTree[Nothing]] = List()

  override def collectNodes(): List[Nothing] = List()
}

object Trees extends App {
  val tree = Node(1,
    Node(2,
      Node(4,
        TreeEnd,
        TreeEnd),
      Node(5,
        TreeEnd,
        Node(8,
          TreeEnd,
          TreeEnd))),
    Node(3,
      Node(6,
        TreeEnd,
        TreeEnd),
      Node(7,
        TreeEnd,
        TreeEnd)))

  //  def hasPath(tree: BinaryTree[Int], target: Int): Boolean = {
  //    def targetToChildren(target: Int, nodeValue: Int): Int = target - nodeValue
  //    def loop(queue: List[(BinaryTree[Int], Int)],
  //             step: BinaryTree[Int],
  //             target: Int): Boolean = step match {
  //      case Node(value, TreeEnd, TreeEnd) =>
  //        if (target - value == 0) true
  //        else if (queue.isEmpty) false
  //        else loop(queue.tail, queue.head._1, queue.head._2)
  //      case Node(value, leftChild, TreeEnd) =>
  //        loop(queue, leftChild, targetToChildren(target, value))
  //      case Node(value, TreeEnd, rightChild) =>
  //        loop(queue, rightChild, targetToChildren(target, value))
  //      case Node(value, leftChild, rightChild) =>
  //        val toChildren = targetToChildren(target, value)
  //        loop((rightChild, toChildren) +: queue, leftChild, toChildren)
  //    }
  //    if (tree.isEmpty) false
  //    else {
  //      val toChildren = targetToChildren(target, tree.value)
  //      loop(List((tree.rightChild, toChildren)), tree.leftChild, toChildren)
  //    }
  //  }
  def hasPath(tree: BinaryTree[Int], target: Int): Boolean = {
    def loop(queue: List[(Int, BinaryTree[Int])]): Boolean = {
      queue match {
        case Nil => false
        case (0, head) :: _ if head.isEmpty => true
        case (_, head) :: tail if head.isEmpty => loop(tail)
        case (x, head) :: tail =>
          val y = x - head.value
          loop((y, head.leftChild) :: (y, head.rightChild) :: tail)
      }
    }

    loop(List((target, tree)))
  }

  //  println("test true 7 " + hasPath(tree, 7))
  //  println("test true 16 " + hasPath(tree, 16))
  //  println("test true 10 " + hasPath(tree, 10))
  //  println("test true 11 " + hasPath(tree, 11))
  //  println("test false 30 " + hasPath(tree, 30))
  //  println("test false 3 " + hasPath(tree, 3))
  def findAllPaths(tree: BinaryTree[String], target: String): List[List[String]] = {
    def sum(a: String, b: String): String = {
      val t1 = a.toList
      val t2 = b.toList
      def myToInt(num: List[Char], acc: Int = 0): Int = {
        if (num.isEmpty) acc
        else myToInt(num.tail, (num.head - '0') + acc * 10)
      }
      (myToInt(t1) + myToInt(t2)).toString
    }
    def loop(queue: List[(BinaryTree[String], List[String])],
             step: BinaryTree[String],
             acc: List[List[String]],
             tmp: List[String]): List[List[String]] = step match {
      case Node(value, TreeEnd, TreeEnd) =>
        if (queue.isEmpty) (value +: tmp) +: acc
        else loop(queue.tail, queue.head._1, (value +: tmp) +: acc, queue.head._2)
      case Node(value, leftChild, TreeEnd) =>
        loop(queue, leftChild, acc, value +: tmp)
      case Node(value, TreeEnd, rightChild) =>
        loop(queue, rightChild, acc, value +: tmp)
      case Node(value, leftChild, rightChild) =>
        loop((rightChild, value +: tmp) +: queue, leftChild, acc, value +: tmp)
    }
    if (tree.isEmpty) List()
    else loop(List(), tree, List(), List()).filter(_.
      reduce(sum) == target).
      map(_.reverse).reverse
  }
  val stringTree = Node("1",
    Node("2",
      Node("4",
        TreeEnd,
        TreeEnd),
      Node("5",
        TreeEnd,
        Node("8",
          TreeEnd,
          TreeEnd))),
    Node("3",
      Node("6",
        TreeEnd,
        TreeEnd),
      Node("7",
        TreeEnd,
        TreeEnd))
  )
  val stringTree2 = Node("1",
    Node("12",
      Node("4",
        TreeEnd,
        Node("8",
          TreeEnd,
          TreeEnd)),
      Node("5",
        TreeEnd,
        TreeEnd)),
    Node("3",
      Node("6",
        TreeEnd,
        TreeEnd),
      Node("7",
        TreeEnd,
        TreeEnd))
  )

  println(findAllPaths(stringTree2, "25"))
}