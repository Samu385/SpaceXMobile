package com.example.spacexmobile

import News
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter_cv_news : RecyclerView.Adapter<adapter_cv_news.ViewHolder>() {

    var news:MutableList<News> = mutableListOf(
        News(R.drawable.spacex_1, "titulo de primera noticia","Texto texto texto de la primera noticia ", "descripcion de la primera noticia"),
        News(R.drawable.spacex_1, "titulo de segunda noticia","Texto texto texto de la segunda noticia ", "descripcion de la segunda noticia"),
        News(R.drawable.spacex_1, "titulo de tercera noticia","Texto texto texto de la tercera noticia ", "descripcion de la tercera noticia"),
        News(R.drawable.spacex_1, "titulo de cuarta noticia","Texto texto texto de la cuarta noticia ", "descripcion de la cuarta noticia"),
        News(R.drawable.spacex_1, "titulo de quinta noticia","Texto texto texto de la quinta noticia ", "descripcion de la quinta noticia")

    )
    @SuppressLint("CutPasteId")
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDescripcion: TextView

        init{
            itemImage = itemView.findViewById(R.id.cv_imageNews)
            itemTitle = itemView.findViewById(R.id.cv_descriptionNews)
            itemDescripcion = itemView.findViewById(R.id.cv_descriptionNews)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cv_news, parent,false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return news.size //Change it when we have the news done
    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        holder.itemTitle.text = news[i].title
        holder.itemDescripcion.text = news[i].description
        holder.itemImage.setImageResource(news[i].IDImageCV)
    }

}