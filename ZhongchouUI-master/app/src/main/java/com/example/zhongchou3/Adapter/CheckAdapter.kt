package com.example.zhongchou3.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.zhongchou3.Fund
import com.example.zhongchou3.R

class CheckAdapter(val myFundList: List<Fund>) :
    RecyclerView.Adapter<CheckAdapter.ViewHolder>() {

    lateinit var onItemClick: (Int) -> Unit
    lateinit var onItemDelet:(Int)->Unit
    lateinit var onItemPass:(Int)->Unit


    fun setOnItemClickListener(onItemClick: (Int) -> Unit) {
        this.onItemClick= onItemClick
    }
    fun setOnDelet(onItemDelet: (Int) -> Unit){
        this.onItemDelet=onItemDelet
    }
    fun setOnPass(onItemPass:(Int)->Unit){
        this.onItemPass=onItemPass
    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fundImage: ImageView = view.findViewById(R.id.check_fund_Image)
        val fundName: TextView = view.findViewById(R.id.check_fund_name)
        val fundCard: TextView = view.findViewById(R.id.check_fund_card)
        val fundReason: TextView = view.findViewById(R.id.check_fund_reason)
        val fundNeed:TextView=view.findViewById(R.id.check_fund_need)
        val fundRaise:TextView=view.findViewById(R.id.check_fund_haveraise)
        val btn_pass:Button=view.findViewById(R.id.check_pass)
        val btn_delet:Button=view.findViewById(R.id.check_delet)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.check_item, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fund = myFundList[position]
        holder.adapterPosition
        holder.fundImage.setImageResource(fund.Imag)
        holder.fundName.text = fund.name
        holder.fundCard.text=fund.card
        holder.fundReason.text=fund.reason
        holder.fundNeed.text=fund.need
        holder.fundRaise.text=fund.raise
        holder.btn_delet.setOnClickListener {
            val position=holder.adapterPosition
            onItemDelet.invoke(position)
        }
        holder.btn_pass.setOnClickListener {
            val position=holder.adapterPosition
            onItemPass.invoke(position)
        }
        holder.itemView.setOnClickListener {
            val position=holder.adapterPosition
            onItemClick.invoke(position)

        }
    }
    override fun getItemCount() = myFundList.size
}


