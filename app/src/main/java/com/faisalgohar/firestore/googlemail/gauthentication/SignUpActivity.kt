package com.faisalgohar.firestore.googlemail.gauthentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.faisalgohar.firestore.googlemail.gauthentication.databinding.ActivityMainBinding
import com.faisalgohar.firestore.googlemail.gauthentication.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var fbAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fbAuth= FirebaseAuth.getInstance()

        binding.signUpBtn.setOnClickListener {
            signUp("faisalgohar02@gmail.com","123456789")
        }

    }

    private fun signUp(email:String,password:String)
    {

        fbAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this) {

            if(it.isSuccessful)
            {
                Toast.makeText(this, "Sign Up successful", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,DashBoardActivity::class.java))
            }
            else{
                Toast.makeText(this, "Error check your email", Toast.LENGTH_SHORT).show()
            }

        }

    }

}