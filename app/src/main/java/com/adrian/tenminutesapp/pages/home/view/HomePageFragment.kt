package com.adrian.tenminutesapp.pages.home.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adrian.tenminutesapp.R
import com.adrian.tenminutesapp.databinding.FragmentHomePageBinding


class HomePageFragment : Fragment() {

    object logging {
        val TAG = HomePageFragment::class.java.simpleName
    }

    lateinit var binding: FragmentHomePageBinding

    companion object {
        fun newInstance(): HomePageFragment {
            val fragment = HomePageFragment()
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bind(inflater, container)
        return binding.getRoot()
    }
    private fun bind(inflater: LayoutInflater?, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
//        binding?.viewModel = viewModel as DefaultAddCostRegistryPageViewModel
        binding?.executePendingBindings()
    }

    private fun getLayoutId() = R.layout.fragment_home_page

//    private fun getVariableId(): Int {
//        return BR.viewModel
//    }

}
