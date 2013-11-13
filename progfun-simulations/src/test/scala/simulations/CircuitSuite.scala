package simulations

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CircuitSuite extends CircuitSimulator with FunSuite {
  val InverterDelay = 1
  val AndGateDelay = 3
  val OrGateDelay = 5
  
  test("andGate example") {
    val in1, in2, out = new Wire
    andGate(in1, in2, out)
    in1.setSignal(false)
    in2.setSignal(false)
    run
    
    assert(out.getSignal === false, "and 1")

    in1.setSignal(true)
    run
    
    assert(out.getSignal === false, "and 2")

    in2.setSignal(true)
    run
    
    assert(out.getSignal === true, "and 3")
  }

  //
  // to complete with tests for orGate, demux, ...
  //
  
  test("orGate test"){
        val in1, in2, out = new Wire
    orGate(in1, in2, out)
    in1.setSignal(false)
    in2.setSignal(false)
    run
    
    assert(out.getSignal === false, "or 1")

    in1.setSignal(true)
    run
    
    assert(out.getSignal === true, "or 2")

    in2.setSignal(true)
    run
    
    assert(out.getSignal === true, "or 3")
    
    in1.setSignal(false)
    assert(out.getSignal === true, "or 4")    

  }
  
    test("orGate2 test"){
        val in1, in2, out = new Wire
    orGate2(in1, in2, out)
    in1.setSignal(false)
    in2.setSignal(false)
    run
    
    assert(out.getSignal === false, "or 1")

    in1.setSignal(true)
    run
    
    assert(out.getSignal === true, "or 2")

    in2.setSignal(true)
    run
    
    assert(out.getSignal === true, "or 3")
    
    in1.setSignal(false)
    assert(out.getSignal === true, "or 4")    

  }
    
    test("demux test"){
        val in1, c1, c2, out1,out2, out3, out4 = new Wire
        val controlList = List(c1)
        val outList = List(out1, out2)
        controlList foreach (_.setSignal(false))
    
    demux(in1, List(c1), outList)

    in1.setSignal(false)
    c1.setSignal(false)
    run
    
    assert(outList(0).getSignal === false, "demux 1")
    assert(outList(1).getSignal === false, "demux 2")

    c1.setSignal(true)
    run
    assert(outList(0).getSignal === false, "demux 3")
    assert(outList(1).getSignal === false, "demux 4")


    in1.setSignal(true)
    run
    assert(outList(0).getSignal === false, "demux 5")
    assert(outList(1).getSignal === true, "demux 6")
    
    c1.setSignal(false)
    run
    assert(outList(0).getSignal === true, "demux 7")
    assert(outList(1).getSignal === false, "demux 8")

  }
}
