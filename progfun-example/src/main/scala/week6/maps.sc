package week6

object maps {
	val romanNumerals = Map("I" ->1, "V" -> 5, "X" -> 10)
                                                  //> romanNumerals  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V -
                                                  //| > 5, X -> 10)
	val capOfCountry = Map ("US" -> "WAshington", "Switzerland" -> "Bern")
                                                  //> capOfCountry  : scala.collection.immutable.Map[String,String] = Map(US -> WA
                                                  //| shington, Switzerland -> Bern)
	capOfCountry("US")                        //> res0: String = WAshington
//	capOfCountry("UK")  //throws NoSuchElementException
	capOfCountry get "UK"                     //> res1: Option[String] = None
	capOfCountry get "US"                     //> res2: Option[String] = Some(WAshington)
	
	def showCapital (country: String) = capOfCountry.get(country) match {
		case Some(capital) => capital
		case None => "missing data"
	}                                         //> showCapital: (country: String)String
	
	showCapital("andora")                     //> res3: String = missing data
	
	val fruit = List ("apple", "banana", "pear")
                                                  //> fruit  : List[String] = List(apple, banana, pear)
	fruit groupBy(_.head)                     //> res4: scala.collection.immutable.Map[Char,List[String]] = Map(b -> List(bana
                                                  //| na), p -> List(pear), a -> List(apple))
	fruit sortWith (_.length < _.length)      //> res5: List[String] = List(pear, apple, banana)
	fruit sorted                              //> res6: List[String] = List(apple, banana, pear)
	
	val cap1 = capOfCountry withDefaultValue("unkown")
                                                  //> cap1  : scala.collection.immutable.Map[String,String] = Map(US -> WAshington
                                                  //| , Switzerland -> Bern)
	cap1("Russia")                            //> res7: String = unkown
}