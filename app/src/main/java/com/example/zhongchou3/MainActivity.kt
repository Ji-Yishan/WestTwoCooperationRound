package com.example.zhongchou3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val yonghu:Button=findViewById(R.id.yonghu)
        val guanli:Button=findViewById(R.id.guanli)
        yonghu.setOnClickListener {
            val intent = Intent(this, LoginAcitiviy::class.java)
            startActivity(intent)
        }
        guanli.setOnClickListener {
            val intent = Intent(this, GuanliAcitivity::class.java)
            startActivity(intent)
        }
    }
}