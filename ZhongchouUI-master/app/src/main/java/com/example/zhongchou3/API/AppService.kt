package com.example.zhongchou3.API

import com.example.zhongchou3.Fund
import com.example.zhongchou3.User
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query
import java.io.DataInput
import java.io.File

interface AppService {
    @POST("login")
    @FormUrlEncoded
    fun submitLogin(@Field("username") username: String?, @Field("password") password: String?): Call<ResponseBody>
    @POST("add")
    @FormUrlEncoded
    fun submitRegister(@Field("reg_username")reg_username:String?, @Field("reg_password")reg_password:String?): Call<ResponseBody>

    @GET("user/update/{newName}/{contact}/{id}/{userid}")
    fun submitMyinfor(@Path("newName")newName: String?,@Path("contact")connect:String,@Path("id")id: String?,@Path("userid")userid:String?): Call<ResponseBody>

    @POST("project/select/{curPage}")
    fun getFund(@Path("curPage") curPage:Int):Call<ResponseBody>
    @POST("project/query/{name}")
    fun searchFund(@Path("name")name: String?)

    @GET("user/profile")
    fun getInfor(@Query("id")id:String?,@Query("Connect")Connect:Int,@Query("Name")Name:String): Call<ResponseBody>
    @POST("project/add/{pname}/{reason}/{need}/{inId}")
    fun submitInput(@Path("pname")pname:String?,@Path("reason")reason:String?,@Path("need")need:String?,@Path("inId")inId:String?): Call<ResponseBody>
    @POST("project/updateFund")
    @FormUrlEncoded
    fun submitHelp(@Field("id")name:String?,@Field("money")money:String?): Call<ResponseBody>
    @POST("project/picture/{pname}")
    fun submitPicture(@Path("pname") pname:File): Call<ResponseBody>
    @DELETE("project/delete/{pid}")
    fun deletFund(@Path("pid")pid: String):Call<ResponseBody>
    @PUT("admin/audit/{pid}/{audit}")
    fun checkFund(@Path("pid")pid:String,@Path("audit")audit:Int):Call<ResponseBody>



}