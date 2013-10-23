package week6

object assigment {
 type Word = String
 type Occurrences = List[(Char, Int)]
 type Sentence = List[Word]
 
 def wordOccurrences(w: Word) = {
    val chList = w.toList
    val freq = chList groupBy(_.toChar.toLower) mapValues(_.size) toList;
    freq.sorted
    
    //w.toList groupBy((ch: Char) => w.indexOf(ch))  toList

  }                                               //> wordOccurrences: (w: week6.assigment.Word)List[(Char, Int)]
  
  wordOccurrences("daBcb")                        //> res0: List[(Char, Int)] = List((a,1), (b,2), (c,1), (d,1))
  
 def sentenceOccurrences(s: Sentence): Occurrences = {
 wordOccurrences(s mkString)
 }                                                //> sentenceOccurrences: (s: week6.assigment.Sentence)week6.assigment.Occurrence
                                                  //| s


  def subtract(x: Occurrences, y: Occurrences): Occurrences = {
     (for{
    	 xPair <- x
    	 yPair <- y
     }yield{
    	 if(xPair._1 == yPair._1)
    		 (xPair._1, xPair._1 - yPair._1)
    		 else
    			 xPair
     }).filter(x => x._2 != 0).toSet.toList.sorted

    
  }                                               //> subtract: (x: week6.assigment.Occurrences, y: week6.assigment.Occurrences)we
                                                  //| ek6.assigment.Occurrences
  
  subtract(wordOccurrences("aab"), wordOccurrences("ab"))
                                                  //> res1: week6.assigment.Occurrences = List((a,2), (b,1))

}