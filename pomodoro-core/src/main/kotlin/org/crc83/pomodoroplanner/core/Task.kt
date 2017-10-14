package org.crc83.pomodoroplanner.core

import com.google.gson.GsonBuilder

/**
 * Created by Sergiy Beley on 9/16/2017.
 */
data class Task(
    var id : String = "",
    var name : String="",
    var description : String ="",
    var priority : Int = 0,
    var state : Int = 0,
    var metadata : String) {

    fun toJson(): String {
        val gson = GsonBuilder().setPrettyPrinting().create()
        return gson.toJson(this)
    }
}