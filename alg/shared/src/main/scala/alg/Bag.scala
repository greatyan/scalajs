package alg;

import scala.collection.mutable

class Bag[T] extends Iterable[T] {

  val values = new mutable.ArrayBuffer[T]()

  def this(vs: T*) {
    this()
    values ++= vs
  }

  def add(v : T ) {
    values += v
  }

  override def size = values.size
  override def isEmpty = values.isEmpty
  override def iterator = values.iterator 
}

object Bag {
  def apply[T](vs : T* ) : Bag[T]= {
    new Bag(vs: _*)
  }
}
