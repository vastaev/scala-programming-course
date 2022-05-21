package lectures.week2oop

class Student(val id: Int, val name: String)

class Employee(val name: String, var salary: Double) {
  def this() = this("John", 0)
}

object ClassesOOP extends App {
  val employee = new Employee()
  println(s"${employee.name}'s salary is ${employee.salary}")
}
