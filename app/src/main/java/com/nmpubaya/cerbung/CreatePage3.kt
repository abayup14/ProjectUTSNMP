package com.nmpubaya.cerbung

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nmpubaya.cerbung.databinding.ActivityCreatePage2Binding
import com.nmpubaya.cerbung.databinding.ActivityCreatePage3Binding

class CreatePage3 : AppCompatActivity() {
    private lateinit var binding: ActivityCreatePage3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreatePage3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra(CreatePage.TITLE_KEY)
        val desc = intent.getStringExtra(CreatePage.DESC_KEY)
        val img_cover = intent.getStringExtra(CreatePage.IMG_CVR_KEY)
        val paragraph = intent.getStringExtra(CreatePage2.PARAGRAPH_KEY)

        binding.btnPrev2.setOnClickListener {
            intent = Intent(this, CreatePage2::class.java)
            intent.putExtra(CreatePage2.PARAGRAPH_KEY, paragraph)
            intent.putExtra(CreatePage.TITLE_KEY, title)
            intent.putExtra(CreatePage.DESC_KEY, desc)
            intent.putExtra(CreatePage.IMG_CVR_KEY, img_cover)
            startActivity(intent)
        }

        binding.btnPublish.setOnClickListener{
            if (binding.checkBoxAgree.isChecked) {
                Toast.makeText(this, "Cerbung Successfully Created ", Toast.LENGTH_SHORT).show()
                intent = Intent(this, HomePage::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please agree to our Terms of Agreement", Toast.LENGTH_LONG).show()
            }

        }
    }
}