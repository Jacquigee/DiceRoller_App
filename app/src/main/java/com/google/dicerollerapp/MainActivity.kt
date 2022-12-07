package com.google.dicerollerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
/* *
* This Activity allows the users to roll a dice and view the result
* on the screen
* */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }
    }
/*
* Roll the dice and update the screen with the result
* */
    private fun rollDice() {
    //Create new dice object with 6 sides and roll it
        val dice1 = Dice(6)
        val dice2 = Dice(6)


    //Find imageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)
    //Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (dice1.roll()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    //Update the drawableResource with the correct Image ID
        diceImage.setImageResource(drawableResource)
    //Update the content description
        diceImage.contentDescription = dice1.roll().toString()

    val drawableResource2 = when (dice1.roll()) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    diceImage2.setImageResource(drawableResource2)

    diceImage2.contentDescription = dice2.roll().toString()

    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}