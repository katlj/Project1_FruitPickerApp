package com.example.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import java.nio.file.WatchEvent.Kind

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val findFruit = findViewById<Button>(R.id.find_fruit)
        findFruit.setOnClickListener {
            val fruitKind= findViewById<Spinner>(R.id.fruit_kinds)
            val fruity = fruitKind.selectedItem
            val fruitList = getFruits(fruity.toString())
            val supplement = fruitList.reduce { str, item -> str + '\n' + item}
            val names = findViewById<TextView>(R.id.fruit_names)
            names.text = supplement

        }
    }
    fun getFruits(fruitKind: String): List<String> {
        return when (fruitKind) {
            "Apple" -> listOf("High in Calcium!", "Great source of Vitamin C")
            "Pear" -> listOf("Full of Electrolytes", "Full of nutrients!")
            "Grapes" -> listOf("Best for magnesium", "Great source of Vitamin A!")
            else -> listOf("Vitamin D supplement!", "Helps with vision!")
        }
    }
}