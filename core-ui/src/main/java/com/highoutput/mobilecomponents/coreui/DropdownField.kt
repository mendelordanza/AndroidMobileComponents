package com.highoutput.mobilecomponents.coreui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DropdownField(
    modifier: Modifier = Modifier,
    dropdownModifier: Modifier = Modifier,
    text: String,
    onTextChanged: (String) -> Unit,
    placeholder: @Composable (() -> Unit)? = null,
    isExpanded: Boolean,
    onOpenClose: () -> Unit,
    listItem: LazyListScope.() -> Unit,
    selectedItemList: (LazyListScope.() -> Unit?)? = null,
    enabled: Boolean = true,
) {
    Column(
        modifier = modifier
    ) {
        CustomTextbox(
            value = text,
            onValueChange = onTextChanged,
            placeholder = placeholder,
            trailingIcon = {
                Icon(
                    modifier = Modifier.clickable {
                        if (enabled) {
                            onOpenClose()
                        }
                    },
                    imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = "action"
                )
            },
            enabled = enabled,
            backgroundColor = if (enabled) MaterialTheme.colors.background else Color(0xFFF2F4F5)
        )
        AnimatedVisibility(
            visible = isExpanded,
            enter = expandVertically(
                initialHeight = {
                    0
                },
                animationSpec = tween(durationMillis = 250)
            ),
            exit = shrinkVertically(
                // Overwrites the default animation with tween
                animationSpec = tween(durationMillis = 250)
            )
        ) {

            Column(
                modifier = dropdownModifier
            ) {

                if (selectedItemList != null) {
                    LazyRow(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth()
                            .background(color = Color.White),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        selectedItemList()
                    }
                }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {
                    listItem()
                }
            }
        }
    }
}

