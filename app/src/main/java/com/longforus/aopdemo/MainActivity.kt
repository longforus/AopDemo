package com.longforus.aopdemo

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var waterDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            val trim = editText.text.toString().trim()
            if (trim.isNotEmpty()) {
                sendBroadcast(Intent("android.intent.ACTION_DECODE_DATA").putExtra("barcode_string",trim))
            }
        }
        waterDialog = Dialog(this, R.style.ActionSheetDialogStyle)

        button2.setOnClickListener @OneClick(1000) {
            showWaterDialog(it)
        }
    }


    private fun showWaterDialog(it: View) {
        val inflate = LayoutInflater.from(this).inflate(R.layout.dialog_bottom, null)
        inflate.minimumWidth = this.windowManager.defaultDisplay.width
        val window = waterDialog?.window
        window?.let {
            window.setGravity(Gravity.LEFT or Gravity.BOTTOM)
            val attributes = window.attributes
            attributes.x = 0
            attributes.y = 0
            window.attributes = attributes
            waterDialog?.setContentView(inflate)
            waterDialog?.show()
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }


}
