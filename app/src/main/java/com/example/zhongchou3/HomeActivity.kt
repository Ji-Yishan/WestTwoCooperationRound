package com.example.zhongchou3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private val mTab01: Fragment = HomeFragment()
    private val mTab02: Fragment = InputFragment()
    private val mTab03: Fragment = MyinfoFragment()

    private var mTabInfo: LinearLayout? = null
    private var mTabContact: LinearLayout? = null
    private var mTabMy: LinearLayout? = null

    private var mImgInfo: ImageButton? = null
    private var mImgContact: ImageButton? = null
    private var mImgMy: ImageButton? = null
    private var fm: FragmentManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        setContentView(R.layout.activity_home)

        initFragment()
        initView()
        initEvent()
        selectFragment(0)

    }

    //添加界面
    private fun initFragment() {
        var fm = supportFragmentManager
        val transaction: FragmentTransaction = fm.beginTransaction()
        transaction.add(R.id.content, mTab01)
        transaction.add(R.id.content, mTab02)
        transaction.add(R.id.content, mTab03)
        transaction.commit()
    }

    private fun resetImgs() {
        mImgInfo!!.setImageResource(R.drawable.ic_baseline_home_24)
        mImgContact!!.setImageResource(R.drawable.ic_baseline_local_hospital_24)
        mImgMy!!.setImageResource(R.drawable.ic_baseline_assignment_ind_24)
    }

    private fun initView() {
        mTabInfo = findViewById<View>(R.id.id_info_tab) as LinearLayout
        mTabContact = findViewById<View>(R.id.id_contact_tab) as LinearLayout
        mTabMy = findViewById<View>(R.id.id_my_tab) as LinearLayout

        mImgInfo = findViewById<View>(R.id.id_info_img) as ImageButton
        mImgContact = findViewById<View>(R.id.id_contact_img) as ImageButton
        mImgMy = findViewById<View>(R.id.id_my_img) as ImageButton
    }

    private fun selectFragment(i: Int) {
        var fm = supportFragmentManager
        val transaction: FragmentTransaction = fm.beginTransaction()
        hideFragment(transaction)
        when (i) {
            0 -> {
                Log.d("setSelect", "1")
                transaction.show(mTab01)
                mImgInfo!!.setImageResource(R.drawable.ic_baseline_home_24_select)
            }
            1 -> {
                transaction.show(mTab02)
                mImgContact!!.setImageResource(R.drawable.ic_baseline_local_hospital_24_select)
            }
            2 -> {
                transaction.show(mTab03)
                mImgMy!!.setImageResource(R.drawable.ic_baseline_assignment_ind_24_select)
            }
            else -> {
            }
        }
        transaction.commit()
    }

    private fun initEvent() {
        mTabInfo!!.setOnClickListener(this)
        mTabContact!!.setOnClickListener(this)
        mTabMy!!.setOnClickListener(this)
    }

    private fun hideFragment(transaction: FragmentTransaction) {
        transaction.hide(mTab01)
        transaction.hide(mTab02)
        transaction.hide(mTab03)
    }

    override fun onClick(v: View) {
        Log.d("onClick", "1")
        resetImgs()
        when (v.id) {
            R.id.id_info_tab -> {
                Log.d("onClick", "2")
                selectFragment(0)
            }
            R.id.id_contact_tab -> selectFragment(1)
            R.id.id_my_tab -> selectFragment(2)
            else -> {
            }
        }
    }
}