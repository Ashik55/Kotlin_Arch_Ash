package com.aashiq.kotlin_arch_ash.data.local
import android.content.Context
import androidx.preference.PreferenceManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalSharedPref @Inject constructor(@ApplicationContext context : Context){

    private val userName = "userName"
    private val spEmail = "spEmail"
    private val spToken = "spToken"
    private val isNewUser = "isNewUser"
    private val id = "_id"
    private val posUserSelected = "posUserSelected"

    val prefs = PreferenceManager.getDefaultSharedPreferences(context)

    fun getPosUserSelected(): String {
        return prefs.getString(posUserSelected, "")!!
    }
    fun setPosUserSelected(query: String) {
        prefs.edit().putString(posUserSelected, query).apply()
    }




}