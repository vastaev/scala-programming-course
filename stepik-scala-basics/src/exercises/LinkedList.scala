package exercises

import java.util.NoSuchElementException

abstract class LogList[+A] {
  def last(): A
  def previous: LogList[A]
  def isEmpty: Boolean
  def all: String
  def add[B >: A](msg: B): LogList[B]
}

class Log[+A](head: A, tail: LogList[A]) extends LogList[A] {
  override def last(): A = this.head

  override def previous: LogList[A] = this.tail

  override def isEmpty: Boolean = tail == Empty

  override def all: String = head + " " + tail.all

  override def add[B >: A](msg: B): LogList[B] = new Log[B](msg, this)
}

object Empty extends LogList[Nothing] {
  override def last(): Nothing = throw new NoSuchElementException

  override def previous: Nothing = throw new NoSuchElementException

  override def isEmpty: Boolean = this == Empty

  override def all: String = ""

  override def add[B >: Nothing](msg: B): LogList[B] = new Log(msg, Empty)
}

object LinkedList extends App {
  val list = new Log("INFO_1", new Log("INFO_2", new Log("INFO_3", Empty)))
  println(list.previous.last)

  val list1 = new Log("a", new Log("b", new Log("c", Empty)))
  println(list1.isEmpty)

  val l2 = new Log("a", Empty)
  println(l2.isEmpty)

  val l3 = new Log("m1", new Log("m2", new Log("m3", Empty)))
  println(l3.all)
}
