package com.rajit.pagingdemo.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.rajit.pagingdemo.R
import com.rajit.pagingdemo.adapter.RecipesAdapter
import com.rajit.pagingdemo.databinding.FragmentMainBinding
import com.rajit.pagingdemo.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val mAdapter: RecipesAdapter by lazy { RecipesAdapter() }

    private val mainViewModel by viewModels<MainViewModel>()

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)

        binding.recipesRv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
            setHasFixedSize(true)
        }

        mainViewModel.recipesResponse.observe(viewLifecycleOwner) { result ->
            mAdapter.setData(result)
        }

        binding.addItem.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_addItemFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}