package com.nmpubaya.cerbung

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nmpubaya.cerbung.databinding.CerbungItemBinding
import com.squareup.picasso.Picasso

class CerbungAdapters(): RecyclerView.Adapter<CerbungAdapters.CerbungViewHodlder>() {
    class CerbungViewHodlder(val binding: CerbungItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CerbungAdapters.CerbungViewHodlder {
        val binding = CerbungItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CerbungViewHodlder(binding)
    }
    override fun getItemCount(): Int {
        return Global.cerbung.size
    }

    override fun onBindViewHolder(holder: CerbungAdapters.CerbungViewHodlder, position: Int) {
        val url = Global.cerbung[position].url

        with(holder.binding){
            val builder = Picasso.Builder(holder.itemView.context)
            builder.listener { picasso, uri, exception -> exception.printStackTrace() }
            builder.build().load(url).into(imgCerbung)

            txtCardTitle.text =Global.cerbung[position].title
            txtCardAuthor.text = Global.cerbung[position].author
            txtIconList.text = Global.cerbung[position].icon_list.toString()
            txtIconLike.text = Global.cerbung[position].icon_like.toString()
            txtCardStory.text = Global.cerbung[position].story

            }


    }


}