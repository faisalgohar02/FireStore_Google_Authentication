package com.faisalgohar.firestore.googlemail.gauthentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.faisalgohar.firestore.googlemail.gauthentication.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fbAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fbAuth= FirebaseAuth.getInstance()

        if(fbAuth.currentUser!=null)
        {
            startActivity(Intent(this,DashBoardActivity::class.java))
        }

        binding.signUpBtn.setOnClickListener {

            startActivity(Intent(this,SignUpActivity::class.java))

        }

        binding.signInBtn.setOnClickListener {

            startActivity(Intent(this,LoginActivity::class.java))

        }
    }
}