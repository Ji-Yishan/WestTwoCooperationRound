package com.example.zhongchou3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import com.example.zhongchou3.API.AppService
import com.example.zhongchou3.entity.ResponseEntity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login_acitiviy.*
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val yonghu:Button=findViewById(R.id.yonghu)
        yonghu.setOnClickListener {
            val intent = Intent(this,LoginAcitiviy::class.java)
            startActivity(intent)
        }
        guanli.setOnClickListener {
            val intent = Intent(this,GuanliLogin::class.java)
            startActivity(intent)
        }

    }


}
