package com.rajit.pagingdemo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rajit.pagingdemo.data.local.dao.RecipesDao
import com.rajit.pagingdemo.data.local.entities.RecipesEntity

@Database(
    entities = [RecipesEntity::class],
    version = 1,
    exportSchema = false
)
abstract class RecipesDatabase: RoomDatabase() {

    abstract fun recipesDao(): RecipesDao

}