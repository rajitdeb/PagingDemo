package com.rajit.pagingdemo.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.rajit.pagingdemo.data.local.entities.RecipesEntity
import com.rajit.pagingdemo.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    application: Application
): AndroidViewModel(application) {

    /** ROOM **/
    val recipesResponse : LiveData<List<RecipesEntity>> =
        repository.local.getAllRecipes().asLiveData()

    fun insertRecipes(recipesEntity: RecipesEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.local.insertRecipes(recipesEntity)
    }

    fun deleteRecipes(recipesEntity: RecipesEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.local.deleteRecipes(recipesEntity)
    }

}