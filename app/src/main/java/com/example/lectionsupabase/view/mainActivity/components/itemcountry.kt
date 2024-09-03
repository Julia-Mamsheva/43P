package com.example.lectionsupabase.view.mainActivity.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lectionsupabase.model.Country

@Composable
fun itemcountry(country:Country) {
    Text(
        country.name,
        modifier = Modifier.padding(8.dp),
    )
}