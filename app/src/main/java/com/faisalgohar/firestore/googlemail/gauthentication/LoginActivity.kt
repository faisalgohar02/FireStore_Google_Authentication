package com.faisalgohar.firestore.googlemail.gauthentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.faisalgohar.firestore.googlemail.gauthentication.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding:ActivityLoginBinding
    private lateinit var fbAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fbAuth= FirebaseAuth.getInstance()

        binding.loginBtn.setOnClickListener {
            loginUser("faisalgohar02@gmail.com","123456789")
        }

    }


    private fun loginUser(email:String,password:String)
    {

        fbAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this) {

            if(it.isSuccessful)
            {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,DashBoardActivity::class.java))
            }
            else{
                Toast.makeText(this, "Error check your email", Toast.LENGTH_SHORT).show()
            }

        }

    }
}