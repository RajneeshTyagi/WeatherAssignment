package com.rajneesh.assignment.util

import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.rajneesh.assignment.R


/**
 * Created by rajneeshkumar on 3/18/18.
 */
class TypefaceUtil {
    companion object {


        /**
         * Using reflection to override default typeface
         * NOTICE: DO NOT FORGET TO SET TYPEFACE FOR APP THEME AS DEFAULT TYPEFACE WHICH WILL BE OVERRIDDEN
         *
         * @param context                    to work with assets
         * @param defaultFontNameToOverride  for example "monospace"
         * @param customFontFileNameInAssets file name of the font from assets
         */
        fun overrideFont(
            context: Context,
            defaultFontNameToOverride: String,
            customFontFileNameInAssets: String
        ) {

            val customFontTypeface =
                Typeface.createFromAsset(context.assets, customFontFileNameInAssets)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val newMap = HashMap<String, Typeface>()
                newMap["serif"] = customFontTypeface
                try {
                    val staticField = Typeface::class.java
                        .getDeclaredField("sSystemFontMap")
                    staticField.isAccessible = true
                    staticField.set(null, newMap)
                } catch (e: NoSuchFieldException) {
                    e.printStackTrace()
                } catch (e: IllegalAccessException) {
                    e.printStackTrace()
                }

            } else {
                try {
                    val defaultFontTypefaceField =
                        Typeface::class.java.getDeclaredField(defaultFontNameToOverride)
                    defaultFontTypefaceField.isAccessible = true
                    defaultFontTypefaceField.set(null, customFontTypeface)
                } catch (e: Exception) {
                    Log.e(
                        TypefaceUtil::class.java.simpleName,
                        "Can not set custom font $customFontFileNameInAssets instead of $defaultFontNameToOverride"
                    )
                }

            }
        }

        fun overrideFonts(context: Context, v: View) {
            try {
                when (v) {
                    is ViewGroup -> for (i in 0 until v.childCount) {
                        val child = v.getChildAt(i)
                        overrideFonts(
                            context,
                            child
                        )
                    }
                    is TextView -> {
                        if (v.textColors == null)
                            v.setTextColor(R.color.textViewColor)
                        v.typeface = Typeface.createFromAsset(context.assets, "fonts/PTF55F.ttf")
                    }
                    is EditText -> {
                        if (v.textColors == null)
                            v.setTextColor(R.color.textViewColor)
                        v.typeface = Typeface.createFromAsset(context.assets, "fonts/PTF55F.ttf")
                    }
                    is Button -> {
                        if (v.textColors == null)
                            v.setTextColor(R.color.textViewColor)
                        v.typeface = Typeface.createFromAsset(context.assets, "fonts/PTF55F.ttf")
                    }
                }
            } catch (e: Exception) {
            }

        }
    }

}