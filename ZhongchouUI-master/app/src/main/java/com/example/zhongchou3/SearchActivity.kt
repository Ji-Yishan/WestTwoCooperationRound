package com.example.zhongchou3

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView


import android.widget.Toast
import com.example.zhongchou3.API.AppService
import com.example.zhongchou3.entity.FundEntity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SearchActivity : AppCompatActivity() {
    lateinit var searchView: SearchView
    lateinit var listView: ListView
    lateinit var list: ArrayList<Fund>
    lateinit var adapter: ArrayAdapter<*>
    var page=1
    val searchtext=searchView.query.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        last.setOnClickListener {
            if (page>1){
                page++
            }
        }
        next.setOnClickListener {
            if (page<3){
                page--
            }
        }
        //离线业务
        val List=ArrayList<Fund>()
        val List2=ArrayList<Fund>()
        val List3=ArrayList<Fund>()
        List.add(Fund("李华1","1666654","50000","白血病",R.mipmap.img,"0","1"))
        List.add(Fund("李华2","2666654","50000","白血病",R.mipmap.img,"0","2"))
        List.add(Fund("李华3","3666654","50000","白血病",R.mipmap.img,"0","3"))
        List.add(Fund("李华4","4666654","50000","白血病",R.mipmap.img,"0","4"))
        List.add(Fund("李华5","5666654","50000","白血病",R.mipmap.img,"0","5"))
        List2.add(Fund("李华6","6666654","50000","白血病",R.mipmap.img,"0","6"))
        List2.add(Fund("李华7","7666654","50000","白血病",R.mipmap.img,"0","7"))
        List2.add(Fund("李华8","8666654","50000","白血病",R.mipmap.img,"0","8"))
        List2.add(Fund("李华9","9666654","50000","白血病",R.mipmap.img,"0","9"))
        List2.add(Fund("李华10","10666654","50000","白血病",R.mipmap.img,"0","10"))
        List3.add(Fund("李华11","11666654","50000","白血病",R.mipmap.img,"0","11"))
        List3.add(Fund("李华12","11666654","50000","白血病",R.mipmap.img,"0","12"))
        List3.add(Fund("李华13","11666654","50000","白血病",R.mipmap.img,"0","13"))
        List3.add(Fund("李华14","11666654","50000","白血病",R.mipmap.img,"0","14"))
        List3.add(Fund("李华15","11666654","50000","白血病",R.mipmap.img,"0","15"))
        searchView = findViewById(R.id.searchView)
        listView = findViewById(R.id.listView)
        list = ArrayList()
        when{
            page==1->list.addAll(List)
            page==2->list.addAll(List2)
            page==3->list.addAll(List3)
        }
        adapter = ArrayAdapter<Fund>(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = adapter
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (list.find {it.name==query}!=null) {
                    adapter.filter.filter(query)
                } else {
                    Toast.makeText(this@SearchActivity, "No Match found", Toast.LENGTH_LONG).show()
                }
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })

        //业务逻辑
        //得到项目
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.41.33:8080/") // 设置 网络请求 Url
            .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
            .build()
        val request = retrofit.create(AppService::class.java)
        val call= request.getFund(page)
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                println("请求成功")
                val result = response.body().string()
                Log.d(LoginAcitiviy.TAG, "onResponse: result = $result, isSuccess = ${response.isSuccessful}" + ", error body = ${response.errorBody()?.string()}")
                val entity: FundEntity = kotlin.runCatching {
                    Gson().fromJson(result, FundEntity::class.java)
                }.getOrNull() ?: return
                val newlist=entity.list
                list.addAll(newlist)
                adapter.notifyDataSetChanged()



            }

            override fun onFailure(call: Call<ResponseBody>, throwable: Throwable) {
//                Toast.makeText(this@HomeFragment,"请求失败, 请稍后再试!", Toast.LENGTH_SHORT).show()
                Log.d(LoginAcitiviy.TAG, "onFailure: message = ${throwable.message}")
            }
        })





    }
}




