package com.vr.mecali.modules.search.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import com.vr.mecali.common.BaseFragment
import com.vr.mecali.databinding.FragmentSearchBinding
import com.vr.mecali.modules.search.viewmodel.SearchViewModel
import org.koin.android.viewmodel.ext.android.getViewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    lateinit var viewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater)
        binding.lifecycleOwner = this
        viewModel = getViewModel()
        initViews()
        return binding.root
    }

    private fun initViews() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.excecuteSearch(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.excecuteSearch(query)
                return true
            }
        })
    }
}