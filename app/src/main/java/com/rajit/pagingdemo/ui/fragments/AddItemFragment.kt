package com.rajit.pagingdemo.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.rajit.pagingdemo.R
import com.rajit.pagingdemo.data.local.entities.RecipesEntity
import com.rajit.pagingdemo.databinding.FragmentAddItemBinding
import com.rajit.pagingdemo.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddItemFragment : Fragment() {

    private var _binding: FragmentAddItemBinding? = null
    private val binding get() = _binding!!

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddItemBinding.inflate(layoutInflater, container, false)

        binding.submitBtn.setOnClickListener {

            binding.submitBtn.isEnabled = false

            val name = binding.nameEdt.editText?.text?.trim().toString()
            val description = binding.descriptionEdt.editText?.text?.trim().toString()
            val url = binding.itemUrlEdt.editText?.text?.trim().toString()

            if (name.isNotEmpty() || description.isNotEmpty() || url.isNotEmpty()) {

                val recipe = RecipesEntity(name, description, url)
                mainViewModel.insertRecipes(recipe)
                findNavController().navigate(R.id.action_addItemFragment_to_mainFragment)

            } else {
                Toast.makeText(requireContext(), "Please fill all the fields", Toast.LENGTH_SHORT)
                    .show()
            }

        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}