package week4

object session {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  	def nth[T](n: Int, xs: List[T]): T =
  		if (xs.isEmpty) throw new IndexOutOfBoundsException
  		else if (n ==0) xs.head
  		else nth(n-1, xs.tail)            //> nth: [T](n: Int, xs: week4.List[T])T
  		
  val list = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Nil))))
                                                  //> list  : week4.Cons[Int] = week4.Cons@c5c3ac
	nth(1, list)                              //> res0: Int = 2
	nth(2, list)                              //> res1: Int = 3
	nth(-1, list)                             //> java.lang.IndexOutOfBoundsException
                                                  //| 	at week4.session$$anonfun$main$1.nth$1(week4.session.scala:7)
                                                  //| 	at week4.session$$anonfun$main$1.apply$mcV$sp(week4.session.scala:14)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week4.session$.main(week4.session.scala:3)
                                                  //| 	at week4.session.main(week4.session.scala)

}