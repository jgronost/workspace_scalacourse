package week4

trait Expr {
	def eval(e: Expr): Int = e match{
	  case Number(n) => n
	  case Sum(e1, e2) => eval(e1) + eval(e2)
	}
	
	def show(e: Expr): String = e match {
	  case Number(n) => n toString
	  case Sum(e1, e2) => show(e1) + " + " + show(e2) 
	  
	}
}

case class Number(n: Int) extends Expr {
	//classification
//  def isNumber = true
//  def isSum = false
  //accessors
//  def numValue =  n
//  def leftOp: Expr = throw new Error("Number.leftOp")
//  def rightOp: Expr  = throw new Error("Number.rightOp")
}

case class Sum(e1: Expr, e2: Expr) extends Expr{
	//classification
//  def isNumber = false
//  def isSum = true
  //accessors
//  def numValue =  throw new Error("Sum.numValue")
//  def leftOp: Expr = e1
//  def rightOp: Expr  = e2
}