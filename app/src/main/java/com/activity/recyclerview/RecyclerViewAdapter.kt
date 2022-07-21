package com.activity.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val fruitsList:List<Fruit>,
                          private val clickListener: (Fruit) -> Unit
) : RecyclerView.Adapter<MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //get layout inflater to inflate list item
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item,parent,false)

        return MyViewHolder(listItem)
    }

    //display the data on the list item
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val fruit = fruitsList[position]
        //pass the function parameter to the myViewHolder class
        holder.bind(fruit,clickListener)
    }

    //return total items in the dataset held by adapter
    override fun getItemCount(): Int {
        return fruitsList.size
    }


}

//add viewHolder
//add view as constructor parameter
class MyViewHolder(val view:View):RecyclerView.ViewHolder(view){

    fun bind(fruit: Fruit, clickListener: (Fruit) -> Unit){
        //get the view components in the list item layout
        val myTextView = view.findViewById<TextView>(R.id.tvName)
        myTextView.text = fruit.name

        //add click listener to recyclerView items
        view.setOnClickListener {
             //pass selected fruit item to the clickListener function
            clickListener(fruit)
        }
    }



}