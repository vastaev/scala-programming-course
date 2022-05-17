trait Animal {
  val sound: String
  def voice: Unit = println("voice: " + sound + "!")
}

class Cat extends Animal {
  val sound = "Meow"
}

class Dog extends Animal {
  val sound = "Woof"
}

class Fish extends Animal {
  val sound = "Fishes are silent!"
  override def voice: Unit = println(sound)
}

object inheritance extends App {
  val animals = Seq(new Cat, new Dog, new Fish)
  animals.foreach(_.voice)
}