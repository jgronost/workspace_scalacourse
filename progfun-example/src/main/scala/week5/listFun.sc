package week5

object listFun {
  val fruits = List("apples","oranges", "bananas")//> fruits  : List[String] = List(apples, oranges, bananas)
	val nums = List(1,-4,7,2,3, -1,4)         //> nums  : List[Int] = List(1, -4, 7, 2, 3, -1, 4)
	
	
	nums filter (x => x > 0)                  //> res0: List[Int] = List(1, 7, 2, 3, 4)
	nums filterNot (x => x > 0)               //> res1: List[Int] = List(-4, -1)
	
	nums partition (x => x > 0)               //> res2: (List[Int], List[Int]) = (List(1, 7, 2, 3, 4),List(-4, -1))
	nums takeWhile (x => x > 0)               //> res3: List[Int] = List(1)
	nums dropWhile (x => x > 0)               //> res4: List[Int] = List(-4, 7, 2, 3, -1, 4)
	nums span (x => x > 0)                    //> res5: (List[Int], List[Int]) = (List(1),List(-4, 7, 2, 3, -1, 4))
	
	 def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil      => Nil
    case x :: xs1 =>
    	val (first, rest) = xs span(y => y ==x)
    	first :: pack(rest)
  }                                               //> pack: [T](xs: List[T])List[List[T]]
  
  pack(List("a", "a", "a", "b", "c", "c", "a"))   //> res6: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a))
                                                  //| 
	 def encode[T](xs: List[T]): List[(T, Int)] =
	 	 pack(xs) map(ys =>(ys.head, ys.length))
                                                  //> encode: [T](xs: List[T])List[(T, Int)]
  encode(List("a", "a", "a", "b", "c", "c", "a")) //> res7: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
  
  def sum(xs: List[Int]) = (0 :: xs) reduceLeft(_ + _)
                                                  //> sum: (xs: List[Int])Int
  sum(nums)                                       //> res8: Int = 12
  
  sum(List(1,-1))                                 //> res9: Int = 0
  
  def sum2(xs: List[Int]) = (xs foldLeft 0) (_ + _)
                                                  //> sum2: (xs: List[Int])Int
	sum2(nums)                                //> res10: Int = 12
	
	def concat[T](xs: List[T], ys: List[T]): List[T] =
    (xs foldRight ys) (_ :: _)                    //> concat: [T](xs: List[T], ys: List[T])List[T]
 concat(nums, List(1,2))                          //> res11: List[Int] = List(1, -4, 7, 2, 3, -1, 4, 1, 2)
 
 def mapFun[T, U](xs: List[T], f: T => U): List[U] =
    (xs foldRight List[U]())( ??? )               //> mapFun: [T, U](xs: List[T], f: T => U)List[U]

  def lengthFun[T](xs: List[T]): Int =
    (xs foldRight 0)( ??? )                       //> lengthFun: [T](xs: List[T])Int
}