package rali_transport

class PassengerWagon:Wagon() {
    override fun getType(): WagonType {
        return WagonType.PASSENGER
    }
}