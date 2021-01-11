package com.example.projetointegradormarvel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.z_activity_login.*

class z_LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.z_activity_login)

        btn_login.setOnClickListener {
            callHome()
        }

        btn_cadastro.setOnClickListener {
            callCadastro()
        }
    }

    fun callHome() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun callCadastro() {
        var intent = Intent(this, z_SignupActivity::class.java)
        startActivity(intent)
    }
}