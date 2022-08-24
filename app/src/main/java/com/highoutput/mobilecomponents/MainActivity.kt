package com.highoutput.mobilecomponents

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.highoutput.mobilecomponents.authform.AuthForm
import com.highoutput.mobilecomponents.authform.OtpForm
import com.highoutput.mobilecomponents.coreui.CustomBottomSheet
import com.highoutput.mobilecomponents.coreui.DropdownField
import com.highoutput.mobilecomponents.coreui.SelectionDialog
import com.highoutput.mobilecomponents.coreui.TextDialog
import com.highoutput.mobilecomponents.coreui.paginator.DefaultPaginator
import com.highoutput.mobilecomponents.coreui.paginator.PaginatorLazyColumn
import com.highoutput.mobilecomponents.ui.theme.MobileComponentsTheme
import com.ralphordanza.compose_mentions.ComposeMentions

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        @OptIn(ExperimentalMaterialApi::class)
        setContent {
            MobileComponentsTheme(
                darkTheme = false
            ) {
                AuthForm(
                    modifier = Modifier.padding(24.dp),
                    emailPlaceholder = "Enter email",
                    passwordPlaceholder = "Enter password",
                    onLoginClick = { email, password ->
                        Log.d("SUBMIT", "$email $password")
                    },
                    onSignUpClick = {
                        Log.d("SIGN UP", "CLICK")
                    }
                )

                //OTP Form
//                OtpForm(
//                    email = "sample@email.com",
//                    onSubmit = {
//                        Log.d("SUBMIT", it)
//                    },
//                    resendCode = {
//                        //TODO resend
//                    },
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

                //Compose Mentions
//                val members = listOf(
//                    Member(id = 1, display = "John Doe", role = "Citizen"),
//                    Member(id = 2, display = "Spider Man", role = "Avenger"),
//                    Member(id = 3, display = "Peter Parker", role = "Alter Ego")
//                )
//                var value by remember {
//                    mutableStateOf(TextFieldValue(""))
//                }
//
//                ComposeMentions(
//                    placeholder = {
//                        Text("Enter your thoughts")
//                    },
//                    trigger = "@",
//                    data = members.map {
//                        mapOf(
//                            "id" to it.id,
//                            "display" to it.display,
//                            // you can add more fields here
//                        )
//                    },
//                    onMarkupChanged = {
//                        // Do something with markdown
//                    },
//                    message = value,
//                    onValueChanged = {
//                        value = it
//                    },
//                    suggestionItemBuilder = {
//                        // Customize composable item
//                        Column {
//                            Text("${it["id"]}")
//                            Text("${it["display"]}")
//                        }
//                    },
//                    markupBuilder = { trigger, id, display ->
//                        // format your own markdown
//                        // eg. "[$trigger$display](profile/$id)"
//                        "[$trigger$display](profile/$id)"
//                    },
//                )

                //BottomSheet
//                val scaffoldState =
//                    rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
//                CustomBottomSheet(
//                    scaffoldState = scaffoldState,
//                    radius = 16.dp,
//                    sheetContent = {
//                        Column {
//                            Text("Sample")
//                            Text("Sample")
//                        }
//                    },
//                    content = {
//                        Scaffold(
//                            topBar = {
//                                TopAppBar(
//                                    title = {
//                                        Text("Sample")
//                                    },
//                                )
//                            }
//                        ) {
//                            Box(
//                                modifier = Modifier
//                                    .padding(paddingValues = it)
//                                    .fillMaxSize(),
//                                contentAlignment = Alignment.Center,
//                            ) {
//                                Text("Bottom Sheet")
//                            }
//                        }
//                    },
//                )

                //Selection Dialog
//                var showSelectionDialog by remember {
//                    mutableStateOf(false)
//                }
//
//                if (showSelectionDialog) {
//                    SelectionDialog(
//                        title = "Discard Leave?",
//                        description = "Your changes are not yet saved. Do you wish to discard it?",
//                        dismissDialog = {
//                            showSelectionDialog = false
//                        },
//                        positiveText = "Okay",
//                        positiveButtonClick = {
//                            showSelectionDialog = false
//                        },
//                        negativeText = "Discard",
//                        negativeButtonClick = {
//                            showSelectionDialog = false
//                        }
//                    )
//                }

                //Text Dialog
//                var showTextDialog by remember {
//                    mutableStateOf(false)
//                }
//
//                if (showTextDialog) {
//                    TextDialog(
//                        title = "Discard Leave?",
//                        description = "Your changes are not yet saved. Do you wish to discard it?",
//                        dismissDialog = {
//                            showTextDialog = false
//                        },
//                        buttonText = "Okay",
//                    )
//                }
            }
        }
    }
}

data class Member(
    val id: Int,
    val display: String,
    val role: String,
)

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