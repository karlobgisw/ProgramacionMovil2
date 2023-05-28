package com.example.unit1test2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {
        val box1 = findViewById<TextView>(R.id.box1)
        val box2 = findViewById<TextView>(R.id.box2)
        val box3 = findViewById<TextView>(R.id.box3)
        val box4 = findViewById<TextView>(R.id.box4)
        val box5 = findViewById<TextView>(R.id.box5)

        val clickableViews: List<View> = listOf(box1, box2, box3, box4, box5)

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it as TextView) }
        }

        val buttonRed = findViewById<Button>(R.id.buttonRed)
        val buttonYellow = findViewById<Button>(R.id.buttonYellow)
        val buttonGreen = findViewById<Button>(R.id.buttonGreen)

        buttonRed.setOnClickListener { changeColorOfBoxes(Color.RED, clickableViews) }
        buttonYellow.setOnClickListener { changeColorOfBoxes(Color.YELLOW, clickableViews) }
        buttonGreen.setOnClickListener { changeColorOfBoxes(Color.GREEN, clickableViews) }
    }

    /**
     * Sets the background color of a view depending on it's resource id.
     * This is a way of using one click handler to do similar operations on a group of views.
     *
     * Demonstrates three different ways of setting colors.
     *     * Using a color constant from the Color class.
     *     * Using an Android color resource
     *     * Using a custom color defined in color.xml
     */
    private fun makeColored(view: TextView) {
        val colors = arrayOf(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA)
        val randomColor = colors.random()

        view.setBackgroundColor(randomColor)
    }
    private fun changeColorOfBoxes(color: Int, clickableViews: List<View>) {
        for (item in clickableViews) {
            item.setBackgroundColor(color)
        }
    }
}