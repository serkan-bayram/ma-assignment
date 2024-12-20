package com.example.ma_assignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val credentialsManager = CredentialsManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recipiesRecyclerView = findViewById<RecyclerView>(R.id.recipeList)


        val recipes = listOf(
            Recipe(1, "Adana kebap", "A delicious Turkish food with meat and spices.", R.drawable.food_image),
            Recipe(2, "Pizza", "A traditional Italian dish with cheese and tomato.", R.drawable.food_image),
            Recipe(3, "Nohut pilav", "A traditional Turkish dish with chickpeas and rice.", R.drawable.food_image),
            Recipe(4, "Doner", "A popular Turkish dish with meat, vegetables, and sauce.", R.drawable.food_image),
            Recipe(5, "Baklava", "A sweet Turkish dessert made of layers of filo dough.", R.drawable.food_image)
        )

        recipiesRecyclerView.adapter = RecipiesAdapter(recipes)
        recipiesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}

class RecipieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.title)
    private val description: TextView = itemView.findViewById(R.id.description)
    private val imageView: ImageView = itemView.findViewById(R.id.imageView)
    val actionButton: Button = itemView.findViewById(R.id.actionButton)

    fun bind(recipe: Recipe) {
        title.text = recipe.title
        description.text = recipe.description
        imageView.setImageResource(recipe.imageResId)
    }
}

class RecipiesAdapter(private val recipes: List<Recipe>) : RecyclerView.Adapter<RecipieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipie, parent, false)
        return RecipieViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipieViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Clicked on recipe: ${recipe.title}", Toast.LENGTH_SHORT).show()
        }

        holder.actionButton.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Action on recipe: ${recipe.title}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}