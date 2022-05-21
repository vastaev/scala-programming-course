package lectures.week2oop

case class Course(title: String, instructor: String)

object Course {
  def apply(instructor: String): Course = Course("AdvancedScala", instructor)
}


object CaseClasses {
  val scalaCourse = Course("Scala", "Bob")
  val s1 = Course("Bob")
  val s2 = new Course("Scala", "Bob")
  val s3 = scalaCourse.copy("AdvancedScala")
  val s4 = scalaCourse.copy()
//  val s5 = new Course("Scala")
  val s6 = Course("Scala", "Bob")
}
