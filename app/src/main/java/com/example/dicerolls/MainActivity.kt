/**
 * Это простое приложение игральных костей, в которой выпадает случайное число от 1 до 6
 * На начальном экране выпадает случайные числа. Далее необходимо нажать кнопку "Кидать"
 */
package com.example.dicerolls

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.btn)
        rollButton.setOnClickListener {
            rollDice()
            rollingDice()
        }

        rollDice() //Бросок Первых костей автоматичсеки
        rollingDice() //Бросок вторых костей автоматичсеки
    }

    //Первые кости
    private fun rollDice() {

        try {
            val dice = Dice(6)
            val diceRoll = dice.roll()
            val diceImage: ImageView = findViewById(R.id.imageView)
            val drawableResource = when (diceRoll) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            diceImage.setImageResource(drawableResource)
            diceImage.contentDescription = diceRoll.toString()

        } catch (e: Exception) {
            val toast: Toast = Toast.makeText(
                this,
                "Введено не правильное число",
                Toast.LENGTH_SHORT
            )
            toast.show()
        }
    }

    private fun rollingDice() {

        try {
            val dice = TwoDice(6)
            val diceRoll = dice.rolling()
            val diceImage: ImageView = findViewById(R.id.imageView2)
            val drawableResource = when (diceRoll) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            diceImage.setImageResource(drawableResource)
            diceImage.contentDescription = diceRoll.toString()

        } catch (e: Exception) {
            val toast: Toast = Toast.makeText(
                this,
                "Введено не правильное число",
                Toast.LENGTH_SHORT
            )
            toast.show()
        }
    }
}