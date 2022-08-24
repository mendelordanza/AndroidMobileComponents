package com.highoutput.mobilecomponents.authform

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.highoutput.mobilecomponents.coreui.CustomBottomSheet
import com.highoutput.mobilecomponents.coreui.SingleTapButton
import com.yogeshpaliyal.speld.PinInput
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OtpForm(
    modifier: Modifier = Modifier,
    email: String,
    borderColor: Color = MaterialTheme.colors.primary,
    pinLength: Int = 6,
    errorMessage: String = "",
    onSubmit: (code: String) -> Unit,
    resendCode: () -> Unit,
) {
    var code by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    CustomBottomSheet(
        scaffoldState = scaffoldState,
        radius = 8.dp,
        sheetContent = {
            ResendBottomSheet(
                email = email,
                onDismiss = {
                    scope.launch {
                        scaffoldState.animateTo(ModalBottomSheetValue.Hidden)
                    }
                },
            )
        },
        content = {
            Column(
                modifier = modifier.padding(24.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(
                        "Check your inbox",
                        style = MaterialTheme.typography.h5,
                    )

                    Text(
                        modifier = Modifier
                            .padding(top = 12.dp),
                        text = "We have sent a $pinLength-digit code to your email",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Left
                        )
                    )

                    PinInput(
                        modifier = Modifier
                            .background(color = Color.White)
                            .border(
                                BorderStroke(
                                    width = 2.dp,
                                    color = if (errorMessage.isNotEmpty()) Color.Red else borderColor,
                                ),
                                shape = RoundedCornerShape(3.dp)
                            ),
                        value = code,
                        length = pinLength,
                        obscureText = null,
                        onValueChanged = {
                            code = it
                        },
                    )

                    if (errorMessage.isNotEmpty()) {
                        Text(
                            modifier = Modifier
                                .padding(top = 8.dp),
                            text = errorMessage,
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = MaterialTheme.colors.error,
                                fontWeight = FontWeight.Normal
                            )
                        )
                    }

                    Row(
                        modifier = Modifier
                            .padding(top = 38.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "Didn't receive the email?",
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Normal,
                            )
                        )
                        Spacer(Modifier.width(10.dp))
                        Text(
                            modifier = Modifier
                                .clickable {
                                    resendCode()
                                    scope.launch {
                                        scaffoldState.animateTo(ModalBottomSheetValue.Expanded)
                                    }
                                },
                            text = "Resend the code",
                            color = MaterialTheme.colors.primary,
                        )
                    }
                }
                SingleTapButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .semantics {
                            contentDescription = "login_with_code"
                        },
                    onClick = {
                        if (code.isNotEmpty()) {
                            onSubmit(code)
                        }
                    },
                    enabled = code.length == 6
                ) {
                    Text("Continue")
                }
            }
        }
    )
}

@Composable
fun ResendBottomSheet(modifier: Modifier = Modifier, email: String, onDismiss: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Text(
            "Code sent!",
            textAlign = TextAlign.Center,
        )
        Text("We sent a new verification code to\n $email", textAlign = TextAlign.Center)
        SingleTapButton(
            modifier = Modifier
                .fillMaxWidth()
                .semantics {
                    contentDescription = "dismiss_code_bottomsheet"
                },
            onClick = onDismiss,
        ) {
            Text("Continue")
        }
    }
}
