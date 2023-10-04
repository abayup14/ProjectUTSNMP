package com.nmpubaya.cerbung

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nmpubaya.cerbung.databinding.ActivityCreatePageBinding

class CreatePage : AppCompatActivity() {
    private lateinit var binding:ActivityCreatePageBinding

    companion object {
        val TITLE_KEY = "title"
        val DESC_KEY = "desc"
        val IMG_CVR_KEY = "img_cover"
        val GENRE_KEY = "genre"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreatePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCancelCerbung.setOnClickListener{
            intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }

        binding.btnNext.setOnClickListener {
            intent = Intent(this, CreatePage2::class.java)
            intent.putExtra(TITLE_KEY, binding.txtCerbungTitle.text.toString())
            intent.putExtra(DESC_KEY, binding.txtShortDescription.text.toString())
            intent.putExtra(IMG_CVR_KEY, binding.txtImageCoverUrl.text.toString())
            startActivity(intent)
        }

    }
}