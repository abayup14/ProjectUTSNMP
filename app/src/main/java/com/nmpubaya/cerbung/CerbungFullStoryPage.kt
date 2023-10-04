package com.nmpubaya.cerbung

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nmpubaya.cerbung.databinding.ActivityCerbungFullStoryPageBinding
import com.squareup.picasso.Picasso

class CerbungFullStoryPage : AppCompatActivity() {
    private lateinit var binding: ActivityCerbungFullStoryPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCerbungFullStoryPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //IMAGE FROM CERBUNG ADAPTERS
        val builder = Picasso.Builder(this)
        builder.listener { picasso, uri, exception -> exception.printStackTrace() }
        builder.build().load(intent.getStringExtra(CerbungAdapters.URL)).into(binding.imgFullStory)

        //
        binding.txtFullStoryTitle.text = intent.getStringExtra(CerbungAdapters.CARD_TITLE)
        binding.txtFullStoryAuthor.text = intent.getStringExtra(CerbungAdapters.CARD_AUTHOR)
        binding.txtFullStoryIconList.text = intent.getIntExtra(CerbungAdapters.ICON_LIST, 0).toString()
        binding.txtFullStoryIconLike.text = intent.getIntExtra(CerbungAdapters.ICON_LIKE, 0).toString()
        binding.txtFullStoryStory.text = intent.getStringExtra(CerbungAdapters.CARD_STORY)
    }
}