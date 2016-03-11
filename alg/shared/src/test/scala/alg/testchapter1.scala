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

class RationalTest extends FlatSpec with Matchers {

  "gcd" should "return correct" in {
    Rational.gcd(1,2) should be (1)
    Rational.gcd(2,1) should be (1)
    Rational.gcd(8,12) should be (4)
    Rational.gcd(12,8) should be (4)
  }

  "A Rational" should "has toString()" in {
    Rational(1,1).toString() should be ("1/1")
    Rational(0,1).toString() should be ("0/1")
  }

  it should "normalize" in {
    val r = Rational(8,12)
    (r.numerator, r.denominator) should be ((2,3))

    val r1 = Rational(-7, -7)
    (r1.numerator, r1.denominator) should be ((1,1))

    val r2 = Rational(-7, 7)
    (r2.numerator, r2.denominator) should be ((-1,1))

    val r3 = Rational(7, -7)
    (r3.numerator, r3.denominator) should be ((-1,1))

    val r4 = Rational(0, -7)
    (r4.numerator, r4.denominator) should be ((0,1))

    val r5 = Rational(0, 7)
    (r5.numerator, r5.denominator) should be ((0,1))

    an [IllegalArgumentException] should be thrownBy Rational(1,0)

  }

  it should "support +-*/" in {
    Rational(1,2) + Rational(1,3) should be (Rational(5,6))
    Rational(1,2) - Rational(1,3) should be (Rational(1,6))
    Rational(1,2) * Rational(1,3) should be (Rational(1,6))
    Rational(1,2) / Rational(1,3) should be (Rational(3,2))
  }

  it should "has implicit convertion from int" in {
    Rational(1,2) + 1 should be (Rational(3,2))
    1 + Rational(1,2) should be (Rational(3,2))
  }

  it should "throw exception for 0" in {
    Rational(1,2) - Rational(0,1) should be (Rational(1,2))
    Rational(1,2) + Rational(0,1) should be (Rational(1,2))
    Rational(1,2) * Rational(0,1) should be (Rational(0,1))
    an [IllegalArgumentException] should be thrownBy Rational(1,2) / Rational(0,1) 

    Rational(0,1) - Rational(1,2) should be (Rational(-1,2))
    Rational(0,1) + Rational(1,2) should be (Rational(1,2))
    Rational(0,1) * Rational(1,2) should be (Rational(0,1))
    Rational(0,1) / Rational(1,2) should be (Rational(0,1))
  }
}
