package com.batch.loginsample

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.signup.*

class SignupActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)

        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val pwdEditText = findViewById<EditText>(R.id.pwdEditText)
        val rePwdEditText = findViewById<EditText>(R.id.rePwdEditText)
        val signupButton = findViewById<Button>(R.id.signupButton)
        val backButton = findViewById<Button>(R.id.backButton)

        auth = FirebaseAuth.getInstance()

        signupButton.setOnClickListener {
            val emailText = emailEditText.text.toString()
            val pwdText = pwdEditText.text.toString()
            val rePwdText = rePwdEditText.text.toString()

            auth.createUserWithEmailAndPassword(emailText, pwdText)
                .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(baseContext, "SIGNUP SUCCESS", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(baseContext, "SIGNUP FAILED", Toast.LENGTH_SHORT).show()
                }
            }
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}