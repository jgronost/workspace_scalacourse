package week8

object scratch {

	abstract class JSON
	case class JSeq (elems: List[JSON]) extends JSON
	case class JObj (bindings: Map[String, JSON]) extends JSON
	case class JNum (num: Double) extends JSON
	case class JStr (str: String) extends JSON
	case class JBool(b: Boolean) extends JSON
	case object JNull extends JSON
	
	val data = JObj(Map(
			"firstName" -> JStr("John"),
			"lastName" -> JStr("Smith"),
			"address" -> JObj(Map(
			"streetAddress" -> JStr("21 2nd Street"),
			"state" -> JStr("NY"),
			"postalCode" -> JNum(10021)
			)),
			"phoneNumbers" -> JSeq(List(
			JObj(Map(
			"type" -> JStr("home"), "number" -> JStr("212 555-1234")
			)),
			JObj(Map(
			"type" -> JStr("fax"), "number" -> JStr("646 555-4567")
		)) )) ))                          //> data  : week8.scratch.JObj = JObj(Map(firstName -> JStr(John), lastName -> J
                                                  //| Str(Smith), address -> JObj(Map(streetAddress -> JStr(21 2nd Street), state 
                                                  //| -> JStr(NY), postalCode -> JNum(10021.0))), phoneNumbers -> JSeq(List(JObj(M
                                                  //| ap(type -> JStr(home), number -> JStr(212 555-1234))), JObj(Map(type -> JStr
                                                  //| (fax), number -> JStr(646 555-4567)))))))
		
		
		def show(json: JSON): String = json match {
			case JSeq(elems) =>
			"[" + (elems map show mkString ", ") + "]"
			case JObj(bindings) =>
			val assocs = bindings map {
			case (key, value) => "\"" + key + "\": " + show(value)
			}
			"{" + (assocs mkString ", ") + "}"
			case JNum(num) => num.toString
			case JStr(str) => '\"' + str + '\"'
			case JBool(b) => b.toString
			case JNull => "null"
		}                                 //> show: (json: week8.scratch.JSON)String
	
  show(data);                                     //> res0: String = {"firstName": "John", "lastName": "Smith", "address": {"stre
                                                  //| etAddress": "21 2nd Street", "state": "NY", "postalCode": 10021.0}, "phoneN
                                                  //| umbers": [{"type": "home", "number": "212 555-1234"}, {"type": "fax", "numb
                                                  //| er": "646 555-4567"}]}
                                                  

	val f: String => String = {case "ping" => "pong"}
                                                  //> f  : String => String = <function1>
	f("ping")                                 //> res1: String = pong
	
	//f("abc") //throws error as ther is no matching for abc
		val f2: PartialFunction[String, String] = { case "ping" => "pong" }
                                                  //> f2  : PartialFunction[String,String] = <function1>
		f2.isDefinedAt("ping") // true    //> res2: Boolean = true
		f2.isDefinedAt("pong") // false   //> res3: Boolean = false
		1                                 //> res4: Int(1) = 1
		//f2("abc")
		
    val f3: PartialFunction[List[Int], String] = {
        case Nil => "one"
        case x :: y :: rest => "two"
      }                                           //> f3  : PartialFunction[List[Int],String] = <function1>
    f3.isDefinedAt(List(1, 2, 3))                 //> res5: Boolean = true
	      
	      val g: PartialFunction[List[Int], String] = {
        case Nil => "one"
        case x :: rest =>
          rest match {
            case Nil => "two"
          }
      }                                           //> g  : PartialFunction[List[Int],String] = <function1>

   g.isDefinedAt(List(1, 2, 3))                   //> res6: Boolean = true
	
	 //g(List(1, 2, 3))    //but still throws mathc error
	
	/*
	for {
		JObj(bindings) <- data
		JSeq(phones) = bindings("phoneNumbers")
		JObj(phone) <- phones
		JStr(digits) = phone("number")
		if digits startsWith "212"
	} yield (bindings("firstName"), bindings("lastName"))
	*/
}