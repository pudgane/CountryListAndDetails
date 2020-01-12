package com.pudagane.countrylist

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.PersistableBundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    private var progress: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

      //  changeStatusBarColor()

    }

    fun changeStatusBarColor() {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.colorPrimaryDark)
        }
    }

    fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    /** CHECK WHETHER INTERNET CONNECTION IS AVAILABLE OR NOT  */
    fun checkConnection(context: Context): Boolean {
        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetworkInfo = connMgr.activeNetworkInfo

        if (activeNetworkInfo != null) { // connected to the internet
            //  Toast.makeText(context, activeNetworkInfo.typeName, Toast.LENGTH_SHORT).show()

            if (activeNetworkInfo.type == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                return true
            } else if (activeNetworkInfo.type == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
                return true
            }
        }
        return false
    }

    fun showProgressBar(message: String = "Please wait") {
        progress = ProgressDialog(this@BaseActivity)
        progress!!.setMessage(message)
        progress!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        progress!!.setIndeterminate(true)
        progress!!.setCancelable(false)
        progress!!.setProgress(0)
        progress!!.show()
    }

    fun hideProgressBar() {
        if (progress!!.isShowing()) {
            progress!!.dismiss()
        }
    }


    fun showInformationMessgeDialog(message: String?) {
        // Initialize a new instance of
        val builder = AlertDialog.Builder(this)

        // Set the alert dialog title
        builder.setTitle("Alert")

        // Display a message on alert dialog
        builder.setMessage(message)

        // Set a positive button and its click listener on alert dialog
        builder.setNeutralButton("OK") { dialog, which ->
        }


    }

    fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun showErrorToast(message: String? = "Some error occured, Please try again.") {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}