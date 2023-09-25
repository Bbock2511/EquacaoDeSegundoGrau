package com.example.baskara

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.baskara.databinding.ActivityMainBinding
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalcular.setOnClickListener {
            val aText = binding.termA.text.toString()
            val bText = binding.termB.text.toString()
            val cText = binding.termC.text.toString()


            try {
                val a = aText.toInt()
                val b = bText.toInt()
                val c = cText.toInt()

                var delta = (b * b) - 4 * a * c
                if (delta < 0){
                    binding.resultXI.text = "Delta negativo, impossível calcular"
                } else {
                    delta = sqrt(delta.toDouble()).toInt()
                    val resultXI = (-b + delta.toFloat()) / (2 * a)
                    val resultXII = (-b - delta.toFloat()) / (2 * a)

                    binding.resultXI.text = "XI = $resultXI"
                    binding.resultXII.text = "XII = $resultXII"
                }

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Digite os números novamente", Toast.LENGTH_SHORT).show()
            }


        }
    }
}