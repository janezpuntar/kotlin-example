package si.dlabs.kotlin

import android.util.Log

/**
 * Created by Janez Puntar on 04/02/15.
 */

trait Money { // interface
    fun spend()
}

abstract class Person(private var years: Int) {

    open fun myLocation() {}

    fun getYears() : String {
        Log.e("tag", "Years : ${years}")
        return "Years : ${years}"
    }

    fun setYear(year : Int) {
        years = year
    }

}


class Customer public (private val customerName: String, location: String?) : Person(years = 23), Money {

    {
        Log.e("tag", "Customer initialized with value ${customerName}")
    }

    private val location = location

    final override fun myLocation() {
        Log.e("tag", "This is my location: ${location}")
    }

    override fun spend() {
        Log.e("tag", "${customerName} must spend on locaiton ${location}")
    }

//    fun double(x: Int): Int = x * 2
    fun double(x: Double) = x * 2

    fun attach(prefix: String, weight: Double = 54.3) : String {
        return "${prefix} ${customerName} ${weight}"
    }

    fun reformat(capitalize: Boolean = true,
                 subSequence: Boolean = false) {

        if (capitalize)
            Log.e("tag", "capitalize ${customerName.capitalize()}")

        if (subSequence)
            Log.e("tag", "subSequence ${customerName.subSequence(0, customerName.length() / 2 )}")
    }

//    fun read(b: Array<Byte>, off: Int = 0, len: Int = b.size) {
//        ...
//    }


}

