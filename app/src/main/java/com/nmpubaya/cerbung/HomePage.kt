package com.nmpubaya.cerbung

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import com.nmpubaya.cerbung.databinding.ActivityHomePageBinding

class HomePage : AppCompatActivity() {
    private lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

//      DATA USERNAME DARI LOGIN
        val username = intent.getStringExtra(LoginPage.KEY_USERNAME)
        binding.txtViewHello.text = "Hello, " + username.toString()

//      DATA URL DARI LOGIN
        val url = intent.getStringExtra(LoginPage.KEY_URL)
        val builder = Picasso.Builder(this)
        builder.listener { picasso, uri, exception ->
            exception.printStackTrace() }
        builder.build().load(url).into(binding.imgProfile)

        binding.btnCreate.setOnClickListener {
            intent = Intent(this, CreatePage::class.java)
            startActivity(intent)
        }
    }
}