package com.highoutput.mobilecomponents.coreui

import android.os.SystemClock
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SingleTapButton(
    modifier: Modifier = Modifier,
    clickDisablePeriod: Long = 500L,
    updateBgColor: Color = Color.Black,
    updateTxtColor: Color = Color.White,
    disabledBackgroundColor: Color = Color.LightGray,
    disabledContentColor: Color = Color.Gray,
    onClick: () -> Unit,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit,
) {
    var lastClickTime by remember {
        mutableStateOf(0L)
    }
    Button(
        modifier = modifier,
        onClick = {
            if (SystemClock.elapsedRealtime() - lastClickTime < clickDisablePeriod) {
            } else {
                lastClickTime = SystemClock.elapsedRealtime()
                onClick()
            }
        },
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            disabledBackgroundColor = disabledBackgroundColor,
            disabledContentColor = disabledContentColor,
            backgroundColor = updateBgColor,
            contentColor = updateTxtColor,
        ),
        content = content,
    )
}

