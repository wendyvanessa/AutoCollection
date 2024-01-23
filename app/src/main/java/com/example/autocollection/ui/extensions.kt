package com.example.autocollection.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.core.os.bundleOf

/**
 * reified es para tener acceso a los tipos de datos en tiempo de ejecución
 */

inline fun <reified T: Activity> Context.startActivity(vararg pairs: Pair<String, Any?>){
    Intent(this,T::class.java)
        .apply { putExtras(bundleOf(*pairs)) }
        .also(::startActivity)
}

