package week4


//Peano numbers
abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def succesor = new Succ(this)
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat{
  def isZero = true
  def predecessor = throw new NoSuchElementException
  def +(that: Nat) = that
  def -(that: Nat) = if (that.isZero) this else throw new Error("neg number is illegal")
  
}

class Succ(n: Nat) extends Nat{
  def isZero = false;
  def predecessor = n

  def +(that: Nat) = new Succ(n + that)
  def -(that: Nat)=  if (that.isZero) this else  n - that.predecessor
}

