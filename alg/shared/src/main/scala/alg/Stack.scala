package alg

import scala.collection.mutable

class Stack[T] extends Iterable[T] {

  val values = new mutable.ListBuffer[T]()

  def this( vs : T*) {
    this()
    values ++= vs;
  }

  def push(v : T) {
    values += v;
  }

  def pop() : T  = {
    values.remove(values.size-1)
  }

  override def iterator = values.iterator 

  override def isEmpty = values.isEmpty

  override def size = values.size
}

object Stack {

  def apply[T]( vs : T*) = {
    new Stack(vs : _*)
  }
}
