package com.mr_praveen_jha_.newsapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*


class NewsAdapter(val context: Context, val articles: List<Articles>) : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.itemView.apply{
            newsTitle.text = article.title
            newsDescription.text = article.description
           Glide.with(context).load(article.urlToImage).into(newsImage)
            setOnClickListener {
                Toast.makeText(context,article.title,Toast.LENGTH_SHORT).show()
                val intent = Intent(context,DetailActivity::class.java)
                intent.putExtra("URL",article.url)
                context.startActivity(intent)


            }
        }

    }

    override fun getItemCount(): Int {
        return articles.size
    }

    inner class ArticleViewHolder(itemView: View):ViewHolder(itemView){
//        val newsImage = itemView.findViewById<ImageView>(R.id.newsImage)
//        val newsTitle = itemView.findViewById<TextView>(R.id.newsTitle)
//        val newsDescription = itemView.findViewById<TextView>(R.id.newsDescription)
    }
}