package com.example.gourmetberlin.ui.model

data class Restaurant (
    val name: String,
    val type: String,
    val isAnimalFriendly: Boolean,
    val isChildFriendly: Boolean,
    val menu: String,
    val link: String,
    val address: String,
    val coordinates: Coordinates
)