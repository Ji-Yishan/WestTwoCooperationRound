package com.example.zhongchou3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.zhongchou3.API.AppService
import com.example.zhongchou3.entity.ResponseEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_login_acitiviy.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_update_age.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.jvm.internal.Intrinsics.Kotlin

class LoginAcitiviy : AppCompatActivity() {
    companion object {
        const val TAG = "LoginAcitiviy"
    }
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

            val intent = Intent(this@LoginAcitiviy, HomeActivity::class.java)
            startActivity(intent)
            // Login()
        }


    }

    private fun Login() {
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
        requestLogin(username,password)
    }

    private fun requestLogin(username: String, password: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.41.33:8080/") // 设置 网络请求 Url
            .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
            .build()
        val request = retrofit.create(AppService::class.java)
        val call= request.submitLogin(username,password)
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                println("请求成功")
                val result = response.body().string()
                Log.d(TAG, "onResponse: result = $result, isSuccess = ${response.isSuccessful}" + ", error body = ${response.errorBody()?.string()}")
                val entity: ResponseEntity = kotlin.runCatching {
                    Gson().fromJson(result, ResponseEntity::class.java)
                }.getOrNull() ?: return
                val name=entity.username
                val idcard=entity.idcard
                val contact=entity.contact
                val userid=entity.userid
                Toast.makeText(this@LoginAcitiviy, "登录成功！", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@LoginAcitiviy, HomeActivity::class.java)
                intent.putExtra("name",name)
                intent.putExtra("id",idcard)
                intent.putExtra("contact",contact)
                intent.putExtra("userid",userid)
                startActivity(intent)



            }

            override fun onFailure(call: Call<ResponseBody>, throwable: Throwable) {
                Toast.makeText(this@LoginAcitiviy,"请求失败, 请稍后再试!", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "onFailure: message = ${throwable.message}")
            }
        })
    }


}