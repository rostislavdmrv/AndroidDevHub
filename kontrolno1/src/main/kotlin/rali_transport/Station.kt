package rali_transport

class Station( val name: String, val town: Town, val coordinate: Coordinate) {

    override fun toString(): String {
        return "This $name in town $town on station $coordinate"
    }
}