/**
  * Created by oleg.baydakov on 29/04/2017.
  */
import com.cra.figaro.language.Flip
import com.cra.figaro.library.compound.If
import com.cra.figaro.language.Select
import com.cra.figaro.algorithm.factored.VariableElimination
import com.cra.figaro.library.atomic.continuous.Normal
import com.cra.figaro.algorithm.sampling.Importance


object Test extends App{

  val sunnyToday = Flip(0.2)
  println(VariableElimination.probability(sunnyToday, true))

  val greetingToday = If(sunnyToday,
    Select(0.6 -> "Hello, world!", 0.4 -> "Howdy, universe!"),
    Select(0.2 -> "Hello, world!", 0.8 -> "Oh no, not again"))

  greetingToday.observe("Hello, world!")

  println(VariableElimination.probability(sunnyToday, true))

  val temperature = Normal(40, 100)
  def greaterThan50(d: Double) = d > 50
  println(Importance.probability(temperature, greaterThan50 _))


}
