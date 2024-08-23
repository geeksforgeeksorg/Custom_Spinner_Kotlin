package com.gfg.custom_spinner_kotlin

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val spinner: Spinner = findViewById(R.id.spinner)

        // Prepare data for the spinner
        val items = listOf(
            Item(R.drawable.pizza, "Pizza"),
            Item(R.drawable.burger, "Burger"),
            Item(R.drawable.salad, "Salad"),
            Item(R.drawable.ice_cream, "Ice cream"),
            Item(R.drawable.cold_drink, "Cold Drink"),
            Item(R.drawable.pasta, "Pasta")
        )

        // Create and set the custom adapter for the spinner
        val adapter = ItemAdapter(this, items)
        spinner.adapter = adapter

        // Handle item selection
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = items[position]
                // Show a toast message with the selected item's name
                Toast.makeText(this@MainActivity, "Selected: ${selectedItem.itemName}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case when nothing is selected if needed
            }
        }
    }
}