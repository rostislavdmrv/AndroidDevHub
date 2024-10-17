package rali_transport

import java.lang.Math.pow
import kotlin.math.*

class Coordinate(private val longitude:Double,private val latitude:Double) {
    private val radiusOfEarth = 6371.0

    fun getDistance(other: Coordinate): Double {
        val lat1 = Math. toRadians(this. latitude)
        val lon1 = Math. toRadians(this. longitude)
        val lat2 = Math. toRadians(other.latitude)
        val lon2 = Math. toRadians(other.longitude)
        val f = sin( lat2 - lat1/ 2) . pow(2.0) + cos(lat1) * cos(lat2) * sin(lon2 - lon1 / 2). pow(2.0)
        val sqr  = 2 * atan2(sqrt(f), sqrt(1 - f))
        val result = radiusOfEarth * sqr
        return result


    }


}