package org.crc83.pomodoroplanner.db

import org.crc83.pomodoroplanner.core.Task
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

/**
 * Created by Serhii Belei on 10/9/2017.
 */
@RunWith(RobolectricTestRunner::class)
@Config(manifest=Config.NONE)
class TaskReadWriteTest {
    lateinit var dbHelper: DbOpenHelper // Your DbHelper class

    @Before
    fun setup() {
        dbHelper = DbOpenHelper(RuntimeEnvironment.application)
    }

    @Test
    @Throws(Exception::class)
    fun testDbInsertion() {

        // Given
        var result:Array<String> = emptyArray()
        RuntimeEnvironment.application.database.use {
            val task : Task = Task(
                    id = "0",
                    name = "test task",
                    description = "lorem ipsum",
                    state = 0,
                    priority = 0,
                    metadata = "")
            insert("Tasks",
                    "id" to task.id,
                    "name" to task.name,
                    "description" to task.description,
                    "state" to task.state,
                    "priority" to task.priority,
                    "metadata" to task.metadata
                    )
            //When
            val taskParser = classParser<Task>()
            select("Tasks").parseList(taskParser)
        }
        result.forEach { o->
            System.out.println(o)
        }

        // Then
        assertEquals(result[1], "test task")
    }

    @After
    fun tearDown() {
        //nothing
    }


}