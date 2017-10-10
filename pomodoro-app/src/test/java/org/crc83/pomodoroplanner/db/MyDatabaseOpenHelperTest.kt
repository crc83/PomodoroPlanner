package org.crc83.pomodoroplanner.db

import android.os.Build.VERSION_CODES.KITKAT
import android.os.Build.VERSION_CODES.LOLLIPOP
import org.crc83.pomodoroplanner.BuildConfig
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
class MyDatabaseOpenHelperTest {
    lateinit var dbHelper: MyDatabaseOpenHelper // Your DbHelper class

    @Before
    fun setup() {
        dbHelper = MyDatabaseOpenHelper(RuntimeEnvironment.application)
//        dbHelper.clearDbAndRecreate() // This is just to clear the db
    }

    @Test
    @Throws(Exception::class)
    fun testDbInsertion() {

        // Given
        val testStr1 = "testing"
        val testStr2 = "testing"

        // When
        var result:Array<String> = emptyArray()
        RuntimeEnvironment.application.database.use {
            insert("Test",
                    "id" to 1,
                    "name" to "John",
                    "photo" to "Smith")
            select("Test").exec { result = columnNames }
        }
        result.forEach { o->
            System.out.println(o)
        }

        // Then
        assertEquals(result[0], "id")
    }

    @After
    fun tearDown() {
//        dbHelper.clearDb()
    }


}