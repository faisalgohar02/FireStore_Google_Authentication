package com.faisalgohar.firestore.googlemail.gauthentication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.faisalgohar.firestore.googlemail.gauthentication.R
import com.faisalgohar.firestore.googlemail.gauthentication.models.MainListModel

class DashBoardListAdapter(val context: Context, val mainList:List<MainListModel>) :
    RecyclerView.Adapter<DashBoardListAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.main_list_items, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return mainList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = mainList[position]
        //holder.itemView.findViewById<AppCompatImageView>(R.id.img).setImageResource()
        holder.itemView.findViewById<AppCompatTextView>(R.id.nameTxt).text = currentItem.name

    }

}