package com.nmpubaya.cerbung

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nmpubaya.cerbung.databinding.ActivityCreatePage2Binding
import com.nmpubaya.cerbung.databinding.ActivityCreatePageBinding

class CreatePage2 : AppCompatActivity() {
    private lateinit var binding: ActivityCreatePage2Binding

    companion object {
        val PARAGRAPH_KEY = "paragraph"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreatePage2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra(CreatePage.TITLE_KEY)
        val desc = intent.getStringExtra(CreatePage.DESC_KEY)
        val img_cover = intent.getStringExtra(CreatePage.IMG_CVR_KEY)

        binding.btnPrev.setOnClickListener {
            intent = Intent(this, CreatePage::class.java)
            intent.putExtra(CreatePage.TITLE_KEY, title)
            intent.putExtra(CreatePage.DESC_KEY, desc)
            intent.putExtra(CreatePage.IMG_CVR_KEY, img_cover)
            startActivity(intent)
        }

        binding.btnNext2.setOnClickListener {
            intent = Intent(this, CreatePage3::class.java)
            intent.putExtra(PARAGRAPH_KEY, binding.txtWriteFirstParagraph.text.toString())
            intent.putExtra(CreatePage.TITLE_KEY, title)
            intent.putExtra(CreatePage.DESC_KEY, desc)
            intent.putExtra(CreatePage.IMG_CVR_KEY, img_cover)
            startActivity(intent)
        }
    }
}