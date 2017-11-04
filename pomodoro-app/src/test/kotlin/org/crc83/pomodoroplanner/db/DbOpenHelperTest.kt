package org.crc83.pomodoroplanner.db

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
class DbOpenHelperTest {
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
            insert("Test",
                    "id" to 1,
                    "name" to "John",
                    "photo" to "Smith")
            //When
            select("Test").exec { result = columnNames }
        }

        // Then
        assertEquals(result[0], "id")
        assertEquals(result[1], "name")
        assertEquals(result[2], "photo")
    }

    @After
    fun tearDown() {
        //nothing
    }


}