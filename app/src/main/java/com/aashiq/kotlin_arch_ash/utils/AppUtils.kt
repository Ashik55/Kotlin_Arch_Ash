package com.aashiq.kotlin_arch_ash.utils

import android.app.Activity
import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.content.Context
import android.provider.Settings
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import java.lang.NumberFormatException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


object AppUtils {

    lateinit var progressDialog: ProgressDialog

    fun showKeyboard(activity: Activity, editText: EditText) {
        try {
            editText.requestFocus()
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.toggleSoftInput(
                InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY
            )
        } catch (e: Exception) {

        }
    }

    fun hideKeyboard(activity: Activity) {
        val view = activity.findViewById<View>(android.R.id.content)
        try {
            val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        } catch (e: Exception) {

        }
    }


    fun removeBrackets(text: String): String {
        return text.replace("[", "").replace("]", "")
    }

    fun getDeviceID(context: Context): String? {
        return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
    }


    fun getDaysDifference(fromDate: Date?, toDate: Date?): Long {
        return if (fromDate == null || toDate == null) 0 else ((toDate.time - fromDate.time) / (1000 * 60 * 60 * 24))
    }


    fun showLoading(activity: Activity, message: String = "Loading..") {
        progressDialog = ProgressDialog(activity)
        progressDialog.setMessage(message)
        progressDialog.setCancelable(false)
        progressDialog.show()
    }

    fun hideLoading() {
        if (progressDialog != null && progressDialog.isShowing) {
            progressDialog.dismiss()
        }
    }

    fun getDateFormat(date: String): String {
        return SimpleDateFormat("MMM dd, yyyy hh.mm aa").format(
            SimpleDateFormat("yyyy-MM-dd").parse(
                date
            )
        )
    }


    fun isValidPhoneNumber(number: String?): Boolean {
        return number != null && number != "" && number.length < 11 && number.length > 9 && TextUtils.isDigitsOnly(
            "0123456789"
        )
    }

    fun isValidOTP(number: String?): Boolean {
        return number != null && number != "" && number.length < 5 && number.length > 3 && TextUtils.isDigitsOnly(
            "0123456789"
        )
    }

    fun isValidPassword(number: String?): Boolean {
        return number != null && number != "" && number.length < 15 && number.length > 1
    }


    fun getSubstring(st: String): String {
        if (st.length > 25)
            return st.substring(0, 22).toString() + " . . ."
        else
            return st
    }

    fun getBracketText(value: String): String {
        return "(" + value + ")"
    }

    fun getMainPhone(st: String): String {

        return st.substring(5, st.length)

    }



//    fun showToast(message: String?) {
//        Toast.makeText(SindabadMM.instance, message, Toast.LENGTH_SHORT).show()
//    }

    fun getDateFromMili(milliSeconds: Long, dateFormat: String?): String? {
        val formatter = SimpleDateFormat(dateFormat)
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliSeconds
        return formatter.format(calendar.time)
    }



    fun datePickerDialog(context: Context, textView: TextView, additionalText: String?) {
        val cldr = Calendar.getInstance()
        val day = cldr[Calendar.DAY_OF_MONTH]
        val month = cldr[Calendar.MONTH]
        val year = cldr[Calendar.YEAR]
        var picker = DatePickerDialog(
            context,
            { view, year, monthOfYear, dayOfMonth ->
                textView.text =
                    additionalText + dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year
            },
            year,
            month,
            day
        )
        picker.show()
    }





    fun addCommaSeparator(num: Number?): String? {
        var s: String? = null
        try {
            s = String.format("%,d", num.toString().toLong())
        } catch (e: NumberFormatException) {
        }

        return s
    }


}