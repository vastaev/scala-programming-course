package exercises

class Instructor(val id: Int, val name: String, val surname: String) {
  def fullName(): String = name.capitalize + " " + surname.capitalize
}

class Course(val courseID: Int, val title: String, val releaseYear: String, val instructor: Instructor) {
  def getID(): Int = (courseID.toString + instructor.id.toString).toInt
  def isTaughtBy(instructor: Instructor): Boolean = instructor == this.instructor
  def copyCourse(newReleaseYear: String): Course = new Course(courseID, title, newReleaseYear, instructor)
}

object CourseIntructor extends App {
  val instructor: Instructor = new Instructor(1, "вася", "пупкин")
  println(instructor.fullName())    // Вася Пупкин

  val course: Course = new Course(2, "Course Name", "1234", instructor)
  println(course.instructor.fullName())    // Вася Пупкин
  println(course.getID)    // 21
  println(course.isTaughtBy(instructor))    // true
  println(course.isTaughtBy(new Instructor(1, "Вася", "Пупкин")))    // false

  println(course.copyCourse("4321").releaseYear)    // 4321
}
