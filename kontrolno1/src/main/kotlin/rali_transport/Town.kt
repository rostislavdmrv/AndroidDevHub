package rali_transport

class Town(private val name: String,private val postalCode:String) {

    override fun toString(): String {
        return "This $name with postalCode $postalCode"
    }
}