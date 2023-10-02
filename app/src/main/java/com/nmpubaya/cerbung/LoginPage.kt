package com.nmpubaya.cerbung

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nmpubaya.cerbung.databinding.ActivityLoginPageBinding

class LoginPage : AppCompatActivity() {
    private lateinit var binding:ActivityLoginPageBinding

    companion object {
        val LIST_USER = arrayListOf(
            User("Bayu0123", "halo", "1234")
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.txtUsernameLogin.text.toString()
            val password = binding.txtPasswordLogin.text.toString()

            for (user in LIST_USER) {
                if (username == user.username && password == user.password) {
                    Toast.makeText(this, "Welcome to Cerbung, $username", Toast.LENGTH_SHORT).show()
                    break
                } else {
                    Toast.makeText(this, "Login gagal. Silahkan coba lagi", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btnCreateAccount.setOnClickListener{
            val intent = Intent(this, RegisterPage::class.java)
            startActivity(intent)
        }
    }
}