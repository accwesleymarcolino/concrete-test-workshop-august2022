package br.com.concrete.testworkshop

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.com.concrete.testworkshop.databinding.ActivityLoginBinding
import br.com.concrete.testworkshop.util.PasswordValidator

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val passwordValidator = PasswordValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        binding.buttonLogin.setOnClickListener {
            when {
                binding.email.text.isNullOrEmpty() -> showErrorMessage(
                    R.string.error_empty_email
                )

                binding.password.text.isNullOrEmpty() -> showErrorMessage(
                    R.string.error_empty_password
                )

                passwordValidator.isValid(binding.password.text.toString()) -> showErrorMessage(
                    R.string.error_invalid_password
                )

                else -> TODO()
            }
        }
    }

    private fun showErrorMessage(@StringRes messageRes: Int) {
        AlertDialog.Builder(this)
            .setMessage(messageRes)
            .show()
    }
}