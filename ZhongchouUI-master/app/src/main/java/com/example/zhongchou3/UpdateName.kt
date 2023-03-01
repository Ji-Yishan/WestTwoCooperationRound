package com.example.zhongchou3

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.example.zhongchou3.API.AppService
import com.example.zhongchou3.entity.ResponseEntity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_update_name.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UpdateName : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_name)
        btn_safe.setOnClickListener {
            updateName()
        }
    }

    private fun updateName() {
        val name=name.text.toString()
        val connect=connect.text.toString()
        val id=id.text.toString()
        if (TextUtils.isEmpty(name)){
            Toast.makeText(this,"姓名不能为空", Toast.LENGTH_SHORT).show()
            return
        }
        if (TextUtils.isEmpty(connect)){
            Toast.makeText(this,"姓名不能为空", Toast.LENGTH_SHORT).show()
            return
        }
        if (TextUtils.isEmpty(id)){
            Toast.makeText(this,"姓名不能为空", Toast.LENGTH_SHORT).show()
            return
        }
        requestName(name,connect,id)
    }

    private fun requestName(name: String, connect: String, id: String) {
        val userid=intent.getStringExtra("userid")
        Log.d(TAG,"userid is $userid")
        val user=User(name,connect,id)
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.41.33:8080/") // 设置 网络请求 Url
            .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
            .build()
        val request = retrofit.create(AppService::class.java)
        val call= request.submitMyinfor(name,connect,id,userid)
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                println("请求成功")
                val result = response.body().string()
                Log.d(LoginAcitiviy.TAG, "onResponse: result = $result, isSuccess = ${response.isSuccessful}" + ", error body = ${response.errorBody()?.string()}")
                Toast.makeText(this@UpdateName, "提交成功！", Toast.LENGTH_SHORT).show()
                val data = Intent().apply {
                    putExtra("name", name)
                    putExtra("idcard", id)
                    putExtra("contact", connect)
                }
                setResult(Activity.RESULT_OK, data)
                finish()
//                if(entity.degree==0) {
//                    val intent = Intent(this@LoginAcitiviy, HomeActivity::class.java)
//                    startActivity(intent)
//                }else if(entity.degree==1){
//                    val intent = Intent(this@LoginAcitiviy, HomeActivity::class.java)
//                    startActivity(intent)
//                }

            }

            override fun onFailure(call: Call<ResponseBody>, throwable: Throwable) {
                Toast.makeText(this@UpdateName,"请求失败, 请稍后再试!", Toast.LENGTH_SHORT).show()
                Log.d(LoginAcitiviy.TAG, "onFailure: message = ${throwable.message}")
            }
        })

    }


}