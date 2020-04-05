package com.rajneesh.assignment.view.fragment

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.rajneesh.assignment.R
import kotlinx.android.synthetic.main.fragment_splash.*

class SplashFragment : BaseFragment() {
    lateinit var mHomeNavigation: NavController
    override fun parentView() = parentLayout

    override fun init(view: View, savedInstanceState: Bundle?) {
        mHomeNavigation = Navigation.findNavController(view)
        Handler().postDelayed({
            //            LoginFragment.start(this)
//            HomeActivity.start(this)
//            finish()
            mHomeNavigation.navigate(R.id.action_splashFragment_to_homeFragment)
        }, 2000)
    }

    override fun declareAllViewModelObserver() {
    }

}
