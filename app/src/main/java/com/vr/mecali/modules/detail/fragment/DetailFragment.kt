package com.vr.mecali.modules.detail.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vr.mecali.common.BaseFragment
import com.vr.mecali.databinding.FragmentDetailBinding

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater)
        initViews()
        return binding.root
    }

    private fun initViews() {
    }
}