package rali_transport

class Train(private val locomotive: Locomotive,private val wagons:HashSet<Wagon>):Expense {

    private var startStation:Station?=null
        get() = field
        set(value) {
            field = value
        }
    private var endStation:Station?=null
        get() = field
        set(value) {
            field = value
        }


    fun setStations(from:Station,to:Station){
        this.startStation=from
        this.endStation = to
    }
    override fun calculate():Double{
        if (startStation == null || endStation == null){
             println("Wrong operation!")
        }

        val locomotiveCost = locomotive.calculate()
        val wagonCount = wagons.size
        val distance = startStation!!.coordinate.getDistance(endStation!!.coordinate)

        return (locomotiveCost + (wagonCount * locomotiveCost)) * distance



    }


}