package com.batch.loginsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        val loginButton = findViewById<Button>(R.id.loginButton)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val pwdEditText = findViewById<EditText>(R.id.pwdEditText)

        loginButton.setOnClickListener {
            val emailText = emailEditText.text.toString()
            val pwdText = pwdEditText.text.toString()

            auth.signInWithEmailAndPassword(emailText, pwdText).addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(
                        baseContext, "LOGIN SUCSESS",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        baseContext, "LOGIN FAILED",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        signupButton.setOnClickListener {
            val intent = Intent(application, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}
