package org.crc83.pomodoroplanner.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class DbOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "pomodoro-planner-db", null, 1) {
    companion object {
        private var instance: DbOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): DbOpenHelper {
            if (instance == null) {
                instance = DbOpenHelper(ctx.getApplicationContext())
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // table compleatly for test purposes
        db.createTable("Test", true,
                "id" to INTEGER + PRIMARY_KEY + UNIQUE,
                "name" to TEXT,
                "photo" to TEXT)

        //table with tasks V1
        db.createTasksTable()
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable("Test2", true)
    }
}

// Access property for Context
val Context.database: DbOpenHelper
    get() = DbOpenHelper.getInstance(getApplicationContext())