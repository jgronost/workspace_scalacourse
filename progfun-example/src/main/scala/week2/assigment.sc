package week2

object assigment {
 /**
 * 2. Purely Functional Sets.
 */
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  type Set = Int => Boolean

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem)
                                                  //> contains: (s: Int => Boolean, elem: Int)Boolean

  /**
   * Returns the set of the one given element.
   */
  def singletonSet(elem: Int): Set = n => n == elem
                                                  //> singletonSet: (elem: Int)Int => Boolean

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  def union(s: Set, t: Set): Set = i => s(i) || t(i)
                                                  //> union: (s: Int => Boolean, t: Int => Boolean)Int => Boolean

  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
  def intersect(s: Set, t: Set): Set = i => s(i) && t(i)
                                                  //> intersect: (s: Int => Boolean, t: Int => Boolean)Int => Boolean
                                                  
  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: Set, t: Set): Set = i =>  s(i) && !t(i)
                                                  //> diff: (s: Int => Boolean, t: Int => Boolean)Int => Boolean

  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: Set, p: Int => Boolean): Set = i => s(i) && p(i)
                                                  //> filter: (s: Int => Boolean, p: Int => Boolean)Int => Boolean

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000                                //> bound  : Int = 1000

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (a == -bound) true
      else if ( contains(s, a) && (!contains(filter(s,p),a)) ) false
      else iter(a-1)
    }
    iter(bound)
  }                                               //> forall: (s: Int => Boolean, p: Int => Boolean)Boolean

  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
  def exists(s: Set, p: Int => Boolean): Boolean = !forall(s,i => !p(i))
                                                  //> exists: (s: Int => Boolean, p: Int => Boolean)Boolean
  /*

  {
  
    def iter(a: Int): Boolean = {
      if (a == -bound) false
      else if ( contains(s, a) && (contains(filter(s,p),a)) ) true
      else iter(a-1)
    }
    iter(bound)

  }
  */
  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
	def map(s: Set, f: Int => Int): Set = { i => exists(s, {i2 => f(i2) == i}) }
                                                  //> map: (s: Int => Boolean, f: Int => Int)Int => Boolean
  /**
   * Displays the contents of a set
   */
  def toString(s: Set): String = {
    val xs = for (i <- -bound to bound if contains(s, i)) yield i
    xs.mkString("{", ",", "}")
  }                                               //> toString: (s: Int => Boolean)String

  /**
   * Prints the contents of a set on the console.
   */
  def printSet(s: Set) {
    println(toString(s))
  }                                               //> printSet: (s: Int => Boolean)Unit

   var x = Set(1, 4)                              //> x  : scala.collection.immutable.Set[Int] = Set(1, 4)
   var y = Set(1, 2,3)                            //> y  : scala.collection.immutable.Set[Int] = Set(1, 2, 3)
   
   val un = union(x, y)                           //> un  : Int => Boolean = <function1>
		printSet(un)                      //> {1,2,3,4}
		
	val inter = intersect(x, y)               //> inter  : Int => Boolean = <function1>
	printSet(inter)                           //> {1}
	
	val di = diff(y, x)                       //> di  : Int => Boolean = <function1>
	printSet(di)                              //> {2,3}
		
	val fil = filter(y, (x => x > 1))         //> fil  : Int => Boolean = <function1>
	printSet(fil)                             //> {2,3}
  
  
  forall(y, (x => x >= 1 ))                       //> res0: Boolean = true
	exists(y, (x => x < 0 ))                  //> res1: Boolean = false
	val ma = map(y, (x => x +2))              //> ma  : Int => Boolean = <function1>
	printSet(ma)                              //> {3,4,5}
}