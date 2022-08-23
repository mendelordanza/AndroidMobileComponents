package com.highoutput.mobilecomponents.authform

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
import com.highoutput.mobilecomponents.coreui.CustomTextbox
import com.highoutput.mobilecomponents.coreui.SingleTapButton

@Composable
fun AuthForm(
    modifier: Modifier = Modifier,
    emailPlaceholder: String = "Email",
    passwordPlaceholder: String = "Password",
    emailError: String = "",
    passError: String = "",
    isError: Boolean = false,
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
                isError = isError,
                errorMessage = emailError,
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
                isError = isError,
                errorMessage = passError,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            )
        }
        SingleTapButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onLoginClick(email, password)
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

