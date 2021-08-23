package com.rajit.pagingdemo.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rajit.pagingdemo.data.local.entities.RecipesEntity
import com.rajit.pagingdemo.databinding.RecipesItemRowBinding
import com.rajit.pagingdemo.util.RecipesDiffUtil

class RecipesAdapter: RecyclerView.Adapter<RecipesAdapter.MyViewHolder>() {

    private var recipesList = emptyList<RecipesEntity>()

    class MyViewHolder(val binding: RecipesItemRowBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(recipesEntity: RecipesEntity) {

            Log.d("Recipes Adapter", "Recipes Adapter: bind: $recipesEntity")

            binding.itemName.text = recipesEntity.name
            binding.itemDescription.text = recipesEntity.description

            binding.itemImage.load(recipesEntity.url){
                crossfade(true)
                crossfade(3000)
            }
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val layoutBinding = RecipesItemRowBinding.inflate(inflater, parent, false)
                return MyViewHolder(layoutBinding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesAdapter.MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d("Recipes Adapter", "Recipes Adapter: entered bind view holder")
        val currentRecipe = recipesList[position]
        Log.d("Recipes Adapter", "Recipes Adapter: onBindViewHolder: $currentRecipe")
        holder.bind(currentRecipe)
    }

    override fun getItemCount(): Int {
        return recipesList.size
    }

    fun setData(newList: List<RecipesEntity>){
        val recipesDiffUtil = RecipesDiffUtil(recipesList, newList)
        val diffUtilResult = DiffUtil.calculateDiff(recipesDiffUtil)
        recipesList = newList
        Log.d("Recipes Adapter", "Recipes Adapter: setData: ${recipesList.size}")
        diffUtilResult.dispatchUpdatesTo(this)
    }
}