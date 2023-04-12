package recfun

object main extends App{

  def f(a: String)(b: Int)(c: Boolean): String = {
    "(" + a + ", " + b + ", " + c + ")"
  }

  val e: Int => Boolean => String = f("aaa")
  val ee = e(1)(true)
  println(ee)

}
