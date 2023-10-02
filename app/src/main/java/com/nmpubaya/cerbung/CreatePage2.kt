package com.nmpubaya.cerbung

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

        binding.btnPrev.setOnClickListener {
            intent = Intent(this, CreatePage::class.java)
            startActivity(intent)
        }
        binding.btnNext2.setOnClickListener {
            intent = Intent(this, CreatePage3::class.java)
            startActivity(intent)
        }
    }
}