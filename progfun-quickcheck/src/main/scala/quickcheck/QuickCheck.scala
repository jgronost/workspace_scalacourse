package quickcheck

import common._
import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._


abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  property("min1") = forAll { a: Int =>
    val h = insert(a, empty)
    findMin(h) == a
  }
  
property("gen1") = forAll { (h: H) =>
  val m = if (isEmpty(h)) 0 else findMin(h)
  findMin(insert(m, h))==m
}

//property("gen2") = forAll { (h: H) =>
//  val m = if (isEmpty(h)) 0 else findMin(h)
//  println("h")
//  println(h)
//  println(m)
//  val h2 = deleteMin(h)
//  	  println("h2")
//	  println(h2)
//  if ( ! isEmpty(h2)){
//      val m2 = findMin(h2)
//      println(m2)
//	  val res = m2 >= m
//	  println(res)
//	  res
//  } else if(){
//    
//  } else{
//    val h3 = meld(h2, insert(m+1, h2))
//    println("h3")
//    println(h3)
//    val m2 = findMin(h3)
//    println(m2)
//	val res = m2 > m
//    println(res)
//	res
//  }
//    
//}


  lazy val genHeap: Gen[H] = for {
      h <- arbitrary[A] 
      m <- oneOf(value(empty),genHeap)
      if ( h > Int.MinValue && h < Int.MaxValue )
  } yield insert (h, m)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

}
