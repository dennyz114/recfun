package recfun

import scala.annotation.tailrec

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c == -1 || c > r)
      0
    else if (c == 0 && r ==0)
      1
    else
      pascal(c-1, r-1) + pascal(c, r-1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    @tailrec
    def countBalanced(chars: List[Char], counter: Int): Int = {

      def addToCounter(nextChar: Char): Int = {
        if (nextChar.equals('('))
          counter + 1
        else if (nextChar.equals(')'))
          counter - 1
        else
          counter
      }

      if (chars.isEmpty)
        counter
      else if (counter == 0 && chars.head.equals(')'))
        -1
      else
        countBalanced(chars.tail, addToCounter(chars.head))
    }

    countBalanced(chars, 0) == 0
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money < 0)
      0
    else if (money == 0)
      1
    else if (coins.nonEmpty)
      countChange(money, coins.tail) + countChange(money - coins.head, coins)
    else 
      0
  }
