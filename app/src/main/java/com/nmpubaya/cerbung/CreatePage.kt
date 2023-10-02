package com.nmpubaya.cerbung

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nmpubaya.cerbung.databinding.ActivityCreatePageBinding

class CreatePage : AppCompatActivity() {
    private lateinit var binding:ActivityCreatePageBinding
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
            startActivity(intent)
        }
    }
}