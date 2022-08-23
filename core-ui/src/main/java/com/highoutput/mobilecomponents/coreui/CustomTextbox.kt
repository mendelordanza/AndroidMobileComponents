package com.highoutput.mobilecomponents.coreui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextbox(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    isError: Boolean = false,
    errorMessage: String = "",
    errorColor: Color = Color.Red,
    maxLines: Int = 1,
    enabled: Boolean = true,
    verticalPadding: Dp = 16.dp,
    backgroundColor: Color = MaterialTheme.colors.background,
    defaultBorderColor: Color = Color.LightGray,
    shape: Shape = RoundedCornerShape(8.dp),
    isPasswordVisible: Boolean = false,
    isPasswordToggle: (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
) {

    val borderState = remember {
        mutableStateOf(true)
    }

    Column {
        BasicTextField(
            modifier = modifier
                .fillMaxWidth()
                .onFocusChanged {
                    borderState.value = !it.isFocused
                },
            enabled = enabled,
            keyboardOptions = keyboardOptions,
            maxLines = maxLines,
            textStyle = MaterialTheme.typography.body1,
            value = value,
            onValueChange = onValueChange,
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = if (borderState.value) defaultBorderColor
                            else if (isError) errorColor
                            else MaterialTheme.colors.secondary,
                            shape = shape,
                        )
                        .background(color = backgroundColor, shape = shape)
                ) {
                    Row(
                        modifier = Modifier.padding(vertical = verticalPadding),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        if (leadingIcon != null) {
                            Box(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                            ) {
                                leadingIcon()
                            }
                        }
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .weight(1f),
                        ) {
                            if (value.isEmpty()) {
                                if (placeholder != null) {
                                    placeholder()
                                }
                            }
                            innerTextField()
                        }
                        if (trailingIcon != null) {
                            Box(
                                modifier = Modifier
                                    .padding(end = 16.dp)
                            ) {
                                if (isPasswordToggle != null) {
                                    IconButton(onClick = isPasswordToggle) {
                                        if (isPasswordVisible) Icons.Filled.Visibility
                                        else Icons.Filled.VisibilityOff
                                    }
                                } else {
                                    trailingIcon()
                                }
                            }
                        }
                    }
                }
            },
            visualTransformation = if (isPasswordToggle != null) PasswordVisualTransformation() else visualTransformation,
        )
        if (isError && errorMessage.isNotEmpty()) {
            Text(errorMessage, color = errorColor)
        }
    }
}
