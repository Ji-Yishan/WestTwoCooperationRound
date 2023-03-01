package com.example.zhongchou3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.zhongchou3.API.AppService
import com.example.zhongchou3.entity.ResponseEntity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_register_acitiviy.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegisterAcitiviy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_acitiviy)
        reg_btn.setOnClickListener {
            register()
        }
    }

    private fun register() {
        var username=log_account.text.toString()
        var password=log_password.text.toString()
        if(TextUtils.isEmpty(username)){
            Toast.makeText(this,"用户名不能为空", Toast.LENGTH_SHORT).show()
            return
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"密码不能为空", Toast.LENGTH_SHORT).show()
            return
        }
        requestRegister(username,password)
    }

    private fun requestRegister(username: String, password: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.41.33:8080/") // 设置 网络请求 Url
            .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
            .build()
        val request = retrofit.create(AppService::class.java)
        val call= request.submitRegister(username,password)
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                println("请求成功")
                val result = response.body().string()
                System.out.println(result)
                //val entity: ResponseEntity = Gson().fromJson(result, ResponseEntity::class.java)
                Toast.makeText(this@RegisterAcitiviy, "注册成功！", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@RegisterAcitiviy, LoginAcitiviy::class.java)
                startActivity(intent)
            }

            override fun onFailure(call: Call<ResponseBody>, throwable: Throwable) {
                println("请求失败")
                println(throwable.message)
            }
        })
    }
}