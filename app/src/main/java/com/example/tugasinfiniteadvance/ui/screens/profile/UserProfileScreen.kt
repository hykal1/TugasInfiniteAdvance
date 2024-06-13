@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.tugasinfiniteadvance.ui.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.tugasinfiniteadvance.R
import com.example.tugasinfiniteadvance.ui.theme.poppinsFontFamily
import com.example.tugasinfiniteadvance.ui.viewmodel.UserProfileViewModel

@Composable
fun UserProfileScreen(viewModel: UserProfileViewModel = viewModel()) {
    val userProfile by viewModel.userProfile.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            /*.padding(20.dp)*/
            .background(MaterialTheme.colorScheme.background),
        /*verticalArrangement = Arrangement.Center,*/
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Profile",
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 36.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight(700),
                color = Color(0xFF202020)
                ),
            modifier = Modifier
                .padding(top = 35.dp)
        )

        Spacer(modifier = Modifier.height(28.dp))

        userProfile?.let {
            Column(
                modifier = Modifier.padding(start = 36.dp, top = 16.dp, end = 36.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Avatar(userProfile.username.first().uppercaseChar())

                Spacer(modifier = Modifier.height(37.dp))

                /*UserProfileDisplayField("ID", it.id)*/

                UserProfileInputField(
                    label = "Username",
                    value = it.username,
                    icon = Icons.Default.Person,
                    onValueChange = { newValue ->
                        viewModel.updateUserProfile(it.copy(username = newValue))
                    }
                )

                UserProfileInputField(
                    label = "Email",
                    value = it.email,
                    icon = Icons.Default.Email,
                    onValueChange = { newValue ->
                        viewModel.updateUserProfile(it.copy(email = newValue))
                    }
                )

                UserProfileInputField(
                    label = "Password",
                    value = it.password,
                    icon = Icons.Default.Lock,
                    onValueChange = { newValue ->
                        viewModel.updateUserProfile(it.copy(password = newValue))
                    }
                )

                UserProfileInputField(
                    label = "Country",
                    value = it.country,
                    icon = Icons.Default.LocationOn,
                    onValueChange = { newValue ->
                        viewModel.updateUserProfile(it.copy(country = newValue))
                    }
                )

                UserProfileInputField(
                    label = "City",
                    value = it.city,
                    icon = Icons.Default.LocationOn,
                    onValueChange = { newValue ->
                        viewModel.updateUserProfile(it.copy(city = newValue))
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD41616)),
            modifier = Modifier
                .width(320.dp)
                .height(56.dp)
                .background(color = Color(0xFFD41616), shape = RoundedCornerShape(size = 10.dp))
        ) {
            Text(
                text = "Log Out",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),
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

@Composable
fun Avatar(initial: Char) {
    Box(
        modifier = Modifier
            .size(80.dp)
            .background(MaterialTheme.colorScheme.primary, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = initial.toString(),
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfileInputField(
    label: String,
    value: String,
    icon: ImageVector,
    onValueChange: (String) -> Unit
) {
    var text by remember { mutableStateOf(value) }

    OutlinedTextField(
        value = text,
        onValueChange = { newValue ->
            text = newValue
            onValueChange(newValue)
        },
        label = { Text(label) },
        leadingIcon = { Icon(icon, contentDescription = label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            cursorColor = MaterialTheme.colorScheme.primary
        ),
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.onBackground
        ),
        singleLine = true,
        shape = RoundedCornerShape(12.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun UserProfileScreenPreview() {
    UserProfileScreen(viewModel = UserProfileViewModel())
}