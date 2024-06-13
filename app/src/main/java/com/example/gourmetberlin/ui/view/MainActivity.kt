package com.example.gourmetberlin.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.add
import androidx.lifecycle.Observer
import com.example.gourmetberlin.R
import com.example.gourmetberlin.ui.FilterBar

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<MapsFragment>(R.id.fragment_container)
            }
        }

        val filterBar = findViewById<FilterBar>(R.id.filter_bar)
        filterBar.onFilterChangeListener = { type, isAnimalFriendly, isChildFriendly ->
            mainViewModel.fetchData(type, isAnimalFriendly, isChildFriendly)
        }

        mainViewModel.isLoading.observe(this, Observer { isLoading ->
            if (isLoading) {
                // Show loading state
            } else {
                // Hide loading state
            }
        })

        mainViewModel.data.observe(this, Observer { data ->
            if (data.isEmpty()) {
                // Show "No data available" message
            } else {
                // Update the map with the restaurant data
            }
        })
    }
}
