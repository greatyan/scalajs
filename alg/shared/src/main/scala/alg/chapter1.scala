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
