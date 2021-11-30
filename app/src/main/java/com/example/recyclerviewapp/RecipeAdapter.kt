package com.example.recyclerviewapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.data.Recipe

class RecipeAdapter(Context: Context,
                    private val recipe: List<Recipe>,
                    private val clickListener: (position: Int) -> Unit
                ): RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(Context)

    override fun getItemCount(): Int = recipe.size

    private fun getItem(position: Int): Recipe = recipe[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_recipe, parent, false), clickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        itemView: View,
        listener: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView){
        private val image: ImageView = itemView.findViewById(R.id.recipe_image)
        private val title: TextView = itemView.findViewById(R.id.recipe_text)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener(position)
                }
            }
        }

        fun bind(version: Recipe){
            image.setImageResource(version.image)
            title.text = version.title
        }
    }
}