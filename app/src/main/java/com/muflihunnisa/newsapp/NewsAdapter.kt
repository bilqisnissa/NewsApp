package com.muflihunnisa.newsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.muflihunnisa.newsapp.activity.DetailActivity
import com.muflihunnisa.newsapp.model.ArticlesItem
import com.muflihunnisa.newsapp.model.ResponseNews
import kotlinx.android.synthetic.main.news_item.view.*

class NewsAdapter (var context: Context, var listNews : List<ArticlesItem?>?)
    : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var onItemClickCallBack : OnItemClickCallBack? = null

    fun setItemOnClickCallBack(onItemClickCallBack: OnItemClickCallBack){
        this.onItemClickCallBack = onItemClickCallBack
    }

    interface OnItemClickCallBack {
        fun onItemClicked(newsData : ArticlesItem)
    }

    inner class ViewHolder (view : View) :RecyclerView.ViewHolder(view) {
        fun bind (news : ArticlesItem){
            with(itemView){
                tv_title_items.text = news.title
                tv_date_item.text = news.publishedAt
                Glide.with(context).load(news.urlToImage).centerCrop().into(iv_item_news)
                itemView.setOnClickListener {
                    onItemClickCallBack?.onItemClicked(news)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listNews!!.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listNews?.get(position)!!)
    }
}