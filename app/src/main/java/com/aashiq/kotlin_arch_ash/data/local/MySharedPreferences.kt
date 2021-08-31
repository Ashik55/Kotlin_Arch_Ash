package com.aashiq.kotlin_arch_ash.data.local

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.aashiq.kotlin_arch_ash.MyApplication


object MySharedPreferences {

    private val userName = "userName"
    private val spEmail = "spEmail"
    private val spToken = "spToken"
    private val isNewUser = "isNewUser"
    private val id = "_id"
    private val posUserSelected = "posUserSelected"




    private fun getSharedPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }



    fun setPosUserSelected(value: Boolean) {
        getSharedPreferences(MyApplication.instance).edit().putBoolean(posUserSelected, value).apply()
    }

    fun getPosUserSelected(): Boolean? {
        return getSharedPreferences(MyApplication.instance).getBoolean(posUserSelected, false)
    }


    fun setUserId(value: String?) {
        getSharedPreferences(MyApplication.instance).edit().putString(id, value).apply()
    }

    fun getUserId(): String? {
        return getSharedPreferences(MyApplication.instance).getString(id, null)
    }



    fun setEmail(value: String?) {
        value?.let {
            getSharedPreferences(MyApplication.instance).edit().putString(spEmail, it).apply()
        }
    }

    fun getEmail(): String? {
        return getSharedPreferences(MyApplication.instance).getString(spEmail, null)
    }


    fun setUserName(value: String?) {
        getSharedPreferences(MyApplication.instance).edit().putString(userName, value).apply()
    }

    fun getUserName(): String? {
        return getSharedPreferences(MyApplication.instance).getString(userName, null)
    }


    fun setToken(value: String?) {
        getSharedPreferences(MyApplication.instance).edit().putString(spToken, value).apply()
    }

    fun getToken(): String? {
        return getSharedPreferences(MyApplication.instance).getString(spToken, null)
    }


    fun clearSP(){
        getSharedPreferences(MyApplication.instance).edit().clear().commit()
        getSharedPreferences(MyApplication.instance).edit().putBoolean(isNewUser, false).apply()
    }

}