package week4


trait List[+T] {
	def isEmpty: Boolean
	def head: T
	def tail: List[T]
	def prepend [U >: T] (elem: U): List[U] = new Cons(elem,this)
}

class Cons[T](val head: T, val tail: List[T]) extends List[T]{
  def isEmpty = false
}

object Nil extends List[Nothing]{
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object List {
  //List(1,2) = List.applay(1,2)
  def applay[T] (x1: T, x2: T) = new Cons(x1, new Cons(x2, Nil))
  
  def applay [T](x: T) = new Cons(x, Nil)
  
  def applay[T]()= Nil 
  
}