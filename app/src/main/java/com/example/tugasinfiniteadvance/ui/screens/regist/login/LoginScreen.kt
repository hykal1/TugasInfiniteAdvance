package com.example.tugasinfiniteadvance.ui.screens.regist.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tugasinfiniteadvance.R
import com.example.tugasinfiniteadvance.ui.theme.poppinsFontFamily
import com.example.tugasinfiniteadvance.ui.viewmodel.LoginViewModel
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navController: NavHostController
) {

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val state by viewModel.loginState.collectAsState(initial = null)

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = 59.dp),
            text = "Hi, Welcome! \uD83D\uDC4B",
            style = TextStyle(
                fontSize = 30.sp,
                lineHeight = 39.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight(700),
                color = Color(0xFF000000)
            )
        )

        Spacer(modifier = Modifier.height(70.dp))

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.width(320.dp)
        ) {
            Text(text = "Email Address")

            CustomOutlinedTextField(
                value = email,
                label = "Your Email Address",
                onValueChange = {
                    email = it
                }
            )

            Spacer(modifier = Modifier.height(22.dp))

            Text(text = "Password")

            CustomOutlinedTextField(
                value = password,
                label = "Password",
                onValueChange = {
                    password = it
                }
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                scope.launch {
                    viewModel.loginUser(email, password)
                    navController.navigate("SholatNow")
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF365E32)),
            modifier = Modifier
                .width(320.dp)
                .height(56.dp)
                .background(color = Color(0xFF365E32), shape = RoundedCornerShape(size = 10.dp))
        ) {
            Text(
                text = "Log In",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF)
                )
            )
        }

        Spacer(modifier = Modifier.height(38.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Divider(
                thickness = 1.dp,
                color = Color.Black,
                modifier = Modifier
                    .width(92.dp)
                    .background(color = Color(0xFFD8DADC))
                    .padding(end = 20.dp)
            )

            Text(text = "or Log In with")

            Divider(
                thickness = 1.dp,
                color = Color.Black,
                modifier = Modifier
                    .width(92.dp)
                    .background(color = Color(0xFFD8DADC))
                    .padding(start = 20.dp)
            )
        }

        Spacer(modifier = Modifier.height(38.dp))

        Image(
            painter = painterResource(id = R.drawable.google),
            contentDescription = "google_Icon",
            modifier = Modifier
                .width(320.dp)
                .height(56.dp)
        )

        Spacer(modifier = Modifier.height(42.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Don’t have an account?",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 17.5.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight(400),
                    color = Color(0xB2000000)
                )
            )

            Text(
                text = "Sign Up",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 17.5.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF365E32)
                )
            )
        }

        Image(
            painter = painterResource(id = R.drawable.bg_mosque), // Replace with your background image resource
            contentDescription = "Background Image",
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        LaunchedEffect(key1 = state) {
            scope.launch {
                if (state?.isError?.isNotEmpty() == true) {
                    val error = state?.isError
                    Toast.makeText(context, "$error", Toast.LENGTH_SHORT).show()
                } else if (state?.isSucces?.isNotEmpty() == true) {
                    Toast.makeText(context, "Sign In Success", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun CustomOutlinedTextField(value: String, label: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = { /* Handle action done if needed */ }),
        modifier = Modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        navController = rememberNavController()
    )
}