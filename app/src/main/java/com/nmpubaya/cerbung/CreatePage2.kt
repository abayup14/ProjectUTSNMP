package com.nmpubaya.cerbung

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nmpubaya.cerbung.databinding.ActivityCreatePage2Binding
import com.nmpubaya.cerbung.databinding.ActivityCreatePageBinding

class CreatePage2 : AppCompatActivity() {
    private lateinit var binding: ActivityCreatePage2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreatePage2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //DATA FROM CREATE PAGE
        val url = intent.getStringExtra(CerbungAdapters.URL)
        val title = intent.getStringExtra(CerbungAdapters.CARD_TITLE)
        val author = intent.getStringExtra(CerbungAdapters.CARD_AUTHOR)
        val genre = intent.getStringExtra(CerbungAdapters.CARD_GENRE)
        val short_description = intent.getStringExtra(CerbungAdapters.CARD_SHORT_DESCRIPTION)

        binding.txtWriteFirstParagraph.setText(intent.getStringExtra(CerbungAdapters.CARD_STORY))

        //RADIO BUTTON
        var permission: Boolean = false
        binding.groupPermission.setOnCheckedChangeListener { radioGroup, id ->
            //shortcut for (if restrcited = true, else false)
            permission = id == R.id.radioBtnRestricted
        }

        binding.btnPrev.setOnClickListener {
            intent = Intent(this, CreatePage::class.java)
            intent.putExtra(CerbungAdapters.CARD_TITLE, title)
            intent.putExtra(CerbungAdapters.CARD_SHORT_DESCRIPTION, short_description)
            intent.putExtra(CerbungAdapters.URL, url)
            startActivity(intent)
        }

        binding.btnNext2.setOnClickListener {
            intent = Intent(this, CreatePage3::class.java)
            //DATA COLLECTED FROM THIS PAGE
            intent.putExtra(CerbungAdapters.CARD_PERMISSION, permission)
            intent.putExtra(CerbungAdapters.CARD_STORY, binding.txtWriteFirstParagraph.text.toString())

            //DATA FROM THE PREVIOUS PAGE BEING TRANSFERED TO THE NEXT PAGE
            intent.putExtra(CerbungAdapters.URL, url)
            intent.putExtra(CerbungAdapters.CARD_TITLE, title)
            intent.putExtra(CerbungAdapters.CARD_AUTHOR, author)
            intent.putExtra(CerbungAdapters.CARD_GENRE, genre)
            intent.putExtra(CerbungAdapters.CARD_SHORT_DESCRIPTION, short_description)
            startActivity(intent)
        }
    }
}