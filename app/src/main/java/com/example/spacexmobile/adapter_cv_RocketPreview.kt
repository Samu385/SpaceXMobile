package com.example.spacexmobile

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter_cv_RocketPreview (private val rockets:Array<RocketInfo>) : RecyclerView.Adapter<adapter_cv_RocketPreview.ViewHolderRocketPreview>() {

    var onItemClick :((RocketInfo) -> Unit)? = null
    @SuppressLint("CutPasteId")
    class ViewHolderRocketPreview(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemTitle: TextView
        var itemType: TextView
        var itemCountry: TextView

        init{
            itemTitle = itemView.findViewById(R.id.cv_headerRocketInfo)
            itemType = itemView.findViewById(R.id.cv_typeRocketInfo)
            itemCountry = itemView.findViewById(R.id.cv_countryRocketInfo)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderRocketPreview {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cv_rocket_info, parent,false)
        return ViewHolderRocketPreview(v);
    }

    override fun getItemCount(): Int {

        return rockets.size //Change it when we have the news done
    }

    override fun onBindViewHolder(holder: ViewHolderRocketPreview, i: Int) {

        holder.itemTitle.text = rockets[i].name
        holder.itemType.text = rockets[i].first_flight
        holder.itemCountry.text = rockets[i].country

        holder.itemView.setOnClickListener(){
            onItemClick?.invoke(rockets[i])
        }
    }

}