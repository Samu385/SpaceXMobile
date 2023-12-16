package com.example.spacexmobile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ImageAdapter(private val imageUrls: Array<String>) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.cv_imageRocket)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cv_image_rocket, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageUrl = imageUrls[position]
        // Utilizamos Picasso para cargar la imagen desde la URL en el ImageView
        Picasso.get().load(imageUrl).into(holder.imageView)
        // También puedes hacer otras cosas con la URL de la imagen según tus necesidades
    }

    override fun getItemCount(): Int {
        return imageUrls.size
    }
}
