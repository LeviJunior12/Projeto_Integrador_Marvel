package com.example.projetointegradormarvel

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.projetointegradormarvel.databinding.ActivityLoginBinding
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : BaseActivity(), View.OnClickListener {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var callbackManager: CallbackManager

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setProgressBar(binding.progressBar)

        binding.btnLogIn.setOnClickListener(this)
        binding.btnSignUp.setOnClickListener(this)
        binding.btnGoogle.setOnClickListener(this)
        binding.btnFacebook.setOnClickListener {
            LoginManager.getInstance()
                .logInWithReadPermissions(this, listOf("public_profile", "email"))
        }

        // Facebook callback registration
        callbackManager = CallbackManager.Factory.create()

        LoginManager.getInstance()
            .registerCallback(callbackManager, object : FacebookCallback<LoginResult?> {

                override fun onSuccess(loginResult: LoginResult?) {
                    Log.d(TAG, "Facebook onSuccess: $loginResult")
                    if (loginResult != null) {
                        handleFacebookAccessToken(loginResult.accessToken)
                    }
                }

                override fun onCancel() {
                    Log.d(TAG, "Facebook onCancel")
                    Toast.makeText(baseContext, "Login Cancelled", Toast.LENGTH_LONG).show()
                }

                override fun onError(error: FacebookException) {
                    Log.d(TAG, "Facebook onError", error)
                    Toast.makeText(baseContext, error.message, Toast.LENGTH_LONG).show()
                }
            })

        // Google sign in options
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        // Initialize Firebase Auth
        auth = Firebase.auth
    }

    public override fun onStart() {
        super.onStart()

        // Check if user is signed in
        val currentUser = auth.currentUser
        if (currentUser != null) {
            reload()
        }
    }

    private fun signIn(email: String, password: String) {
        Log.d(TAG, "signIn:$email")
        if (!validateForm()) {
            return
        }
        showProgressBar()

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    callHome(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
//                    checkForMultiFactorFailure(task.exception!!)
                }
//                if (!task.isSuccessful) {
//                    binding.status.setText(R.string.auth_failed)
//                }
                hideProgressBar()
            }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from Facebook
        callbackManager.onActivityResult(requestCode, resultCode, data)

        // Result returned from Google
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e)
            }
        }
    }

    // Auth with google
    private fun firebaseAuthWithGoogle(idToken: String) {

        showProgressBar()

        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                    val user = auth.currentUser
                    callHome(user)

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
//                    val view = binding.mainLayout
                    Toast.makeText(
                        baseContext, "Google Authentication Failed",
                        Toast.LENGTH_SHORT
                    ).show()
//                    updateUI(null)
                }
                hideProgressBar()
            }
    }

    private fun handleFacebookAccessToken(token: AccessToken) {
        Log.d(TAG, "handleFacebookAccessToken:$token")

        showProgressBar()

        val credential = FacebookAuthProvider.getCredential(token.token)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                    val user = auth.currentUser
                    callHome(user)

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                hideProgressBar()
            }
    }

    private fun signInGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun reload() {
        auth.currentUser!!.reload().addOnCompleteListener { task ->
            if (task.isSuccessful) {
//                updateUI(auth.currentUser)
                Log.e(TAG, "reload")
            } else {
                Log.e(TAG, "reload", task.exception)
            }
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
            R.id.btnSignUp -> callSignup()
            R.id.btnLogIn -> signIn(
                binding.edEmail.text.toString(),
                binding.edPassword.text.toString()
            )
            R.id.btnGoogle -> signInGoogle()
        }
    }

    private fun callHome(user: FirebaseUser?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun callSignup() {
        var intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }

    companion object {
        const val TAG = "LoginActivity"
        private const val RC_SIGN_IN = 9001
    }
}