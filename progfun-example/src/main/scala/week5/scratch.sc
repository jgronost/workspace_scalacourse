package week5
import Ordering._

object scratch {

	val fruit = List("apples","oranges", "bananas")
                                                  //> fruit  : List[String] = List(apples, oranges, bananas)
	val nums = List(1,2,3,4)                  //> nums  : List[Int] = List(1, 2, 3, 4)
	
	val diag3 = List(List(1,0,0), List(0,1,0), List(0,0,1))
                                                  //> diag3  : List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
                                                  //| 
  val empty = List()                              //> empty  : List[Nothing] = List()
  
  val numbers = 1 :: 2 :: 3 :: 4 :: Nil           //> numbers  : List[Int] = List(1, 2, 3, 4)
  
  val numbers2 = Nil.::(4).::(3).::(2).::(1)      //> numbers2  : List[Int] = List(1, 2, 3, 4)
  
 fruit.head                                       //> res0: String = apples
 
 fruit.tail.head                                  //> res1: String = oranges
 
 diag3.head                                       //> res2: List[Int] = List(1, 0, 0)
 
 //empty head
                                                  
	def isort(xs: List[Int]): List[Int] = xs match{
		case List() => List()
		case y :: ys => insert (y, isort(ys))
	}                                         //> isort: (xs: List[Int])List[Int]
	
	def insert(x: Int, xs: List[Int]): List[Int] = xs match{
		case List() => List(x)
		case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
	}                                         //> insert: (x: Int, xs: List[Int])List[Int]
	
	isort(List(5,3,4,1,2))                    //> res3: List[Int] = List(1, 2, 3, 4, 5)
	
 	def times(chars: List[Char]): List[(Char, Int)] = {
   timesCounter(List(), chars, chars.toSet)
  }                                               //> times: (chars: List[Char])List[(Char, Int)]
  
  def timesCounter(pairs: List[(Char, Int)], chars: List[Char], set: Set[Char] ): List[(Char, Int)] = {
    if (set.isEmpty) pairs
    else {
      val char = set.head
      val count = chars.count(x => x == char)
      timesCounter(List((char, count)) ::: pairs, chars, set.tail)
    	
    }
    
  }                                               //> timesCounter: (pairs: List[(Char, Int)], chars: List[Char], set: Set[Char])
                                                  //| List[(Char, Int)]
	
	val chars = List ('b', 'a', 'a', 'c', 'g', 'b')
                                                  //> chars  : List[Char] = List(b, a, a, c, g, b)
	times( chars)                             //> res4: List[(Char, Int)] = List((g,1), (c,1), (a,2), (b,2))
	
	def sortPairs(xs: List[(Char, Int)]): List[(Char, Int)] = xs match{
		case List() => List()
		case y :: ys => insertPair (y, sortPairs(ys))
	}                                         //> sortPairs: (xs: List[(Char, Int)])List[(Char, Int)]
	
	def insertPair(x: (Char, Int), xs: List[(Char, Int)]): List[(Char, Int)] = xs match{
		case List() => List(x)
		case y :: ys => if (x._2 <= y._2) x :: xs else y :: insertPair(x, ys)
	}                                         //> insertPair: (x: (Char, Int), xs: List[(Char, Int)])List[(Char, Int)]
	
	sortPairs(times( chars))                  //> res5: List[(Char, Int)] = List((g,1), (c,1), (a,2), (b,2))
 
 	def init[T](xs: List[T]): List[T] = xs match {
		case List() => throw new Error("empty list")
		case List(x) => List()
		case y :: ys => y :: init(ys)
	}                                         //> init: [T](xs: List[T])List[T]
	
	def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
		case List() => ys
		case z :: zs => z :: concat(zs, ys)
	}                                         //> concat: [T](xs: List[T], ys: List[T])List[T]
	
	def reverse [T](xs: List[T]): List[T] = xs match {
		case List() => xs
		case y :: ys => reverse(ys)  ++ List(y)
	}                                         //> reverse: [T](xs: List[T])List[T]
 	
 	def removeAt[T](n: Int, xs: List[T]) = (xs take n) ::: (xs drop n+ 1)
                                                  //> removeAt: [T](n: Int, xs: List[T])List[T]
 	
 	removeAt(1, List('a', 'b', 'c', 'd'))     //> res6: List[Char] = List(a, c, d)
 	
 	def msort[T](xs: List[T])(lt: (T,T) => Boolean): List[T] = {
 		val n = xs.length/2
 		if (n == 0) xs
 		else{
		 	 def merge(xs: List[T], ys: List[T]): List[T] =(xs, ys) match {
		      case (Nil, ys) => ys
		      case (xs, Nil) => xs
		      case (x :: xs1, y :: ys1) =>
								if (lt(x, y) )x :: merge(xs1, ys)
		 						else y :: merge(xs, ys1)
		    }
 			val (fst, snd) = xs splitAt n
 			merge(msort(fst)(lt), msort(snd)(lt))
 		}
 	}                                         //> msort: [T](xs: List[T])(lt: (T, T) => Boolean)List[T]
 	
 	val numers = List(2, -4,5, 1,3)           //> numers  : List[Int] = List(2, -4, 5, 1, 3)
 	msort(numers)((x: Int, y: Int) => x < y)  //> res7: List[Int] = List(-4, 1, 2, 3, 5)
 	fruit                                     //> res8: List[String] = List(apples, oranges, bananas)
 	msort(fruit)((x, y) => x < y)             //> res9: List[String] = List(apples, bananas, oranges)
 	
 		def msort2[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
 		val n = xs.length/2
 		if (n == 0) xs
 		else{
		 	 def merge(xs: List[T], ys: List[T]): List[T] =(xs, ys) match {
		      case (Nil, ys) => ys
		      case (xs, Nil) => xs
		      case (x :: xs1, y :: ys1) =>
								if (ord.lt(x, y))x :: merge(xs1, ys)
		 						else y :: merge(xs, ys1)
		    }
 			val (fst, snd) = xs splitAt n
 			merge(msort2(fst), msort2(snd))
 		}
 	}                                         //> msort2: [T](xs: List[T])(implicit ord: Ordering[T])List[T]
 	
 	msort2(numers)(Ordering.Int)              //> res10: List[Int] = List(-4, 1, 2, 3, 5)
 	msort2(fruit)                             //> res11: List[String] = List(apples, bananas, oranges)
 	
 	def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil     => xs
    case y :: ys => y*y :: squareList(ys)
  }                                               //> squareList: (xs: List[Int])List[Int]

  def squareList2(xs: List[Int]): List[Int] =
    xs map (x => x*x)                             //> squareList2: (xs: List[Int])List[Int]
 	
 	squareList(numers)                        //> res12: List[Int] = List(4, 16, 25, 1, 9)
 	squareList2(numers)                       //> res13: List[Int] = List(4, 16, 25, 1, 9)
 	
 	
}