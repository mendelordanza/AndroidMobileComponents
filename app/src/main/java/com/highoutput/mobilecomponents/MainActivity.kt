package com.highoutput.mobilecomponents

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.highoutput.mobilecomponents.authform.AuthForm
import com.highoutput.mobilecomponents.coreui.DropdownField
import com.highoutput.mobilecomponents.coreui.paginator.DefaultPaginator
import com.highoutput.mobilecomponents.coreui.paginator.PaginatorLazyColumn
import com.highoutput.mobilecomponents.ui.theme.MobileComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MobileComponentsTheme {
//                AuthForm(
//                    modifier = Modifier.padding(24.dp),
//                    emailPlaceholder = "Enter email",
//                    passwordPlaceholder = "Enter password",
//                    onLoginClick = { email, password ->
//                        Log.d("SUBMIT", "$email $password")
//                    },
//                    onSignUpClick = {
//
//                    }
//                )

//                val list = remember {
//                    mutableStateListOf<String>()
//                }
//                var initialLoad by remember {
//                    mutableStateOf(true)
//                }
//                var hasNextPage by remember {
//                    mutableStateOf(true)
//                }
//
//                if(initialLoad) {
//                    LaunchedEffect(key1 = Unit) {
//                        repeat(50) {
//                            list.add("Sample $it")
//                        }
//                        initialLoad = false
//                    }
//                }
//
//                PaginatorLazyColumn(
//                    isLoading = false,
//                    hasNextPage = hasNextPage,
//                    pageReload = {
//                        //Load something
//                        list.add("Sample 6")
//                        list.add("Sample 7")
//                        list.add("Sample 8")
//                        list.add("Sample 9")
//                        list.add("Sample 10")
//                        hasNextPage = false
//                    },
//                ) {
//                    items(list.size) { index ->
//                        val item = list[index]
//                        Text(item)
//                    }
//                }

                //DropdownField
//                var text by remember {
//                    mutableStateOf("")
//                }
//                var isExpanded by remember {
//                    mutableStateOf(false)
//                }
//                DropdownField(
//                    text = text,
//                    onTextChanged = {
//                        text = it
//                    },
//                    isExpanded = isExpanded,
//                    onOpenClose = {
//                        isExpanded = !isExpanded
//                    },
//                    listItem = {
//                        repeat(10) {
//                            item {
//                                Text("Sample $it")
//                            }
//                        }
//                    },
//                )
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MobileComponentsTheme {
        Greeting("Android")
    }
}