package week6

object pairs {
  val n = 7                                       //> n  : Int = 7
  def isPrime(n: Int): Boolean = (2 until n) forall (d => n%d != 0)
                                                  //> isPrime: (n: Int)Boolean
  
  	(1 until n) flatMap ( i =>
		(1 until i) map (j => (i,j))) filter (pair =>
			isPrime(pair._1 + pair._2))
                                                  //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,2
                                                  //| ), (4,1), (4,3), (5,2), (6,1), (6,5))
  
  
  for {
  	i <- 1 until n
  	j <- 1 until i
  	if isPrime(i+j)
  } yield (i +j)                                  //> res1: scala.collection.immutable.IndexedSeq[Int] = Vector(3, 5, 5, 7, 7, 7, 
                                                  //| 11)
}