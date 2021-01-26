package com.example.projetointegradormarvel.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.projetointegradormarvel.characters.CharactersResults
import com.example.projetointegradormarvel.comics.ComicsResults
import com.example.projetointegradormarvel.creators.CreatorsResults
import com.example.projetointegradormarvel.dao.CharactersDAO
import com.example.projetointegradormarvel.dao.ComicsDAO
import com.example.projetointegradormarvel.dao.CreatorsDAO

@Database(entities = [CharactersResults::class, ComicsResults::class, CreatorsResults::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun characterDAO(): CharactersDAO
    abstract fun comicsDAO(): ComicsDAO
    abstract fun creatorsDAO(): CreatorsDAO

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "marvelcomicswiki.db"
        ).build()
    }

    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
        TODO("Not yet implemented")
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("Not yet implemented")
    }

    override fun clearAllTables() {
        TODO("Not yet implemented")
    }
}