package com.tusxdie.starwarsuniversity.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tusxdie.starwarsuniversity.data.database.characters.StarWarsCharacterDao
import com.tusxdie.starwarsuniversity.data.database.characters.StarWarsCharacterEntity
import com.tusxdie.starwarsuniversity.data.database.films.FilmDao
import com.tusxdie.starwarsuniversity.data.database.films.FilmEntity
import com.tusxdie.starwarsuniversity.data.database.planets.PlanetDao
import com.tusxdie.starwarsuniversity.data.database.planets.PlanetEntity

@Database(
    entities = [StarWarsCharacterEntity::class, FilmEntity::class, PlanetEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun starWarsCharacterDao(): StarWarsCharacterDao
    abstract fun filmDao(): FilmDao
    abstract fun planetDao(): PlanetDao

    companion object {
        fun getDatabase(applicationContext: Context): AppDatabase {
            return Room
                .databaseBuilder(
                    context = applicationContext,
                    klass = AppDatabase::class.java,
                    name = "star_wars_university.db"
                )
                .build()

        }
    }
}