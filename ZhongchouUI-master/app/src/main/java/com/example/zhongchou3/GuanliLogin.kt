package com.example.zhongchou3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_guanli_login.*

class GuanliLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guanli_login)
        guanli_login_btn.setOnClickListener {
            val guanliID=guanli_account.text.toString()
            if (guanliID=="66666"){
            val intent = Intent(this, GuanliActivity::class.java)
            startActivity(intent)
            }else{
                Toast.makeText(this,"登录失败！",Toast.LENGTH_SHORT ).show()
            }
        }
        guanli_yonghu.setOnClickListener {
            val intent = Intent(this, LoginAcitiviy::class.java)
            startActivity(intent)

        }
    }
}