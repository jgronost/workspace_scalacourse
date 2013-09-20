package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c==r) 1
    else if (r>0 && c== 0) 1
    else (pascal(c-1,r-1) + pascal(c,r-1))
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    	def balance2 (chars: List[Char], counter: Int): Boolean = {
    	    	if (chars.isEmpty  && counter == 0) true
			    	else if (chars.isEmpty && counter != 0) false
			    	else {
				    	var char = chars.head
				    	if (char == '(' ){
				    		balance2(chars.tail, counter +1 );
				    	}
				    	else if(char == ')' ) {
				    		if (counter ==0) false
				    		else balance2(chars.tail, counter -1);
				    	}
				    	else  balance2(chars.tail, counter);
				}
    	}
    	balance2(chars, 0)
    }                                        

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
		 def calulateCombinations(money: Int, coins: List[Int]): Int = {
		 		if(money == 0) 1
		 		else if (money < 0 || coins.isEmpty) 0
		 		else {
		 			calulateCombinations(money - coins.head, coins) +
		 			calulateCombinations(money, coins.tail)
		 		}
		 }
		 
		 if (money == 0) 0
		 else calulateCombinations(money, coins)
		
		} 
}
