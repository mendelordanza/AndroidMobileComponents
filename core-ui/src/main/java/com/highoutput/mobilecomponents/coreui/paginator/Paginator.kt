package com.highoutput.mobilecomponents.coreui.paginator

interface Paginator<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}