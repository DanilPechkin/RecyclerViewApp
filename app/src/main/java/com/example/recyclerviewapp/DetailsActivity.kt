package com.example.recyclerviewapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.recyclerviewapp.data.Recipe
import java.lang.IllegalArgumentException

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val recipe = intent?.getParcelableExtra<Recipe>(ARGS_VERSION)
            ?: throw IllegalArgumentException("Missing argument")

        findViewById<ImageView>(R.id.poster).setImageResource(recipe.image)
        findViewById<TextView>(R.id.ingredients).text = recipe.ingredients
        findViewById<TextView>(R.id.guide).text = recipe.guide
    }

    companion object {
        private const val ARGS_VERSION = "ARGS_VERSION"

        fun createIntent(context: Context, recipe: Recipe): Intent {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(ARGS_VERSION, recipe)
            return intent
        }
    }
}