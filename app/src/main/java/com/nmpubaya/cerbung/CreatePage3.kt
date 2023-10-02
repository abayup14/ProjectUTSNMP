package com.nmpubaya.cerbung

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nmpubaya.cerbung.databinding.ActivityCreatePage2Binding
import com.nmpubaya.cerbung.databinding.ActivityCreatePage3Binding

class CreatePage3 : AppCompatActivity() {
    private lateinit var binding: ActivityCreatePage3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreatePage3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPrev2.setOnClickListener {
            intent = Intent(this, CreatePage2::class.java)
            startActivity(intent)
        }
    }
}