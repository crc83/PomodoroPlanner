package org.crc83.pomodoroplanner.core

/**
 * Created by Sergiy Beley on 9/16/2017.
 */
data class Task (
    var id : String = "",
    var name : String="",
    var description : String ="",
    var done : Boolean = false
)