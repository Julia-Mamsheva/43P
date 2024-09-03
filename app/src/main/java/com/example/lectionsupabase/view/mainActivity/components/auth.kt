package com.example.lectionsupabase.view.mainActivity.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lectionsupabase.R
import com.example.lectionsupabase.view.mainActivity.MainViewModel

@Preview
@Composable
fun auth() {
    val viewModel = MainViewModel()
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Column(
        Modifier.padding(top = 30.dp, start = 15.dp, end = 15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TextField(
            value = email.value,
            textStyle = TextStyle(fontSize = 25.sp),
            onValueChange = { newText -> email.value = newText }
        )
        var passwordVisibility: Boolean by remember { mutableStateOf(false) }
        TextField(value = password.value,
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            leadingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    if(passwordVisibility) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = ""
                        )
                    }
                    else {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_person_off_24),
                            contentDescription = ""
                        )
                    }
                }
            },
            onValueChange = { newText -> password.value = newText })
        Button(onClick = {
            viewModel.onSignInEmailPassword(email.value,password.value)
        }){
            Text("SigIn", fontSize = 25.sp)
        }
        Button(onClick = {
            viewModel.onSignUpEmail(email.value,password.value)
        }){
            Text("SigUp", fontSize = 25.sp)
        }
    }
}