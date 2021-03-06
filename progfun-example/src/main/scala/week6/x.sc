package week6

import scala.io.Source

object x {
	val in = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt");
                                                  //> java.net.ConnectException: Connection timed out: connect
                                                  //| 	at java.net.PlainSocketImpl.socketConnect(Native Method)
                                                  //| 	at java.net.PlainSocketImpl.doConnect(Unknown Source)
                                                  //| 	at java.net.PlainSocketImpl.connectToAddress(Unknown Source)
                                                  //| 	at java.net.PlainSocketImpl.connect(Unknown Source)
                                                  //| 	at java.net.SocksSocketImpl.connect(Unknown Source)
                                                  //| 	at java.net.Socket.connect(Unknown Source)
                                                  //| 	at java.net.Socket.connect(Unknown Source)
                                                  //| 	at sun.net.NetworkClient.doConnect(Unknown Source)
                                                  //| 	at sun.net.www.http.HttpClient.openServer(Unknown Source)
                                                  //| 	at sun.net.www.http.HttpClient.openServer(Unknown Source)
                                                  //| 	at sun.net.www.http.HttpClient.<init>(Unknown Source)
                                                  //| 	at sun.net.www.http.HttpClient.New(Unknown Source)
                                                  //| 	at sun.net.www.http.HttpClient.New(Unknown Source)
                                                  //| 	at sun.net.www.protocol.http.HttpURLConnection.getNewHttpClient(Unknown 
                                                  //| Source)
                                                  //| 	at sun.net.www.protocol.http.HttpURLConnection.plainConnect(Unknown Sour
                                                  //| ce
                                                  //| Output exceeds cutoff limit.
	val words = in.getLines.toList filter (word => word forall (chr => chr.isLetter))

//	val words = List("asafsd", "afsdf", "asdfssdf" ,"oyieoihsdf", "slhsdf-hg") filter (word => word forall (chr => chr.isLetter))
	
  
  val mnem = Map(
		'2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
		'6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")
		
	val charCode: Map[Char, Char] =  ///Map('A' -> 2, 'B' -> 2)
		for ((digit, str) <- mnem; ltr <-str) yield ltr -> digit
	// eg: "Java" -> 5282
	def wordCode(word: String): String =
		word.toUpperCase map charCode
	
	// eg: 5282 -> "Java" , "Kata", "Lava" ...
	def wordsForNum: Map[String, Seq[String]] =
		words groupBy wordCode withDefaultValue Seq()
	
	def encode(number: String): Set[List[String]] =
		if (number.isEmpty) Set(List())
		else{
			for{
				split <- 1 to number.length
				word <- wordsForNum(number take split)
				rest <- encode (number drop split)
			} yield word :: rest
			}.toSet
	
	def translate(number: String): Set[String] =
		encode(number) map (_ mkString " ")
	
	wordCode("JAVA")
	wordCode("Java")
	//wordsForNum(5282)
	encode("7225247386")
	translate("7225247386")
}