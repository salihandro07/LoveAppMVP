package com.example.loveappmvp.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HistoryModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun noteDao(): HistoryDao
}