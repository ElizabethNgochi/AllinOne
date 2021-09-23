package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var button_reg: Button? = null
    var button_login: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_reg = findViewById(R.id.mBtnReg)
        button_reg!!.setOnClickListener {
            var myIntent = Intent(this, RegisterActivity::class.java)
            startActivity(myIntent)
        }

        button_login = findViewById(R.id.mBtnLogin)
        button_login!!.setOnClickListener {
            var myIntent = Intent(this, LoginActivity::class.java)
            startActivity(myIntent)
        }
    }
}