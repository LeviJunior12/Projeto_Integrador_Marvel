package com.example.projetointegradormarvel

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.projetointegradormarvel.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignupActivity : BaseActivity(), View.OnClickListener {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignupBinding

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setProgressBar(binding.progressBar)

        binding.btnCreateAct.setOnClickListener(this)
        binding.btnCancel.setOnClickListener(this)

        // Initialize Firebase Auth
        auth = Firebase.auth
    }

    private fun createAccount(email: String, password: String) {
        Log.d(LoginActivity.TAG, "createAccount:$email")
        if (!validateForm()) {
            return
        }

        showProgressBar()

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(LoginActivity.TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    callHome(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(LoginActivity.TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Failed to create",
                        Toast.LENGTH_SHORT
                    ).show()
//                    updateUI(null)
                }
                hideProgressBar()
            }
    }

    private fun validateForm(): Boolean {
        var valid = true
        val email = binding.edEmail.text.toString()

        if (TextUtils.isEmpty(email)) {
            binding.edEmail.error = "Required"
            valid = false
        } else {
            binding.edEmail.error = null
        }

        val password = binding.edPassword.text.toString()
        if (TextUtils.isEmpty(password)) {
            binding.edPassword.error = "Required"
            valid = false
        } else {
            binding.edPassword.error = null
        }
        return valid
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnCreateAct -> createAccount(
                binding.edEmail.text.toString(),
                binding.edPassword.text.toString()
            )
            R.id.btnCancel -> callLogin()
        }
    }

    private fun callHome(user: FirebaseUser?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun callLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    companion object {
        const val TAG = "SignupActivity"
    }
}