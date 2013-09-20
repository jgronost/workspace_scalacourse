package week1

object assigment {
    def pascal(c: Int, r: Int): Int ={
    
    	if (c==r) 1
    	else if (r>0 && c== 0) 1
    	else (pascal(c-1,r-1) + pascal(c,r-1))
		}                                 //> pascal: (c: Int, r: Int)Int
    
    pascal (0,0)                                  //> res0: Int = 1
    pascal(0,2)                                   //> res1: Int = 1
    pascal(1,2)                                   //> res2: Int = 2
    pascal(1,3)                                   //> res3: Int = 3
    pascal(5,5)                                   //> res4: Int = 1
    pascal(4,5)                                   //> res5: Int = 5
    pascal(3,5)                                   //> res6: Int = 10
 
 /*
    def balance(chars: List[Char]): Boolean = {
    	var counter = 0;
 			for (char <- chars){
 				if (counter == 0 && char !='(') return false
 				if (char == '(') counter = counter +1
 				else if(char == ')') counter = counter -1
 			}
			return counter == 0
    }
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
    }                                             //> balance: (chars: List[Char])Boolean
    
    balance("()".toList)                          //> res7: Boolean = true
    balance("(if (zero? x) max (/ 1 x))".toList)  //> res8: Boolean = true
    balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList)
                                                  //> res9: Boolean = true
		balance(":-)".toList)             //> res10: Boolean = false
		balance("())(".toList)            //> res11: Boolean = false
		balance("".toList)                //> res12: Boolean = true
		balance("()())(".toList)          //> res13: Boolean = false
	/*
		def countChange(money: Int, coins: List[Int]): Int = {
				if (money == 0) 0
				def countChangeInternal(money: Int, coins: List[Int], otherCoins: List[Int], count: Int): Int = {
					if (coins.isEmpty) count
					else {
						var addCount = 0;
						var coin = coins.head
						var sum = coin;
						do {
							sum = sum + sum;
							if (sum == money) addCount = addCount +1
						} while (sum <= money)
						sum = coin;
						do {
							for (otherCoin <-otherCoins)
							sum = sum + otherCoin;
							if (sum == money) addCount = addCount +1
						} while (sum <= money)
						
						countChangeInternal(money, coins, coins.tail, count + addCount)
					}
				}
				countChangeInternal(money, coins, coins.tail, 0)
				
		}
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
		
		}                                 //> countChange: (money: Int, coins: List[Int])Int
		
		countChange(4,List(1,2))          //> res14: Int = 3
		
		
}