package com.diana.ec3simpsons.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.diana.ec3simpsons.R
import com.diana.ec3simpsons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val usuario = intent.getStringExtra("usuario")

        val saludo = "Te damos la bienvenida"
        binding.txtinicio.text = saludo

        val fragmentView = supportFragmentManager.findFragmentById(R.id.fcv_navega) as NavHostFragment
        val navController = fragmentView.navController

        binding.bnvDiv.setupWithNavController(navController)
    }
}