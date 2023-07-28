package com.diana.ec3simpsons.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.diana.ec3simpsons.R
import com.diana.ec3simpsons.databinding.ActivityInicioBinding

class InicioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInicioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnlogin.setOnClickListener {
            Toast.makeText(this, "Inicio de Sesión", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LogeoActivity::class.java)
            startActivity(intent)

        }
    }
}