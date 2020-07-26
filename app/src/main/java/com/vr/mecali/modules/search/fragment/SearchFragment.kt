package com.vr.mecali.modules.search.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.vr.mecali.common.BaseFragment
import com.vr.mecali.databinding.FragmentSearchBinding
import com.vr.mecali.modules.search.adapters.SearchAdapter
import com.vr.mecali.modules.search.viewmodel.SearchViewModel
import org.koin.android.viewmodel.ext.android.getViewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    lateinit var viewModel: SearchViewModel
    var adapter: SearchAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater)
        binding.lifecycleOwner = this
        viewModel = getViewModel()
        initViews()
        addListeners()
        return binding.root
    }

    private fun addListeners() {
        viewModel.searchList.observe(viewLifecycleOwner, Observer {
            if (it.isEmpty()) {
                binding.imageViewNoResult.visibility = VISIBLE
                binding.recyclerViewResults.visibility = GONE
            } else {
                binding.imageViewNoResult.visibility = GONE
                binding.recyclerViewResults.visibility = VISIBLE
            }
            adapter?.submitList(it)
        })
    }

    private fun initViews() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.excecuteSearch(query)
                val imm: InputMethodManager =
                    requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view!!.windowToken, 0)
                return true
            }
        })
        binding.recyclerViewResults.itemAnimator = DefaultItemAnimator()
        binding.recyclerViewResults.layoutManager = LinearLayoutManager(context)
        adapter = SearchAdapter {
            findNavController().navigate(
                SearchFragmentDirections.actionSearchFragmentDestToDetailFragmentDest(
                    it
                )
            )
        }
        binding.recyclerViewResults.adapter = adapter
    }
}