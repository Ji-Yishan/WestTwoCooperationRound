package com.example.zhongchou3

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.example.zhongchou3.API.AppService
import kotlinx.android.synthetic.main.activity_help.*
import kotlinx.android.synthetic.main.activity_update_age.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class Help : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        val fund =intent.getSerializableExtra("fund") as Fund
        val id=fund.id

        helpmoney.filters = arrayOf(DecimalDigitsInputFilter(5, 2))
        var haveraise:Float=0f
        raise.setText(haveraise.toString())

        btn_helpmoney.setOnClickListener {
            //离线逻辑
            val addmoney=helpmoney.text.toString().toFloatOrNull() ?: 0f
            haveraise+=addmoney
            raise.setText(haveraise.toString())



            //逻辑业务
           // Helpmoney(id)
        }
    }

    private fun Helpmoney(id:String) {
        val helpmoney=helpmoney.text.toString()
        if(TextUtils.isEmpty(helpmoney)){
            Toast.makeText(this,"出资不能为空", Toast.LENGTH_SHORT).show()
            return
        }
        requestMoney(helpmoney,id)
    }

    private fun requestMoney(helpmoney: String,id: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.41.33:8080/") // 设置 网络请求 Url
            .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
            .build()
        val request = retrofit.create(AppService::class.java)
        val call= request.submitHelp("1",helpmoney)
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                println("请求成功")
               val result = response.body().string()
                System.out.println(result)
              //  Log.d(ContentValues.TAG, "onResponse: result = $result, isSuccess = ${response.isSuccessful}" + ", error body = ${response.errorBody().string()}")
                // val entity: ResponseEntity = Gson().fromJson(result, ResponseEntity::class.java)
                Toast.makeText(this@Help, "提交成功！", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@Help, HomeActivity::class.java)
                intent.putExtra("mtab02",1)
                startActivity(intent)
            }

            override fun onFailure(call: Call<ResponseBody>, throwable: Throwable) {
                println("请求失败")
                println(throwable.message)
            }

        })

    }


}