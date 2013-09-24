package week2

object session {
	def factorial (n: Int): Int = {
		def loop(acc: Int, n: Int):Int =
			if (n==0) acc
			else loop(acc * n, n-1)
		loop (1,n)
	}                                         //> factorial: (n: Int)Int
	factorial(2)                              //> res0: Int = 2
	factorial(3)                              //> res1: Int = 6
	factorial(3000)                           //> res2: Int = 0
	
	def sum(f: Int => Int)(a: Int, b:Int): Int = {
		def loop(a: Int, acc:Int): Int = {
			if (a > b) acc
			else loop(a+1, f(a)+acc)
		}
		loop(a,0)
	}                                         //> sum: (f: Int => Int)(a: Int, b: Int)Int
	
	sum(x => x)(1,4)                          //> res3: Int = 10
	sum(x => x*x) (1,3)                       //> res4: Int = 14
	
	
}