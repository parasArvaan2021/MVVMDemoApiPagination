package com.app.mvvmdemowithapi.design.main.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.mvvmdemowithapi.R
import com.app.mvvmdemowithapi.respone.main.PaginationResponse
import com.bumptech.glide.Glide

class MainDataSetImageAdapter(private val context: Context) :
    RecyclerView.Adapter<MainDataSetImageAdapter.SetImageViewHolder>() {

    private var listOfImage = arrayListOf<PaginationResponse.Data.Data>()

    inner class SetImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivSetProfileImage: ImageView = itemView.findViewById(R.id.ivRecycler)
        val rvProgress:ProgressBar=itemView.findViewById(R.id.rvProgress)
        val tvListCount:TextView=itemView.findViewById(R.id.tvListCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SetImageViewHolder {
        return SetImageViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_item_data, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SetImageViewHolder, position: Int) {
        val currentPosition = listOfImage[position].profileImageUrl
        holder.tvListCount.text=position.toString()
        Glide.with(context)
            .load(currentPosition)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(holder.ivSetProfileImage)


    }

    override fun getItemCount(): Int {
        return listOfImage.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    fun setListOfImageData(list: ArrayList<PaginationResponse.Data.Data>) {
        this.listOfImage = list
        Log.e("TAG", "setListOfImageData: ${listOfImage.size}")
        notifyDataSetChanged()
    }

    fun addDataInLastPosition(list:ArrayList<PaginationResponse.Data.Data>){
        listOfImage.addAll(list)
        notifyItemInserted(listOfImage.size-1)
    }
}