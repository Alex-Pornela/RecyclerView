package com.activity.recyclerview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val fruitsList = listOf<Fruit>(
        Fruit("Mango","Mary"),
        Fruit("Banana","Noel"),
        Fruit("Grapes","Anna"),
        Fruit("Apple","Joe"),
        Fruit("Orange","Karl"),
        Fruit("Avocado","Jane")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycleView = findViewById<RecyclerView>(R.id.recyclerView)

        //add bg color to recycleView
        recycleView.setBackgroundColor(Color.YELLOW)

        //set the layout manager for recycleView
        recycleView.layoutManager = LinearLayoutManager(this)

        //set adapter instance(class) in recycleView
        //pass the listItemClick function using lambda expression to the adapter
        recycleView.adapter = RecyclerViewAdapter(
            fruitsList,
        ) { selectedItem: Fruit ->
            listItemClick(selectedItem)
        }
    }

    //function takes selected list item as parameter
    private fun listItemClick(fruit: Fruit){
        Toast.makeText(
            this@MainActivity,"Supplier is: ${fruit.supplier}",
            Toast.LENGTH_SHORT)
            .show()
    }
}