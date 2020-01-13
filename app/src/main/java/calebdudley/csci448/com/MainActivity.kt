package calebdudley.csci448.com

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import java.lang.Math.ceil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateButton: Button = findViewById(R.id.calculate_button)
        calculateButton.setOnClickListener {
            //read number of people from EditText
            val numPeopleEditText: EditText = findViewById(R.id.num_people_edit_text)
            val numPeople: Int = numPeopleEditText.text.toString().toInt()

            //read hunger intensity from radio buttons
            val hungryRG: RadioGroup = findViewById(R.id.how_hungry_radio_group)
            val slicesPerPerson = when( hungryRG.checkedRadioButtonId ){
                R.id.light_radio_button -> 1
                R.id.medium_radio_button -> 2
                R.id.heavy_radio_button -> 3
                else -> 0
            }

            //calculate the number of pizzas required
            val slicesPerPizza = 8.0
            val totalNumberPizzas = ceil(numPeople * slicesPerPerson / slicesPerPizza).toInt()

            //send the value to the TextView
            val numPizzasTextView: TextView = findViewById(R.id.num_pizzas_text_view)
            numPizzasTextView.text = totalNumberPizzas.toString()
        }
    }
}
