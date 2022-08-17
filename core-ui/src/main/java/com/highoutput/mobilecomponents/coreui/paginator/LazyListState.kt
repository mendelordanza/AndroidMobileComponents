package com.highoutput.mobilecomponents.coreui.paginator

import androidx.compose.foundation.lazy.LazyListState

fun LazyListState.isScrolledToTheEnd(): Boolean {
    return layoutInfo.visibleItemsInfo.lastOrNull()?.index == (layoutInfo.totalItemsCount - 1)
}