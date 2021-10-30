package com.example.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    lateinit var redButton: Button
    lateinit var yellowButton: Button
    lateinit var greenButton: Button
    lateinit var boxThreeText: TextView
    lateinit var boxFourText: TextView
    lateinit var boxFiveText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        redButton = findViewById(R.id.red_button)
        yellowButton = findViewById(R.id.yellow_button)
        greenButton = findViewById(R.id.green_button)
        boxThreeText = findViewById(R.id.box_three_text)
        boxFourText = findViewById(R.id.box_four_text)
        boxFiveText = findViewById(R.id.box_five_text)

        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> =
            listOf(
                findViewById<TextView>(R.id.box_one_text),
                findViewById<TextView>(R.id.box_two_text),
                findViewById<ConstraintLayout>(R.id.constraint_layout),
                boxThreeText,
                boxFourText,
                boxFiveText,
                redButton,
                yellowButton,
                greenButton,
            )

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {
            // Box using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            // Boxes using custom colors for background
            R.id.red_button -> boxThreeText.setBackgroundResource(R.color.purple_200)
            R.id.yellow_button -> boxFourText.setBackgroundResource(R.color.purple_500)
            R.id.green_button -> boxFiveText.setBackgroundResource(R.color.purple_700)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}