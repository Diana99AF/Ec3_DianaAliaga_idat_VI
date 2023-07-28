package com.diana.ec3simpsons.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.diana.ec3simpsons.R
import com.diana.ec3simpsons.databinding.ActivityLogeoBinding

class LogeoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogeoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLogeoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.txtemail.editText?. addTextChangedListener {text ->
            binding.btnlogin.isEnabled = validacionCorreoPass(text.toString(), binding.txtpassword.editText?.text.toString())
        }

        binding.txtpassword.editText?. addTextChangedListener {text ->
            binding.btnlogin.isEnabled = validacionCorreoPass(binding.txtemail.editText?.text.toString(), text.toString())

        }



        /*binding.txtusu.editText?. addTextChangedListener {text ->
            binding.btnlogin.isEnabled = validacionSoloNumyLetra(text.toString())

        }*/


        //Boton login
        binding.btnlogin.setOnClickListener {
            Toast.makeText(this,"Entrando", Toast.LENGTH_SHORT).show()

            //val usuario = binding.txtusu.editText?.text.toString();

            //Para pasar a una siguiente actividad
            val intent = Intent(this, MainActivity::class.java)
            //intent.putExtra("usuario", usuario)

            startActivity(intent)
        }
    }


    private fun validacionCorreoPass(email:String,pass:String):Boolean{
        val validarCorreo = email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches() && email=="ejemplo@idat.edu.pe"
        val validarPass =  pass.matches("-?\\d+(\\.\\d+)?".toRegex()) && pass.length>=6 && pass == "123456" //Validacion solo numeros
        return validarCorreo && validarPass
    }
}