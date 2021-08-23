package com.rajit.pagingdemo.data.local.dao

import androidx.room.*
import com.rajit.pagingdemo.data.local.entities.RecipesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipesDao {

    @Query("SELECT * FROM recipes_table")
    fun getAllRecipes(): Flow<List<RecipesEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecipes(recipesEntity: RecipesEntity)

    @Delete
    suspend fun deleteRecipe(recipesEntity: RecipesEntity)

}