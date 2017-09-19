package com.adrian.tenminutesapp.pages.home.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.adrian.tenminutesapp.R
import com.adrian.tenminutesapp.databinding.ActivityHomePageBinding
import com.adrian.tenminutesapp.pages.home.viewmodel.HomePageViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class HomePageActivity : AppCompatActivity(), HomePageRouter {

    object logging {
        val TAG = HomePageActivity::class.java.simpleName
    }

    lateinit var binding: ActivityHomePageBinding

    @Inject lateinit var viewModel: HomePageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        AndroidInjection.inject(this)
        bind()
    }

    private fun bind() {
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding?.viewModel = viewModel
        binding?.executePendingBindings()
    }

//    fun getVariableId(): Int {
//        return BR.viewModel
//    }

    fun getLayoutId() = R.layout.activity_home_page
}
