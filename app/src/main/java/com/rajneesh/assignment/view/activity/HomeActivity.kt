package com.rajneesh.assignment.view.activity

import android.os.Bundle
import androidx.navigation.NavController
import com.health.ness.view.activity.BaseActivity
import com.rajneesh.assignment.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    lateinit var manNavigation: NavController

    override fun setView() = R.layout.activity_home
    override fun parentView() = parentLayout

    override fun init(savedInstanceState: Bundle?) {
//        manNavigation = Navigation.findNavController(getView)
    }

    override fun declareAllViewModelObserver() {

    }
}
