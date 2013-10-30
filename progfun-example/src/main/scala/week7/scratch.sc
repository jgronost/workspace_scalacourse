package week7

object scratch {
 def isPrime(n: Int): Boolean = (2 until n) forall (d => n%d != 0)
                                                  //> isPrime: (n: Int)Boolean
 ((1000 to 100000).toStream filter isPrime)(3)    //> res0: Int = 1021
 
 def expr = {
    val x = { print("x,"); 1 }
    lazy val y = { print("y,"); 2 }
    def z = { print("z,"); 3 }
    z + y + x + z + y + x
 }                                                //> expr: => Int
 expr                                             //> x,z,y,z,res1: Int = 12
 
 def from(n: Int): Stream[Int] = n #:: from(n+1)  //> from: (n: Int)Stream[Int]
 
 val nats = from(0)                               //> nats  : Stream[Int] = Stream(0, ?)
 val m4s = nats map (_ * 4)                       //> m4s  : scala.collection.immutable.Stream[Int] = Stream(0, ?)
 
 
	(m4s take 10).toList                      //> res2: List[Int] = List(0, 4, 8, 12, 16, 20, 24, 28, 32, 36)

	def sieve(s: Stream[Int]): Stream[Int] =
		s.head #:: sieve(s.tail filter (_ % s.head != 0))
                                                  //> sieve: (s: Stream[Int])Stream[Int]
	
	val primes = sieve(from(2))               //> primes  : Stream[Int] = Stream(2, ?)
	primes.take(10).toList                    //> res3: List[Int] = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
	((2 to 30).toStream filter isPrime).toList//> res4: List[Int] = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
	
	def sqrtStream(x: Double): Stream[Double] = {
		def improve(guess: Double) = (guess + x / guess) / 2
		lazy val guesses: Stream[Double] = 1 #:: (guesses map improve)
		guesses
	}                                         //> sqrtStream: (x: Double)Stream[Double]
	
	def isGoodEnough(guess: Double, x: Double) =
		math.abs((guess * guess - x) / x) < 0.0001
                                                  //> isGoodEnough: (guess: Double, x: Double)Boolean
	
	sqrtStream(4).take(10).toList             //> res5: List[Double] = List(1.0, 2.5, 2.05, 2.000609756097561, 2.0000000929222
                                                  //| 947, 2.000000000000002, 2.0, 2.0, 2.0, 2.0)
	sqrtStream(4).filter(isGoodEnough(_, 4))  //> res6: scala.collection.immutable.Stream[Double] = Stream(2.0000000929222947,
                                                  //|  ?)

}