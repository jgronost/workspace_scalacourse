package simulations

import math.random

class EpidemySimulator extends Simulator {

  def randomBelow(i: Int) = (random * i).toInt

  protected[simulations] object SimConfig {
    val population: Int = 300
    val roomRows: Int = 8
    val roomColumns: Int = 8

    // to complete: additional parameters of simulation
    val transmissibilityRate = 0.4
    val prevalenceRate = 0.01
    val incubationDelay = 6
    val dieDelay = 14
    val dieRate = 0.25
    val immunabilityDelay = 16
    val healDelay = 18
    val airTraficRate = 0.01  
  }

  import SimConfig._

  val persons: List[Person] = for {
	i <- (0 until population).toList
		} yield {
			val p = new Person(i)
			if (i < population * prevalenceRate)
			p.infected = true
			p.mode()
			p
		}



  class Person (val id: Int) {
    var infected = false
    var sick = false
    var immune = false
    var dead = false
    
    // demonstrates random number generation
    var row: Int = randomBelow(roomRows)
    var col: Int = randomBelow(roomColumns)
    
    def mode() {
		val moveDelay = randomBelow(5) + 1
		afterDelay (moveDelay) (spreed)
	}


    //
    // to complete with simulation logic
    //
    
    def makeImmune(){
      if (!dead){
	      immune = true
	      sick = false
      } 
    }
    
    def heal(){
      if (!dead) {
        immune = false
        infected = false
      }
    }
    def tryTokill(){
      if (random < dieRate)
        dead = true
    }
    
     def spreed() {
		if (dead)
		return
		
		val neighbors = List(((row-1+roomRows) % roomRows, col),
		((row+1) % roomRows, col),
		(row, (col-1+roomColumns) % roomColumns),
		(row, (col+1) % roomColumns))
		
		def isHealthy(room: (Int, Int)): Boolean = room match {
			case (r, c) => (persons.find{p => p.row==r && p.col==c && (p.sick || p.dead)}).isEmpty
			}
		val candidates = neighbors filter isHealthy
		if (!candidates.isEmpty) {
		val candidate: (Int,Int) = candidates(randomBelow(candidates.length))
		candidate match {
		case (a,b) => row = a; col = b
		}
		}

		if (!immune && !infected)
		if (random < transmissibilityRate)
		if (!(persons.find{p => p.row==row && p.col==col && p.infected}).isEmpty){
		   infected = true
			afterDelay (incubationDelay) (sick = true)
			
			afterDelay (dieDelay) (tryTokill)
			afterDelay (immunabilityDelay) (makeImmune )
			afterDelay (healDelay) (heal)
		}
		 
		mode()
	}
  }
  
  }
  
