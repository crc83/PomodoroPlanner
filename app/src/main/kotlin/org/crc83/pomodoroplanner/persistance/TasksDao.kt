package org.crc83.pomodoroplanner.persistance

import org.jetbrains.exposed.dao.LongIdTable
import org.jetbrains.exposed.sql.*;
/**
 * Created by sbelei on 10/1/2017.
 */
object TasksDao : LongIdTable(){
    val name = varchar("name", length = 50)
    val description = varchar("description", length = 250)
    val done = bool("done")
}