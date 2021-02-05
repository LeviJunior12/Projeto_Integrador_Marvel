package com.example.projetointegradormarvel

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.projetointegradormarvel.search.BuscaActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_ProjetoIntegradorMarvel)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            when (destination.id) {
//                R.id.loginFragment -> appBarLayout.visibility = View.GONE
//                R.id.signupFragment -> appBarLayout.visibility = View.GONE
//                else -> appBarLayout.visibility = View.VISIBLE
//            }
//        }

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.search_activity ->{
                    callSearch()
                    true
                }
                R.id.nav_logout -> {
                    signOut()
                    true
                }
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_top_items, menu)
//        menuInflater.inflate(R.menu.menu_buscar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
/*
        R.id.search -> {
            callSearch()
            true
        }
*/

/*        R.id.action_favorite -> {
            when {
                !item.isChecked -> {
                    item.isChecked = true
                    item.setIcon(R.drawable.ic_star_fill)
                }
                else -> {
                    item.isChecked = false
                    item.setIcon(R.drawable.ic_round_star_outline_24)
                }
            }
            true
        }*/

/*        R.id.search_menu -> {
            callSearch()
            true
        }*/

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    private fun callSearch() {
        startActivity(Intent(this, BuscaActivity::class.java))
    }

    private fun signOut() {
        Firebase.auth.signOut()
        GoogleSignIn.getClient(
            this,
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()
        )
            .signOut()
        startActivity(Intent(this, LoginActivity::class.java))
    }
}