package org.crc83.pomodoroplanner.persistance

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * Created by sbelei on 9/23/2017.
 * copied from wiki : https://github.com/Kotlin/anko/wiki/Anko-SQLite
 */
class DatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "PomodoroPlanner", null, 1) {
    companion object {
        private var instance: DatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): DatabaseOpenHelper {
            if (instance == null) {
                instance = DatabaseOpenHelper(ctx.getApplicationContext())
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        db.createTable("Repo", true,
                "id"      to INTEGER + PRIMARY_KEY + UNIQUE,
                "name"    to TEXT,
                "kind"    to TEXT,
                "config"  to TEXT)

        db.createTable("Task", true,
                "id" to INTEGER + PRIMARY_KEY + UNIQUE,
                "title" to TEXT,
                "description" to TEXT,
                "url" to TEXT,
                "repo" to INTEGER,
                "extId" to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        //db.dropTable("User", true)
    }
}

// Access property for Context
val Context.database: DatabaseOpenHelper
    get() = DatabaseOpenHelper.getInstance(getApplicationContext())