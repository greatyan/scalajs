package alg;

import scala.collection.mutable

class Bag[T] extends Iterable[T] {

  val values = new mutable.ArrayBuffer[T]()

  def this(vs: T*) {
    this()
    values.append(vs: _*)
  }

  override def iterator() : Iterator[T] = {
    values.iterator
  }

  override def toString() = {
    val sb = new StringBuilder("Bag(");
    values.addString(sb, ",")
    sb += ')'
    sb.toString
  }

  def add(v : T ) {
    values += v
  }

  override def size = values.size
  override def isEmpty = values.isEmpty
}

object Bag {
  def apply[T](vs : T* ) : Bag[T]= {
    new Bag(vs: _*)
  }
}
