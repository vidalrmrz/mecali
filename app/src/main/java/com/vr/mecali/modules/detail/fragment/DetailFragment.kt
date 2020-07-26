package com.vr.mecali.modules.detail.fragment

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.vr.mecali.common.BaseFragment
import com.vr.mecali.databinding.FragmentDetailBinding
import com.vr.mecali.modules.detail.viewmodel.DetailViewModel
import com.vr.mecali.modules.search.adapters.ViewPagerAdapter
import org.koin.android.viewmodel.ext.android.getViewModel

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    lateinit var viewModel: DetailViewModel
    private val safeArgs by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        viewModel = getViewModel()
        initViews()
        addListeners()
        return binding.root
    }

    private fun initViews() {
        binding.viewModel = viewModel
        viewModel.setDetailItem(safeArgs.item)
        binding.buttonMore.setOnClickListener {
            val intent = Intent(ACTION_VIEW)
            val url = viewModel.itemDetail.value?.permalink
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }

    private fun addListeners() {
        viewModel.pictures.observe(viewLifecycleOwner, Observer {
            val adapter = ViewPagerAdapter(viewModel.pictures.value)
            binding.viewPagerCarousel.adapter = adapter
            binding.viewPagerCarousel.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        })
    }
}