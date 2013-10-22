package week6

object scratch {
	val nums = Vector(1,6,2,-1)               //> nums  : scala.collection.immutable.Vector[Int] = Vector(1, 6, 2, -1)
	val people = Vector("Bob", "James", "Peter")
                                                  //> people  : scala.collection.immutable.Vector[String] = Vector(Bob, James, Pet
                                                  //| er)
	val people2 = Vector("Angelina")          //> people2  : scala.collection.immutable.Vector[String] = Vector(Angelina)
	
	people +: people2                         //> res0: scala.collection.immutable.Vector[java.io.Serializable] = Vector(Vecto
                                                  //| r(Bob, James, Peter), Angelina)
	people :+ people2                         //> res1: scala.collection.immutable.Vector[java.io.Serializable] = Vector(Bob, 
                                                  //| James, Peter, Vector(Angelina))
  
  val ns = Array(1,2,3,44)                        //> ns  : Array[Int] = Array(1, 2, 3, 44)
  ns map(x=> x*2)                                 //> res2: Array[Int] = Array(2, 4, 6, 88)
  
  val str = "Hello World"                         //> str  : String = Hello World
  str filter (c => c.isUpper)                     //> res3: String = HW
  
  val s: Range = 1 to 5                           //> s  : Range = Range(1, 2, 3, 4, 5)
  val r:Range = 1 until 5                         //> r  : Range = Range(1, 2, 3, 4)
    1 to 10 by 3                                  //> res4: scala.collection.immutable.Range = Range(1, 4, 7, 10)
    6 to 1 by -3                                  //> res5: scala.collection.immutable.Range = Range(6, 3)
  
  str exists(c => c.isUpper)                      //> res6: Boolean = true
  str forall (c => c.isUpper)                     //> res7: Boolean = false
  val pairs = List(1,2,3) zip str                 //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
  pairs.unzip                                     //> res8: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))
  
  str flatMap(c=> List('.', c))                   //> res9: String = .H.e.l.l.o. .W.o.r.l.d
  nums.max                                        //> res10: Int = 6
  nums sum                                        //> res11: Int = 8
  
  def scalarProduct(xs: Vector[Double], ys: Vector[Double]):Double =
  	(xs zip ys).map(xy => xy._1 * xy._2).sum  //> scalarProduct: (xs: Vector[Double], ys: Vector[Double])Double
 
  def scalarProduct2 (xs: Vector[Double], ys: Vector[Double]):Double =
  	(xs zip ys).map{ case (x,y) => x * y}.sum //> scalarProduct2: (xs: Vector[Double], ys: Vector[Double])Double

  def isPrime(n: Int): Boolean = (2 until n) forall (d => n%d != 0)
                                                  //> isPrime: (n: Int)Boolean
                                                  
	def scalarProduct3(xs: Vector[Double], ys: Vector[Double]):Double = (for ((x, y) <- xs zip ys) yield x*y ).sum
                                                  //> scalarProduct3: (xs: Vector[Double], ys: Vector[Double])Double
		
	val sset = (1 to 6).toSet                 //> sset  : scala.collection.immutable.Set[Int] = Set(5, 1, 6, 2, 3, 4)
  
  sset map(_ + 2)                                 //> res12: scala.collection.immutable.Set[Int] = Set(5, 6, 7, 3, 8, 4)
 	
 	val fruit = Set ("apple", "banana", "pear")
                                                  //> fruit  : scala.collection.immutable.Set[String] = Set(apple, banana, pear)
                                                  //| 
 	//fruit filter ( _.startsWith == "app")
 	sset.nonEmpty                             //> res13: Boolean = true
 	sset contains 3                           //> res14: Boolean = true
 	
}