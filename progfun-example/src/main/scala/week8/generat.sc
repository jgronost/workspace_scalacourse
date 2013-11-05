package week8

object generat {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
    	trait Generator[+T] {
		self => // an alias for "this"
		def generate: T
		def map[S](f: T => S): Generator[S] = new Generator[S] {
			def generate = f(self.generate)
		}
		def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
			def generate = f(self.generate).generate
		}
	}
	
	
	val integers = new Generator[Int] {
		val rand = new java.util.Random
		def generate = rand.nextInt()
	}                                         //> integers  : week8.generat.Generator[Int]{val rand: java.util.Random} = week8
                                                  //| .generat$$anonfun$main$1$$anon$3@1f436f5
  
  val booleans = for (x <- integers) yield x >= 0 //> booleans  : week8.generat.Generator[Boolean] = week8.generat$$anonfun$main$1
                                                  //| $Generator$1$$anon$1@197a37c
  
  def pairs[T, U](t: Generator[T], u: Generator[U]) = t flatMap {
		x => u map { y => (x, y) } }      //> pairs: [T, U](t: week8.generat.Generator[T], u: week8.generat.Generator[U])w
                                                  //| eek8.generat.Generator[(T, U)]
                                                  
	def single[T](x: T): Generator[T] = new Generator[T] {
	def generate = x
	}                                         //> single: [T](x: T)week8.generat.Generator[T]
	def choose(lo: Int, hi: Int): Generator[Int] =
	for (x <- integers) yield lo + x % (hi - lo)
                                                  //> choose: (lo: Int, hi: Int)week8.generat.Generator[Int]
	def oneOf[T](xs: T*): Generator[T] =
	for (idx <- choose(0, xs.length)) yield xs(idx)
                                                  //> oneOf: [T](xs: T*)week8.generat.Generator[T]
	
	def lists: Generator[List[Int]] = for {
	isEmpty <- booleans
	list <- if (isEmpty) emptyLists else nonEmptyLists
	} yield list                              //> lists: => week8.generat.Generator[List[Int]]
	
	def emptyLists = single(Nil)              //> emptyLists: => week8.generat.Generator[scala.collection.immutable.Nil.type]
                                                  //| 
	def nonEmptyLists = for {
	head <- integers
	tail <- lists
	} yield head :: tail                      //> nonEmptyLists: => week8.generat.Generator[List[Int]]
// ------------
	trait Tree
	case class Inner(left: Tree, right: Tree) extends Tree
	case class Leaf(x: Int) extends Tree
	
	def leafs: Generator[Leaf] = for {
		x <- integers
	} yield Leaf(x)                           //> leafs: => week8.generat.Generator[week8.generat.Leaf]
	
	def inners: Generator[Inner] = for {
		l <- trees
		r <- trees
	} yield Inner(l,r)                        //> inners: => week8.generat.Generator[week8.generat.Inner]
	
	def trees: Generator[Tree] = for{
		isLeaf <- booleans
		tree <- if (isLeaf) leafs else inners
	} yield tree                              //> trees: => week8.generat.Generator[week8.generat.Tree]
	
	trees.generate                            //> res0: week8.generat.Tree = Inner(Leaf(-92335937),Leaf(731530645))
	trees.generate                            //> res1: week8.generat.Tree = Leaf(1343909498)
	
		def test[T](g: Generator[T], numTimes: Int = 100)
		(test: T => Boolean): Unit = {
		for (i <- 0 until numTimes) {
			val value = g.generate
			assert(test(value), "test failed for "+value)
			}
			println("passed "+numTimes+" tests")
	}                                         //> test: [T](g: week8.generat.Generator[T], numTimes: Int)(test: T => Boolean)
                                                  //| Unit
	   
	   test(pairs(lists, lists)) {
        case (xs, ys) => (xs ++ ys).length > xs.length
      }                                           //> java.lang.AssertionError: assertion failed: test failed for (List(),List())
                                                  //| 
                                                  //| 	at scala.Predef$.assert(Predef.scala:179)
                                                  //| 	at week8.generat$$anonfun$main$1$$anonfun$test$1$1.apply$mcVI$sp(week8.g
                                                  //| enerat.scala:72)
                                                  //| 	at week8.generat$$anonfun$main$1$$anonfun$test$1$1.apply(week8.generat.s
                                                  //| cala:70)
                                                  //| 	at week8.generat$$anonfun$main$1$$anonfun$test$1$1.apply(week8.generat.s
                                                  //| cala:70)
                                                  //| 	at scala.collection.immutable.Range.foreach(Range.scala:141)
                                                  //| 	at week8.generat$$anonfun$main$1.test$1(week8.generat.scala:70)
                                                  //| 	at week8.generat$$anonfun$main$1.apply$mcV$sp(week8.generat.scala:77)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 
                                                  //| Output exceeds cutoff limit.
	
}