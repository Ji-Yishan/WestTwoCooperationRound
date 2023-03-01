package com.example.zhongchou3

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zhongchou3.Adapter.FundAdapter
import com.example.zhongchou3.Adapter.MyAdapter
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_input.*
import kotlinx.android.synthetic.main.fragment_input.view.*
import kotlinx.android.synthetic.main.top_mybar.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InputFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InputFragment : Fragment() {
    private val checkfundList = ArrayList<Fund>()

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        input_btn.setOnClickListener {
            val intent = Intent(activity, InformationActivity::class.java)
            startActivity(intent)
        }
        //待审核的项目
        initCheckFund()
        val mylayoutManager = LinearLayoutManager(view.context)
        mylayoutManager.orientation = LinearLayoutManager.VERTICAL
        myrecycleview.layoutManager = mylayoutManager
        val myadapter = FundAdapter(checkfundList)
        myrecycleview.adapter = myadapter
        myadapter.setOnItemClickListener {
            val intent= Intent(activity,FundDetail::class.java)
            intent.putExtra("fund", checkfundList.get(it))//强转
            startActivity(intent)
        }


    }

    private fun initCheckFund() {
        checkfundList.add(Fund("李华1","1666654","50000","白血病",R.mipmap.img,"0","1"))
        checkfundList.add(Fund("李华2","2666654","50000","白血病",R.mipmap.img,"0","2"))

    }
}