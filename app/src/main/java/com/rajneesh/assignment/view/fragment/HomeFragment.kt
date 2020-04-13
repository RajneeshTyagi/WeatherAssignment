package com.rajneesh.assignment.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.rajneesh.assignment.R
import com.rajneesh.assignment.databinding.FragmentHomeBinding
import com.rajneesh.assignment.viewModel.WhetherViewModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseFragment() {

    override fun parentView() = parentLayout

    lateinit var mWhetherViewModel: WhetherViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var listItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_home,
            container,
            false
        ) as FragmentHomeBinding
        mWhetherViewModel = ViewModelProviders.of(this).get(WhetherViewModel::class.java)
        listItemBinding.whetherViewModel = mWhetherViewModel
        listItemBinding.lifecycleOwner = this
        return listItemBinding.root

    }

    override fun init(view: View, savedInstanceState: Bundle?) {
        mWhetherViewModel.getCurrentWhether()
    }

    override fun declareAllViewModelObserver() {
//        mWhetherViewModel.getRequest().observe(this, Observer {
//
//        })
//        mWhetherViewModel.getLocation().observe(this, Observer {
//
//        })
//        mWhetherViewModel.getCurrent().observe(this, Observer {
//
//        })
    }

}
