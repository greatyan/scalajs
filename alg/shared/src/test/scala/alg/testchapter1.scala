package alg.chapter1

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class CircularRotationTest extends FlatSpec with Matchers 
{
  import alg.chapter1.CircularRotation._

  "A CircularRotation" should "return true for all empty string" in {
    isRotation("","") should be (true)
  }

  it should "return true for equal string" in {
    isRotation("ABC", "ABC") should be (true)
  }

  it should "return true for rotation string" in {
    isRotation("ABC", "BCA") should be (true)
  }

  it should "return false if one string is empty" in {
    isRotation("ABC", "") should be (false)
  }

  it should "return false for strings with different length" in {
    isRotation("ABC", "AB") should be (false)
  }

  it should "return false for none rotation string" in {
    isRotation("ABC", "AAA") should be (false)
  }
}

class BinarySearchTest extends FlatSpec with Matchers
{
  import alg.chapter1.BinarySearch._

  val values = Array(0, 1, 2, 4, 5)

  "A BinarySearch" should "return false for empty list" in {
    search(0, Array[Int]()) should be (false) 
  }

  it should "search values with only 1 " in {
    val values = Array(0)
    search(-1, values) should be (false) 
    search(0, values) should be (true) 
    search(1, values) should be (false) 
  }


  it should "return true for first item" in {
    search(0, values) should be (true) 
  }

  it should "return true for last item" in {
    search(5, values) should be (true) 
  }

  it should "return true for mid item" in {
    search(2, values) should be (true) 
  }

  it should "return true for existing item" in {
    search(1, values) should be (true) 
  }

  it should "return false for smaller item" in {
    search(-1, values) should be (false) 
  }

  it should "return false for larger item" in {
    search(6, values) should be (false) 
  }

  it should "return false for missing item" in {
    search(3, values) should be (false) 
  }
}
