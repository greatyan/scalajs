package alg

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class StackTest extends FlatSpec with Matchers {

  "A Stack" should "has constructor" in {
    val stack = Stack(1,2,3)
    stack.toString should be ("Stack(1, 2, 3)");
  }

  it should "has push/pop/isEmpty/size" in {
    val stack = new Stack[Int]()
    stack.isEmpty should be (true)
    stack.size should be (0)
    stack.push(1)
    stack.isEmpty should be (false)
    stack.size should be (1)
    stack.push(2)
    stack.isEmpty should be (false)
    stack.size should be (2)
    stack.pop() should be (2)
    stack.size should be (1)
    stack.push(3)
    stack.isEmpty should be (false)
    stack.size should be (2)
    stack.pop() should be (3)
    stack.pop() should be (1)
    stack.isEmpty should be (true)
    stack.size should be (0)
  }

  it should "like Iterable" in {
    val stack = Stack(1,2,3)
    stack.mkString(",") should be ("1,2,3")
  }
}
