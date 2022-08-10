package br.com.concrete.testworkshop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.concrete.testworkshop.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}