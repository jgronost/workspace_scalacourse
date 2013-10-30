package week7

object PouringTest {
  val problem = new Pouring(Vector(4,9, 190))     //> problem  : week7.Pouring = week7.Pouring@e3b895
  
  problem.moves                                   //> res0: scala.collection.immutable.IndexedSeq[Product with Serializable with w
                                                  //| eek7.PouringTest.problem.Move] = Vector(Empty(0), Empty(1), Empty(2), Fill(0
                                                  //| ), Fill(1), Fill(2), Pour(0,1), Pour(0,2), Pour(1,0), Pour(1,2), Pour(2,0), 
                                                  //| Pour(2,1))
                                        
	val problem2 = new Pouring(Vector(4,7, 9))//> problem2  : week7.Pouring = week7.Pouring@ab853b
	  problem2.moves                          //> res1: scala.collection.immutable.IndexedSeq[Product with Serializable with w
                                                  //| eek7.PouringTest.problem2.Move] = Vector(Empty(0), Empty(1), Empty(2), Fill(
                                                  //| 0), Fill(1), Fill(2), Pour(0,1), Pour(0,2), Pour(1,0), Pour(1,2), Pour(2,0),
                                                  //|  Pour(2,1))
   
   
   problem.pathSets.take(3).toList                //> res2: List[Set[week7.PouringTest.problem.Path]] = List(Set(-->Vector(0, 0, 0
                                                  //| )), Set(Fill(0)-->Vector(4, 0, 0), Fill(1)-->Vector(0, 9, 0), Fill(2)-->Vect
                                                  //| or(0, 0, 190)), Set(Fill(1) Pour(1,0)-->Vector(4, 5, 0), Fill(0) Fill(2)-->V
                                                  //| ector(4, 0, 190), Fill(2) Fill(0)-->Vector(4, 0, 190), Fill(1) Pour(1,2)-->V
                                                  //| ector(0, 0, 9), Fill(0) Pour(0,1)-->Vector(0, 4, 0), Fill(2) Pour(2,1)-->Vec
                                                  //| tor(0, 9, 181), Fill(1) Fill(2)-->Vector(0, 9, 190), Fill(2) Fill(1)-->Vecto
                                                  //| r(0, 9, 190), Fill(1) Fill(0)-->Vector(4, 9, 0), Fill(0) Fill(1)-->Vector(4,
                                                  //|  9, 0), Fill(2) Pour(2,0)-->Vector(4, 0, 186), Fill(0) Pour(0,2)-->Vector(0,
                                                  //|  0, 4)))
  problem.solution(6)                             //> res3: Stream[week7.PouringTest.problem.Path] = Stream(Fill(1) Pour(1,0) Pour
                                                  //| (0,2) Pour(1,0) Pour(0,2) Pour(1,0) Fill(1) Pour(1,0)-->Vector(4, 6, 8), ?)
                                                  //| 
}