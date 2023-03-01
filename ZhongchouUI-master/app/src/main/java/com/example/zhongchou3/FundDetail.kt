package com.example.zhongchou3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fund_detail.*
import kotlinx.android.synthetic.main.fund_item.*
import java.io.Serializable

class FundDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fund_detail)
        val fund =intent.getSerializableExtra("fund") as Fund//转换类型

        detail_Imag.setImageResource(fund.Imag)
        detail_card.text=fund.card
        detail_name.text=fund.name
        detail_reason.text=fund.reason
        detail_need.text=fund.need
        //detail_raise.text=fund.raise

    }
}


