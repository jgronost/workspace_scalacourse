package week3

object rationals {
  val x = new Rational(1,3)                       //> x  : week3.Rational = 1/3
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 3
  
  val y = new Rational(5,7)                       //> y  : week3.Rational = 5/7
  
  val z = new Rational (3,2)                      //> z  : week3.Rational = 3/2
  
	val r = x.sub(y).sub(z)                   //> r  : week3.Rational = -79/42
	
	y.add(y)                                  //> res2: week3.Rational = 10/7
	
	x.less(y)                                 //> res3: Boolean = true
	
	y.max(x)                                  //> res4: week3.Rational = 5/7
	
	new Rational(2)                           //> res5: week3.Rational = 2/1
	

}

class Rational (x: Int, y: Int){
	require(y != 0, "denumitaor must be non zero")
	
	def this(x: Int) = this(x,1)
	
	private def gcd(a: Int, b: Int): Int = if (b==0) a else gcd (b, a % b)
	def numer = x
	def denom = y
	def less(that: Rational) = numer * that.denom < that.numer * denom
	
	def max(that:Rational) = if (this.less(that)) that else this
	
		def add(that: Rational) =
	  	new Rational(
	  		numer * that.denom + that.numer * denom,
	  		denom * that.denom
	  	)
	
  def sub(that: Rational) = add(that.neg)
  
  
  def neg: Rational  = new Rational(-numer, denom)
  
  override def toString = {
		val g = gcd(numer, denom)
	  numer / g + "/" + denom /g
  }
}