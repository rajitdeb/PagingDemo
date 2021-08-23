package com.rajit.pagingdemo.data.repository

import com.rajit.pagingdemo.data.local.dao.RecipesDao
import com.rajit.pagingdemo.data.local.entities.RecipesEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val recipesDao: RecipesDao
) {

    suspend fun insertRecipes(recipesEntity: RecipesEntity){
        recipesDao.insertRecipes(recipesEntity)
    }

    suspend fun deleteRecipes(recipesEntity: RecipesEntity) {
        recipesDao.deleteRecipe(recipesEntity)
    }

    fun getAllRecipes(): Flow<List<RecipesEntity>> {
        return recipesDao.getAllRecipes()
    }

}