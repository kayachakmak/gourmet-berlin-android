package com.example.gourmetberlin.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.gourmetberlin.R
import com.example.gourmetberlin.ui.FilterBar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container, MapFragment())
            }
        }

        val filterBar = findViewById<FilterBar>(R.id.filter_bar)
        filterBar.onFilterChangeListener = { type, isAnimalFriendly, isChildFriendly ->
            // Handle filter changes here
        }
    }
}
