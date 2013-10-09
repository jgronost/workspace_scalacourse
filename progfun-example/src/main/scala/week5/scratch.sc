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
 
 empty head                                       //> java.util.NoSuchElementException: head of empty list
                                                  //| 	at scala.collection.immutable.Nil$.head(List.scala:337)
                                                  //| 	at scala.collection.immutable.Nil$.head(List.scala:334)
                                                  //| 	at week5.scratch$$anonfun$main$1.apply$mcV$sp(week5.scratch.scala:20)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week5.scratch$.main(week5.scratch.scala:3)
                                                  //| 	at week5.scratch.main(week5.scratch.scala)
                                                  
	def isort(xs: List[Int]): List[Int] = xs match{
		case List() => List()
		case y :: ys => insert (y, isort(ys))
	}
	
	def insert(x: Int, xs: List[Int]): List[Int] = xs match{
		case List() => List(x)
		case y :: ys => if (x <= ys.head) x :: ys else ys.head :: insert(x, ys)
	}
 
}