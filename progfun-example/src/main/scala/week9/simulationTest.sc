package week9

object simulationTest {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  object sim extends Circuits with Parameters
  
  import sim._
	val input1, input2, sum, carry = new Wire //> input1  : week9.simulationTest.sim.Wire = week9.Gates$Wire@6e3d60
                                                  //| input2  : week9.simulationTest.sim.Wire = week9.Gates$Wire@17fa65e
                                                  //| sum  : week9.simulationTest.sim.Wire = week9.Gates$Wire@18385e3
                                                  //| carry  : week9.simulationTest.sim.Wire = week9.Gates$Wire@1cb25f1
	probe("sum", sum)                         //> sum 0 value = false
	probe("carry", carry)                     //> carry 0 value = false
	
	halfAdder(input1, input2, sum, carry)
	input1.setSignal(true)
	run()                                     //> *** simulation started, time = 0 ***
                                                  //| sum 8 value = true
	input2.setSignal(true)
	run()                                     //> *** simulation started, time = 8 ***
                                                  //| carry 11 value = true
                                                  //| sum 16 value = false
 	input1 setSignal false
 	run()                                     //> *** simulation started, time = 16 ***
                                                  //| carry 19 value = false
                                                  //| sum 24 value = true
}