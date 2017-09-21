package com.adrian.tenminutesapp.pages.home.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.adrian.tenminutesapp.R
import com.adrian.tenminutesapp.databinding.ActivityTenMinutesBinding
import com.adrian.tenminutesapp.pages.home.viewmodel.TenMinutesViewModel
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class TenMinutesActivity : AppCompatActivity(), TenMinutesRouter, HasSupportFragmentInjector {

    object logging {
        val TAG = TenMinutesActivity::class.java.simpleName
    }

    lateinit var binding: ActivityTenMinutesBinding

    @Inject lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject lateinit var viewModel: TenMinutesViewModel

    /**
     * Dagger injector method build/inject fragments for this activity
     */
    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidInjection.inject(this)
        bind()

        viewModel.onCreate()

//        setUpuploadBalanceOnLongClickListener()

        var mFragmentManager = supportFragmentManager
        var mFragmentTransaction = mFragmentManager.beginTransaction()
        mFragmentTransaction.replace(binding.contentFrame.id, HomePageFragment.newInstance())
        mFragmentTransaction.commit()
    }

//    private fun setUpuploadBalanceOnLongClickListener() {
//        binding.uploadBalance.setOnLongClickListener(object : View.OnLongClickListener {
//            override fun onLongClick(p0: View?): Boolean {
//                viewModel.setupBalance(binding?.uploadBalanceAmount.text.toString());
//                return true
//            }
//        })
//    }

    private fun bind() {
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding?.viewModel = viewModel
        binding?.executePendingBindings()
    }


//    fun getVariableId(): Int {
//        return BR.viewModel
//    }

    fun getLayoutId() = R.layout.activity_ten_minutes
}
