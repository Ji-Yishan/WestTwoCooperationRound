package com.example.zhongchou3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginAcitiviy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_acitiviy)
        val login_register:Button=findViewById(R.id.login_regiser_btn)
        login_register.setOnClickListener {
            val intent = Intent(this, RegisterAcitiviy::class.java)
            startActivity(intent)
        }
        val login:Button=findViewById(R.id.login_btn)
        login.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}