package com.highoutput.mobilecomponents.coreui.paginator

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope

@Composable
fun PaginatorLazyColumn(
    modifier: Modifier = Modifier,
    scrollState: LazyListState = rememberLazyListState(),
    isLoading: Boolean,
    hasNextPage: Boolean,
    pageReload: CoroutineScope.() -> Unit,
    content: LazyListScope.() -> Unit,
) {
    val endOfListReached by remember {
        derivedStateOf {
            scrollState.isScrolledToTheEnd()
        }
    }

    Log.d("CHECK", "$endOfListReached $isLoading $hasNextPage")
    if (endOfListReached && !isLoading && hasNextPage) {
        LaunchedEffect(Unit) {
            pageReload()
        }
    }

    LazyColumn(modifier = modifier, state = scrollState) {
        content()
    }
}