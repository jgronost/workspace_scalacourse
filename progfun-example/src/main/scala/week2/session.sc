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
	
}