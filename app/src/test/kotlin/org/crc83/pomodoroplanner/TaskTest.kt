package org.crc83.pomodoroplanner

import com.google.gson.GsonBuilder
import org.crc83.pomodoroplanner.api.Task

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * Created by sbelei on 10/1/2017.
 */
class TaskTest{

    @Test
//    @DisplayName("should be serializable to json")
    fun testTaskIsSerializable() {
        val task = Task("42", "First task", "Lorem ipsum sind", false)
        val gson = GsonBuilder().setPrettyPrinting().create()
        val jsonPerson: String = gson.toJson(task)
        println(task)
        println(jsonPerson)
        //assertFalse(false)
    }

}