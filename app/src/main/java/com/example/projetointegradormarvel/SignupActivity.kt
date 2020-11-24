package com.example.projetointegradormarvel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro2.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro2)


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
        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}