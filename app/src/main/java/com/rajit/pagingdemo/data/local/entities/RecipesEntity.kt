package com.rajit.pagingdemo.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rajit.pagingdemo.util.Constants

@Entity(tableName = Constants.TABLE_NAME)
class RecipesEntity(
    val name: String,
    val description: String,
    val url: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 1
}