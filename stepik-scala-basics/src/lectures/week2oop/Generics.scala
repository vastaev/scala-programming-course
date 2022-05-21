package lectures.week2oop


object Generics extends App {
  class Fruit
  class Banana extends Fruit
  class Apple extends Fruit

  class InvariantList[A]
  val invariantFruitList: InvariantList[Fruit] = new InvariantList[Fruit]

  class ContravariantList[-A]
  val contravariantList: ContravariantList[Apple] = new ContravariantList[Fruit]

  class Food[T <: Fruit](fruit: T)
  val food = new Food(new Banana)
  class Pizza
//  val moreFood = new Food(new Pizza) //inferred type arguments

  class CovariantList[+A]
  val fruitList: CovariantList[Fruit] = new CovariantList[Apple]
}
