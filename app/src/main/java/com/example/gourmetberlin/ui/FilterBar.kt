package com.example.gourmetberlin.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.AdapterView
import com.example.gourmetberlin.R

class FilterBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val spinnerCuisine: Spinner
    private val checkboxChildFriendly: CheckBox
    private val checkboxAnimalFriendly: CheckBox

    var onFilterChangeListener: ((String, Boolean, Boolean) -> Unit)? = null

    init {
        inflate(context, R.layout.filter_bar, this)

        spinnerCuisine = findViewById(R.id.spinner_cuisine)
        checkboxChildFriendly = findViewById(R.id.checkbox_child_friendly)
        checkboxAnimalFriendly = findViewById(R.id.checkbox_animal_friendly)

        setupSpinner()
        setupListeners()
    }

    private fun setupSpinner() {
        // Example cuisines list, you should replace this with your actual data
        val cuisines = listOf("All Restaurants", "Italian", "Chinese", "Mexican", "Indian")
        val adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, cuisines)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCuisine.adapter = adapter
    }

    private fun setupListeners() {
        spinnerCuisine.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View, position: Int, id: Long) {
                notifyFilterChange()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        checkboxChildFriendly.setOnCheckedChangeListener { _, _ ->
            notifyFilterChange()
        }

        checkboxAnimalFriendly.setOnCheckedChangeListener { _, _ ->
            notifyFilterChange()
        }
    }

    private fun notifyFilterChange() {
        val selectedCuisine = spinnerCuisine.selectedItem.toString()
        val isChildFriendly = checkboxChildFriendly.isChecked
        val isAnimalFriendly = checkboxAnimalFriendly.isChecked
        onFilterChangeListener?.invoke(selectedCuisine, isChildFriendly, isAnimalFriendly)
    }
}
