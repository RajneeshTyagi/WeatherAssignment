package com.health.ness.view.activity

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.rajneesh.assignment.util.TypefaceUtil

/**
 * Created by rajneeshkumar on 04/05/2020.
 */

abstract class BaseActivity : AppCompatActivity() {
    abstract fun setView(): Int
    abstract fun parentView(): View
    abstract fun init(savedInstanceState: Bundle?)
    abstract fun declareAllViewModelObserver()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar?.hide()

        setContentView(setView())
        init(savedInstanceState)
        declareAllViewModelObserver()
        TypefaceUtil.overrideFonts(this, parentView())
    }


    fun showToolBarBack() {
        try {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setHomeButtonEnabled(true)
        } catch (e: Exception) {
        }
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    fun showBottomToast(message: String) {
        Snackbar.make(parentView(), message, Snackbar.LENGTH_LONG).show()
    }


}