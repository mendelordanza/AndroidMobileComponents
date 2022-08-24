package com.highoutput.mobilecomponents.authform

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.highoutput.mobilecomponents.authform.extensions.isValidEmail
import com.highoutput.mobilecomponents.coreui.CustomTextbox
import com.highoutput.mobilecomponents.coreui.SingleTapButton

@Composable
fun AuthForm(
    modifier: Modifier = Modifier,
    emailPlaceholder: String = "Email",
    passwordPlaceholder: String = "Password",
    onLoginClick: (String, String) -> Unit,
    onSignUpClick: () -> Unit,
) {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    var error by remember {
        mutableStateOf(false)
    }
    var emailErrorMessage by remember {
        mutableStateOf("")
    }
    var passErrorMessage by remember {
        mutableStateOf("")
    }

    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            CustomTextbox(
                value = email,
                onValueChange = {
                    email = it
                },
                placeholder = {
                    Text(emailPlaceholder, color = Color.LightGray)
                },
                isError = error,
                errorMessage = emailErrorMessage,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            )
            Spacer(Modifier.height(10.dp))
            CustomTextbox(
                value = password,
                onValueChange = {
                    password = it
                },
                placeholder = {
                    Text(passwordPlaceholder, color = Color.LightGray)
                },
                isPasswordVisible = isPasswordVisible,
                isPasswordToggle = {
                    isPasswordVisible = !isPasswordVisible
                },
                isError = error,
                errorMessage = passErrorMessage,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            )
        }
        SingleTapButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                if (email.isEmpty()) {
                    error = true
                    emailErrorMessage = "Email is required"
                } else if (!email.isValidEmail()) {
                    error = true
                    emailErrorMessage = "Invalid email"
                } else {
                    error = false
                    emailErrorMessage = ""
                }

                if (password.isEmpty()) {
                    error = true
                    passErrorMessage = "Password is required"
                } else {
                    error = false
                    passErrorMessage = ""
                }

                if(!error){
                    onLoginClick(email, password)
                }
            },
        ) {
            Text("Login")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text("No account yet?")
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                modifier = Modifier.clickable {
                    onSignUpClick()
                },
                text = "Sign up",
            )
        }
    }
}

