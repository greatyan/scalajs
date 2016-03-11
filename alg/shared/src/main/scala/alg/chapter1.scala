package alg.chapter1

object CircularRotation {

  def isRotation(s1:String, s2:String) : Boolean = {
    if ( s1.length == s2.length) {
      if ( s1.length == 0) {
        true
      } else {
        s2.zipWithIndex.
          filter(_._1 == s1.charAt(0)).
          map(_._2).
          exists(
            isRotation(s1, s2, _)
          )
      }
    } else {
      false
    }
  }

  private def isRotation(s1:String, s2:String, offset:Int): Boolean = {
    //println( "TRY " + s1 + " with " + s2 + " at " + offset)
    val notEqual = s1.zipWithIndex.exists { 
      case (c : Char, i : Int) =>  {
        val index =  (offset + i) % s2.length
        val c2 = s2.charAt(index)
        //println(index + ":" + c2 + "==" + c)
        c != c2
      }
    }
    //println(!notEqual)
    !notEqual
  }
}

object BinarySearch {

  def search(value:Int, values : Array[Int]) :Boolean = {
    if (values.length == 0) {
      false
    } else {
      search(value, values, 0, values.length-1)
    }
  }

  private def search(value:Int, values : Array[Int], start:Int,end:Int) : Boolean = {

    if ( start > end) {
      false
    } else {
      val mid = start + (end-start)/2
      if ( value == values(mid)) {
        true;
      }
      else if ( value < values(mid)) {
        search(value, values, start, mid-1)
      } else {
        search(value, values, mid+1, end)
      }

    }
  }
}

final class Rational(v1: Int, v2: Int) {

  val (numerator:Int, denominator :Int) = {
    import scala.math._
    import Rational._

    require( v2 != 0)
    
    if (v1 == 0) {
      (0,1)
    } else {
      val (n, d) = if (v2 < 0) (-v1, -v2) else (v1, v2)
      val g = gcd(abs(n), d)

      (n/g, d/g)
    }
  }

 
  def + (that : Rational) : Rational = {
    Rational(
      numerator * that.denominator + that.numerator * denominator,
      denominator * that.denominator
    )
  }

  def - (that : Rational) : Rational = {
    Rational(
      numerator * that.denominator - that.numerator * denominator,
      denominator * that.denominator
    )
  }

  def * (that : Rational) : Rational = {
    Rational(
      numerator * that.numerator,
      denominator * that.denominator
    )
  }

  def / (that : Rational) : Rational = {
    Rational(
      numerator * that.denominator,
      denominator * that.numerator
    )
  }

  override def equals ( that : Any) : Boolean = {
    that match {
      case t : Rational => numerator == t.numerator && denominator == t.denominator
      case _ => false
    }
  }

  override def hashCode() : Int =  {
    31 * numerator + 33 * denominator
  }

  override def toString() = numerator + "/" + denominator
}

object Rational {

  import scala.annotation.tailrec

  def apply(numerator:Int) = new Rational( numerator, 1)
  def apply(numerator:Int, denominator:Int) = new Rational(numerator, denominator)
  implicit def intToRational( value:Int) = new Rational(value, 1)

  @tailrec def gcd(v1:Int, v2:Int): Int = {
    require(v1 > 0)
    require(v2 >= 0)
    if ( v2 == 0) v1 else gcd (v2, v1 % v2)
  }

}
