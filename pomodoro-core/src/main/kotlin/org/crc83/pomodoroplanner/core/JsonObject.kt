package org.crc83.pomodoroplanner.core

import com.google.gson.GsonBuilder

open class JsonObject {

    fun toJson(): String {
        val gson = GsonBuilder().setPrettyPrinting().create()
        return gson.toJson(this)
    }
}