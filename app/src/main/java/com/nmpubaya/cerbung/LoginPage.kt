package com.nmpubaya.cerbung

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.nmpubaya.cerbung.databinding.ActivityLoginPageBinding

class LoginPage : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding

    companion object {
        val KEY_USERNAME = "username"
        val KEY_URL = "url"
    }
    var url = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.txtUsernameLogin.text.toString()
            val password = binding.txtPasswordLogin.text.toString()
            var isUserValid = false

            for (user in Global.LIST_USER) {
                if (user.username == username && user.password == password) {
                    url = user.picture_url
                    isUserValid = true
                    break
                }
            }

            if (isUserValid) {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("You successfully Log In")
                builder.setPositiveButton("Continue", null)
                val intent = Intent(this, HomePage::class.java)
                startActivity(intent)
            } else {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("Login Failed")
                builder.setPositiveButton("Retry", null)
            }
        }

        binding.btnCreateAccount.setOnClickListener {
            val intent = Intent(this, RegisterPage::class.java)
            startActivity(intent)
        }
    }
}