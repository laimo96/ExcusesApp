package com.example.excusesapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.excusesapp.R
import com.example.excusesapp.adapter.ExcusesAdapter
import com.example.excusesapp.databinding.FragmentChildrenExcusesBinding
import com.example.excusesapp.databinding.FragmentCollegeExcusesBinding
import com.example.excusesapp.model.Excuses
import com.example.excusesapp.utils.UIState


class CollegeExcusesFragment : BaseFragment() {
    private val binding by lazy {
        FragmentCollegeExcusesBinding.inflate(layoutInflater)
    }

    private val excusesAdapter by lazy {
        ExcusesAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initRecyclerView()
        observeData()
        return binding.root
    }

    private fun initRecyclerView() {
        //Recycler View
        binding.collegeExcusesRv.apply {
            this.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = excusesAdapter
        }
    }

    private fun observeData() {
        excusesViewModel.collegeExcuses.observe(viewLifecycleOwner) { state ->

            when (state) {

                is UIState.LOADING -> {
                    //Load Spinner
                }

                is UIState.SUCCESS -> {
                    // Update adapter
                    excusesAdapter.setExcuses(state.response as MutableList<Excuses>)
                }

                is UIState.ERROR -> {
                    // Show error dialog
                    state.error.localizedMessage?.let {
                        showError(it) {
                            excusesViewModel.getCollegeExcuses()
                        }
                    }
                }
                else -> {}
            }
        }
        excusesViewModel.getCollegeExcuses()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.let {
            null
        }
    }
}