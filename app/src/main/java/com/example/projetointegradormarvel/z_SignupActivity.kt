package com.example.projetointegradormarvel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.z_activity_signup.*

class z_SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.z_activity_signup)


        btn_confCadastro.setOnClickListener {
            callHome()
        }

        btn_cancelaCad.setOnClickListener {
            callLogin()
        }
    }



    fun callHome(){
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun callLogin(){
        var intent = Intent(this, z_LoginActivity::class.java)
        startActivity(intent)
    }
}