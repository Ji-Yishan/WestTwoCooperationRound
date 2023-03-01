package com.example.zhongchou3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zhongchou3.API.AppService
import com.example.zhongchou3.Adapter.CheckAdapter
import com.example.zhongchou3.Adapter.FundAdapter
import com.example.zhongchou3.Adapter.MyAdapter
import com.example.zhongchou3.entity.ResponseEntity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_guanli.*
import kotlinx.android.synthetic.main.top_mybar.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.DELETE

class GuanliActivity : AppCompatActivity() {
    val NoCheckList=ArrayList<Fund>()
    val HaveCheckList=ArrayList<Fund>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guanli)
        val mylayoutManager = LinearLayoutManager(this)
        mylayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        myrecycleview.layoutManager = mylayoutManager
        val hclayoutManager = LinearLayoutManager(this)
        hclayoutManager.orientation = LinearLayoutManager.VERTICAL
        hcrecycleview.layoutManager = hclayoutManager

        initNoCheckFund()
        val myadapter = CheckAdapter(NoCheckList)
        myrecycleview.adapter = myadapter
        myadapter.setOnItemClickListener {
            val intent= Intent(this,FundDetail::class.java)
            intent.putExtra("fund", NoCheckList.get(it))//强转
            startActivity(intent) }
        //审核
        myadapter.setOnDelet {
            val deletfund=HaveCheckList[it]
            if (it>0&&it<HaveCheckList.size) {
                HaveCheckList.removeAt(it)
                myadapter.notifyItemRemoved(it)
                myadapter.notifyItemRangeChanged(it, HaveCheckList.size - it, "removeItem")
            }
            //逻辑业务
            //fairFund(deletfund.id)
        }
        myadapter.setOnPass {
            val passfund=HaveCheckList[it]
            if (it>0&&it<HaveCheckList.size) {
                HaveCheckList.removeAt(it)
                myadapter.notifyItemRemoved(it)
                myadapter.notifyItemRangeChanged(it, HaveCheckList.size - it, "removeItem")
            }
            //逻辑业务
            //passFund(passfund.id)
        }

        //处理
        initHaveCheckFund()
        val hcadapter = MyAdapter(HaveCheckList)
        hcrecycleview.adapter = hcadapter
        hcadapter.setOnDelet {
            val deletfund=HaveCheckList[it]
            if (it>0&&it<HaveCheckList.size) {
                HaveCheckList.removeAt(it)
                hcadapter.notifyItemRemoved(it)
                hcadapter.notifyItemRangeChanged(it, HaveCheckList.size - it, "removeItem")
            }
            //逻辑业务
            //deletFund(deletfund.id)
        }
        hcadapter.setOnItemClickListener {
            val intent= Intent(this,FundDetail::class.java)
            intent.putExtra("fund", HaveCheckList.get(it))//强转
            startActivity(intent) }

        guanli_exit.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
    }

    private fun deletFund(id: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.41.33:8080/") // 设置 网络请求 Url
            .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
            .build()
        val request = retrofit.create(AppService::class.java)
        val call= request.deletFund(id)
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                println("请求成功")
                val result = response.body().string()
                Log.d(LoginAcitiviy.TAG, "onResponse: result = $result, isSuccess = ${response.isSuccessful}" + ", error body = ${response.errorBody()?.string()}")
                val entity: ResponseEntity = kotlin.runCatching {
                    Gson().fromJson(result, ResponseEntity::class.java)
                }.getOrNull() ?: return
                Toast.makeText(this@GuanliActivity, "登录成功！", Toast.LENGTH_SHORT).show()



            }

            override fun onFailure(call: Call<ResponseBody>, throwable: Throwable) {
                Toast.makeText(this@GuanliActivity,"请求失败, 请稍后再试!", Toast.LENGTH_SHORT).show()
                Log.d(LoginAcitiviy.TAG, "onFailure: message = ${throwable.message}")
            }
        })
    }


    private fun passFund(id: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.41.33:8080/") // 设置 网络请求 Url
            .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
            .build()
        val request = retrofit.create(AppService::class.java)
        val call= request.checkFund(id,1)
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                println("请求成功")
                val result = response.body().string()
                Log.d(LoginAcitiviy.TAG, "onResponse: result = $result, isSuccess = ${response.isSuccessful}" + ", error body = ${response.errorBody()?.string()}")
                val entity: ResponseEntity = kotlin.runCatching {
                    Gson().fromJson(result, ResponseEntity::class.java)
                }.getOrNull() ?: return
                Toast.makeText(this@GuanliActivity, "登录成功！", Toast.LENGTH_SHORT).show()



            }

            override fun onFailure(call: Call<ResponseBody>, throwable: Throwable) {
                Toast.makeText(this@GuanliActivity,"请求失败, 请稍后再试!", Toast.LENGTH_SHORT).show()
                Log.d(LoginAcitiviy.TAG, "onFailure: message = ${throwable.message}")
            }
        })


    }

    private fun fairFund(id: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.41.33:8080/") // 设置 网络请求 Url
            .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
            .build()
        val request = retrofit.create(AppService::class.java)
        val call= request.checkFund(id,2)
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                println("请求成功")
                val result = response.body().string()
                Log.d(LoginAcitiviy.TAG, "onResponse: result = $result, isSuccess = ${response.isSuccessful}" + ", error body = ${response.errorBody()?.string()}")
                val entity: ResponseEntity = kotlin.runCatching {
                    Gson().fromJson(result, ResponseEntity::class.java)
                }.getOrNull() ?: return
                Toast.makeText(this@GuanliActivity, "登录成功！", Toast.LENGTH_SHORT).show()



            }

            override fun onFailure(call: Call<ResponseBody>, throwable: Throwable) {
                Toast.makeText(this@GuanliActivity,"请求失败, 请稍后再试!", Toast.LENGTH_SHORT).show()
                Log.d(LoginAcitiviy.TAG, "onFailure: message = ${throwable.message}")
            }
        })
    }

    private fun initHaveCheckFund() {
        HaveCheckList.add(Fund("李华10","10666654","50000","白血病",R.mipmap.img,"0","1"))
        HaveCheckList.add(Fund("李华11","11666654","50000","白血病",R.mipmap.img,"0","2"))

    }

    private fun initNoCheckFund() {
        NoCheckList.add(Fund("李华10","10666654","50000","白血病",R.mipmap.img,"0","3"))
        NoCheckList.add(Fund("李华11","11666654","50000","白血病",R.mipmap.img,"0","4"))

    }


}