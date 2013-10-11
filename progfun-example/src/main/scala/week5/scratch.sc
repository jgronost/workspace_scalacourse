package week5

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
 
}