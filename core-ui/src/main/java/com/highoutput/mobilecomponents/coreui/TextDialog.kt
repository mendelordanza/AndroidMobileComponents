package com.highoutput.mobilecomponents.coreui

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TextDialog(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    buttonText: String,
    dismissDialog: () -> Unit,
) {

    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            // button. If you want to disable that functionality, simply use an empty
            // onCloseRequest.
            dismissDialog()
        },
        title = {
            Text(title)
        },
        text = {
            Text(description)
        },
        confirmButton = {
            Button(
                onClick = {
                    dismissDialog()
                },
            ) {
                Text(buttonText)
            }
        },
    )
}

