package org.crc83.pomodoroplanner.db

import android.database.sqlite.SQLiteDatabase
import org.crc83.pomodoroplanner.core.Task
import org.jetbrains.anko.db.*

fun SQLiteDatabase.createTasksTable() {
    //table with tasks V1
    createTable("Tasks", true,
            "id" to INTEGER + PRIMARY_KEY + UNIQUE,
            "name" to TEXT,
            "description" to TEXT,
            "priority" to INTEGER,
            "state" to INTEGER,
            "metadata" to TEXT)
}

fun SQLiteDatabase.insertTask(task: Task) {
    insert("Tasks",
            "id" to task.id,
            "name" to task.name,
            "description" to task.description,
            "state" to task.state,
            "priority" to task.priority,
            "metadata" to task.metadata
    )
}

fun SQLiteDatabase.readAllTasks(): List<Task> {
    val taskParser = classParser<Task>()
    return select("Tasks").parseList(taskParser)
}