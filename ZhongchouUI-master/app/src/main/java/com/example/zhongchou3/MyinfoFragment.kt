package com.example.zhongchou3

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.zhongchou3.API.AppService
import com.example.zhongchou3.entity.ResponseEntity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_myinfo.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class MyinfoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val myname=it.data?.getStringExtra("name")
            val myid=it.data?.getStringExtra("idcard")
            val myconnect=it.data?.getStringExtra("contact")
            val userid=it.data?.getStringExtra("userid")
            my_name.setText(myname)
            my_id.setText(myid)
            my_connect.setText(myconnect)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_myinfo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myname=arguments?.getString("name")
        val myid=arguments?.getString("idcard")
        val myconnect=arguments?.getString("contact")
        val userid=arguments?.getString("userid")
        my_name.setText(myname)
        my_id.setText(myid)
        my_connect.setText(myconnect)
        Log.d(TAG,"myname is $myname myid is $myid myconnect is $myconnect")

        name_btn.setOnClickListener {
            val intent=Intent(activity,UpdateName::class.java)
            intent.putExtra("userid",userid.toString())
            launcher.launch(intent)
        }

    }

    private fun getInfor() {
        val myname=my_name.text.toString()
        val myage=my_id.text.toString()
        val myconnect=0

        requestInfor(myage,myconnect,myname)
    }

    private fun requestInfor(myage: String, myconnect: Int, myname: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.41.33:8080/") // 设置 网络请求 Url
            .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
            .build()
        val request = retrofit.create(AppService::class.java)
        val call= request.getInfor(myage,myconnect,myname)
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                println("请求成功")

                val result = response.body().string()
                Log.d(TAG, "onResponse: result = $result, isSuccess = ${response.isSuccessful}" + ", error body = ${response.errorBody()?.string()}")
                val entity: ResponseEntity = Gson().fromJson(result, ResponseEntity::class.java)
                //val entity: ResponseEntity = Gson().fromJson(result, ResponseEntity::class.java)

            }

            override fun onFailure(call: Call<ResponseBody>, throwable: Throwable) {
                println("请求失败")
                println(throwable.message)
            }

        })
    }


}