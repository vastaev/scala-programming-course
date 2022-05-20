package lectures.week2oop

class Button(label: String) {
  def this() = this("test")
  def click(): String = s"button -$label- has been clicked"
}

class RoundedButton(label: String) extends Button(label) {
  override def click(): String = s"rounded ${super.click()}"
}

object Inheritance {

}
