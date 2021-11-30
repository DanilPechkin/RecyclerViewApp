package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.data.DataStorage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recipes = DataStorage.getVersionsList()
        val versions = DataStorage.getVersionsList()

        // создание адаптера
        val adapter = RecipeAdapter(this, versions) {position ->
            val recipe = recipes[position]
            val intent = DetailsActivity.createIntent(this, recipe)
            startActivity(intent)
        }

        val list: RecyclerView = findViewById(R.id.recipe_list)
        list.adapter = adapter

        // декоратор списка
        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        decoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider)!!)
        list.addItemDecoration(decoration)
    }
}