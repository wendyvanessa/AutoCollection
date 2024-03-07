package com.example.autocollection.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.autocollection.R

/**
 * reified es para tener acceso a los tipos de datos en tiempo de ejecución
 */

inline fun <reified T: Activity> Context.startActivity(vararg pairs: Pair<String, Any?>){
    Intent(this,T::class.java)
        .apply { putExtras(bundleOf(*pairs)) }
        .also(::startActivity)
}

/**
 * Creación de función de extención sobre ImageView que se llamará "loadUrl"
 */
fun ImageView.loadUrl(url: String,isProfile: Boolean){
    if (isProfile){ Glide.with(this).load(url).circleCrop().into(this) }
    else Glide.with(this)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .into(this)
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int):View{

    return  LayoutInflater
        .from(context)
        .inflate(R.layout.item_car,this,false)
}

