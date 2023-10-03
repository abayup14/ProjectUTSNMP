package com.nmpubaya.cerbung

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.nmpubaya.cerbung.databinding.ActivityLoginPageBinding

class LoginPage : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding

    companion object {
        val LIST_USER = arrayListOf(
            User("Bayu0123", "https://picsum.photos/210/210", "1234"),
            User("vincent", "https://picsum.photos/210/210","123")
        )
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

            for (user in LIST_USER) {
                if (user.username == username && user.password == password) {
                    url = user.picture_url
                    isUserValid = true
                    break
                }
            }

            if (isUserValid) {
                Toast.makeText(this, "Welcome to Cerbung, $username", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomePage::class.java)
                intent.putExtra(KEY_USERNAME, username)
                intent.putExtra(KEY_URL, url)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login gagal. Silahkan coba lagi", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnCreateAccount.setOnClickListener {
            val intent = Intent(this, RegisterPage::class.java)
            startActivity(intent)
        }
    }
}