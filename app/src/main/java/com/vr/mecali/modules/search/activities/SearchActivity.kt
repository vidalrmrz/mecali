package com.vr.mecali.modules.search.activities

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.vr.mecali.R
import com.vr.mecali.common.BaseActivity
import com.vr.mecali.databinding.ActivitySearchBinding

class SearchActivity : BaseActivity() {

    lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        binding.lifecycleOwner = this
    }
}