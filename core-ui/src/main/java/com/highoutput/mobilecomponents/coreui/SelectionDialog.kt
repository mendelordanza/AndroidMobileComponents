package com.highoutput.mobilecomponents.coreui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SelectionDialog(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    positiveText: String,
    positiveButtonClick: () -> Unit,
    negativeText: String,
    negativeButtonClick: () -> Unit,
    dismissDialog: () -> Unit,
) {
    AlertDialog(
        modifier = modifier.clip(RoundedCornerShape(16.dp)),
        onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            // button. If you want to disable that functionality, simply use an empty
            // onCloseRequest.
            dismissDialog()
        },
        title = {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = title,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h5.copy(
                    fontWeight = FontWeight.Bold
                ),
            )
        },
        text = {
            Text(
                text = description,
                style = TextStyle(
                    fontSize = 17.sp,
                ),
                textAlign = TextAlign.Center,
            )
        },
        confirmButton = {
            TextButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = positiveButtonClick,
            ) {
                Text(
                    text = positiveText,
                )
            }
        },
        dismissButton = {
            TextButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = negativeButtonClick,
            ) {
                Text(
                    text = negativeText,
                )
            }
        }
    )
}

