package com.rajneesh.assignment.view.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.rajneesh.assignment.R
import kotlinx.android.synthetic.main.fragment_splash.*

class SplashFragment : BaseFragment() {
    lateinit var mHomeNavigation: NavController
    override fun parentView() = parentLayout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val listItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_splash,
            container,
            false
        ) as ViewDataBinding

        return listItemBinding.root

    }

    override fun init(view: View, savedInstanceState: Bundle?) {
        mHomeNavigation = Navigation.findNavController(view)
        Handler().postDelayed({
            mHomeNavigation.navigate(R.id.action_splashFragment_to_homeFragment)
        }, 2000)
    }

    override fun declareAllViewModelObserver() {
    }

}
