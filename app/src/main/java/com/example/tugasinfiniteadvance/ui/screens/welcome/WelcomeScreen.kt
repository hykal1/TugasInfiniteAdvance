package com.example.tugasinfiniteadvance.ui.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tugasinfiniteadvance.R
import com.example.tugasinfiniteadvance.ui.theme.poppinsFontFamily
import com.example.tugasinfiniteadvance.ui.viewmodel.WelcomeViewModel

@Composable
fun WelcomeScreen(
    navController: NavHostController
) {
    Column (
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo_icon",
            modifier = Modifier
                .width(310.dp)
                .padding(top = 63.dp)
        )

        /*Spacer(modifier = Modifier.height(67.dp))*/

        Text(
            text = "ShalatNow",
            style = TextStyle(
                fontSize = 32.sp,
                lineHeight = 41.6.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
            )
        )

        Text(
            text = "Pendamping ibadah yang siap \nmengingatkan setiap saat",
            style = TextStyle(
                fontSize = 17.sp,
                lineHeight = 21.25.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight(400),
                color = Color(0xB2000000),
                textAlign = TextAlign.Center,
            )
        )

        Spacer(modifier = Modifier.height(87.dp))

        Button(
            onClick = {
                navController.navigate("Login")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF365E32)),
            modifier = Modifier
                .width(320.dp)
                .height(56.dp)
                .background(color = Color(0xFF365E32), shape = RoundedCornerShape(size = 10.dp))
        ) {
            Text(
                text = "Sign In",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),
                )
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Button(
            onClick = {
                navController.navigate("SignUp")
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            modifier = Modifier
                .width(320.dp)
                .height(56.dp)
                .border(3.dp, Color(0xFF365E32), shape = RoundedCornerShape(size = 10.dp))
                .background(color = Color.White, shape = RoundedCornerShape(size = 10.dp))
        ) {
            Text(
                text = "Create account",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF365E32),
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
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen(
        rememberNavController()
    )
}