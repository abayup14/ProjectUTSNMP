package com.nmpubaya.cerbung

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nmpubaya.cerbung.databinding.CerbungItemBinding
import com.squareup.picasso.Picasso

class CerbungAdapters(): RecyclerView.Adapter<CerbungAdapters.CerbungViewHodlder>() {
    class CerbungViewHodlder(val binding: CerbungItemBinding): RecyclerView.ViewHolder(binding.root)
    companion object {
        val URL = "url"
        val CARD_TITLE = "cardtitle"
        val CARD_AUTHOR = "cardauthor"
        val ICON_LIST = "iconlist"
        val ICON_LIKE = "iconlike"
        val CARD_STORY = "cardstory"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CerbungAdapters.CerbungViewHodlder {
        val binding = CerbungItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CerbungViewHodlder(binding)
    }
    override fun getItemCount(): Int {
        return Global.cerbung.size
    }

    override fun onBindViewHolder(holder: CerbungAdapters.CerbungViewHodlder, position: Int) {
        val url = Global.cerbung[position].url
        val cardTitle= Global.cerbung[position].title
        val cardAuthor= Global.cerbung[position].author
        val iconList= Global.cerbung[position].icon_list
        val iconLike= Global.cerbung[position].icon_like
        val cardStory= Global.cerbung[position].story

        with(holder.binding) {
            val builder = Picasso.Builder(holder.itemView.context)
            builder.listener { picasso, uri, exception -> exception.printStackTrace() }
            builder.build().load(url).into(imgCerbung)

            txtCardTitle.text = cardTitle
            txtCardAuthor.text = cardAuthor
            txtIconList.text = iconList.toString()
            txtIconLike.text = iconLike.toString()
            txtCardStory.text = cardStory

            btnRead.setOnClickListener {
                val intent = Intent(it.context, CerbungFullStoryPage::class.java)
                intent.putExtra(URL, url)
                intent.putExtra(CARD_TITLE, cardTitle)
                intent.putExtra(CARD_AUTHOR, cardAuthor)
                intent.putExtra(ICON_LIST, iconList)
                intent.putExtra(ICON_LIKE, iconLike)
                intent.putExtra(CARD_STORY, cardStory)
                it.context.startActivity(intent)

            }
        }
    }


}