package com.example.lectionsupabase.view.mainActivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lectionsupabase.domain.utils.Constants
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.gotrue.providers.builtin.OTP
import kotlinx.coroutines.launch

class MainViewModel():ViewModel() {

    fun onSignInEmailCode(emailUser: String) {
        viewModelScope.launch {
            try {
                Constants.supabase.auth.signInWith(OTP) {
                    email = emailUser
                    createUser = false
                }

            } catch (e: Exception) {
                println(e.message.toString())

            }

        }
    }

    fun onSignInEmailPassword(emailUser: String, passwordUser: String) {
        viewModelScope.launch {
            try {
                val user = Constants.supabase.auth.signInWith(Email) {
                    email = emailUser
                    password = passwordUser
                }
                println(user.toString())
                println(Constants.supabase.auth.currentUserOrNull()!!.id)
                println("Success")
            } catch (e: Exception) {
                println("Error")
                println(e.message.toString())
            }
        }
    }
    fun onSignUpEmail(emailUser: String, passwordUser: String) {
        viewModelScope.launch {
            try{
             var  user =  Constants.supabase.auth.signUpWith(Email) {
                    email = emailUser
                    password = passwordUser
                }
                println(user.toString())
                println(Constants.supabase.auth.currentUserOrNull()!!.id)
                println("Success")
            }
            catch (e: Exception) {
                println("Error")
                println(e.message.toString())
            }

        }
    }
}