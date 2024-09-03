package com.example.lectionsupabase.model

import kotlinx.serialization.Serializable


@Serializable
data class Country(
    val id: Int,
    val name: String,
    val image:String?
)