package com.highoutput.mobilecomponents.coreui.paginator

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

class DefaultPaginator<Key, Item>(
    private val initialKey: Key,
    private inline val onLoadUpdated: (Boolean) -> Unit,
    private inline val onRequest: suspend (nextKey: Key) -> Flow<Resource<List<Item>>>,
    private inline val getNextKey: suspend (List<Item>) -> Key,
    private inline val onError: suspend (String) -> Unit,
    private inline val onSuccess: suspend (items: List<Item>, newKey: Key) -> Unit,
) : Paginator<Key, Item> {

    private var currentKey = initialKey
    private var isMakingRequest = false

    override suspend fun loadNextItems() {
        if (isMakingRequest) {
            return
        }
        isMakingRequest = true
        val result = onRequest(currentKey)
        isMakingRequest = false

        result.collect { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        currentKey = getNextKey(it)
                        onSuccess(it, currentKey)
                        onLoadUpdated(false)
                    }
                }
                is Resource.Loading -> {
                    onLoadUpdated(true)
                }
                is Resource.Error -> {
                    onError(response.message ?: "Something went wrong")
                    onLoadUpdated(false)
                }
            }
        }
    }

    override fun reset() {
        currentKey = initialKey
    }
}