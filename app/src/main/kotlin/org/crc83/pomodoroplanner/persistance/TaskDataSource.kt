package org.crc83.pomodoroplanner.persistance

import android.database.sqlite.SQLiteDatabase
import org.crc83.pomodoroplanner.api.Task
import org.jetbrains.anko.db.parseList
import org.jetbrains.anko.db.select

/**
 * Created by sbelei on 9/26/2017.
 */
class TaskDataSource {


    fun readAllTasks(db: SQLiteDatabase): List<Task> = db.use {
        db.select("Task")
                .parseList(TaskParser)
    }
}