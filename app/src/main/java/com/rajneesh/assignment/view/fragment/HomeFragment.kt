package com.rajneesh.assignment.view.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rajneesh.assignment.R
import com.rajneesh.assignment.viewModel.WhetherViewModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseFragment() {

    override fun parentView() = parentLayout

    lateinit var mWhetherViewModel: WhetherViewModel

    override fun init(view: View, savedInstanceState: Bundle?) {
        mWhetherViewModel = ViewModelProviders.of(this).get(WhetherViewModel::class.java)
        mWhetherViewModel.getCurrentWhether()

    }

    override fun declareAllViewModelObserver() {
        mWhetherViewModel.getRequest().observe(this, Observer {

        })
        mWhetherViewModel.getLocation().observe(this, Observer {

        })
        mWhetherViewModel.getCurrent().observe(this, Observer {

        })
    }

}
