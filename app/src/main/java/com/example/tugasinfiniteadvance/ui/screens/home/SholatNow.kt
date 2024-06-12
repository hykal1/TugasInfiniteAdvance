package com.example.tugasinfiniteadvance.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.tugasinfiniteadvance.R
import com.example.tugasinfiniteadvance.ui.theme.TugasInfiniteAdvanceTheme
import com.example.tugasinfiniteadvance.ui.theme.poppinsFontFamily

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SholatNow(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Waktu Sholat",
                        fontFamily = poppinsFontFamily,
                        fontSize = 20.sp,
                        color = Color.White,
                    )
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_hamburger),
                        contentDescription = "hamburger",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier.background(Color.Transparent)
            )
        }
    ) { _ ->
        Column {
            Box(modifier = Modifier.wrapContentHeight()) {
                Box {
                    Image(
                        painter = painterResource(R.drawable.satu),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(480.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.vectorsatu),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .align(Alignment.BottomCenter)
                    )
                    Image(
                        painter = painterResource(R.drawable.vectorsatu),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .align(Alignment.BottomCenter)
                            .graphicsLayer {
                                alpha = 0.3f
                            }
                            .offset(
                                x = 210.dp,
                                y = (-20).dp
                            )
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(top = 130.dp)
                        .align(Alignment.TopCenter)
                ) {
                    Text(
                        text = "Subuh 04:45",
                        fontSize = 35.sp,
                        fontFamily = poppinsFontFamily,
                        color = Color.White,
                        modifier = Modifier
                    )
                    Text(
                        text = "1 jam 30 menit lagi",
                        fontSize = 15.sp,
                        fontFamily = poppinsFontFamily,
                        color = Color.White,
                        modifier = Modifier
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(
                            start = 27.dp,
                            bottom = 14.dp
                        )
                        .align(Alignment.BottomStart)
                ) {
                    Text(
                        text = "Hari ini di Bogor",
                        fontSize = 18.sp,
                        fontFamily = poppinsFontFamily,
                        color = Color.White,
                        modifier = Modifier
                    )
                    Text(
                        text = "Rabu, 10 April 2024 / 1 Syawal 1445 H",
                        fontSize = 15.sp,
                        fontFamily = poppinsFontFamily,
                        color = Color.White,
                        modifier = Modifier
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(
                        top = 40.dp,
                        start = 27.dp,
                        end = 27.dp
                    )
                    .fillMaxSize()
                    .background(
                        color = Color("#F5FFF4".toColorInt())
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .padding(bottom = 32.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Subuh",
                        fontSize = 16.sp,
                        fontFamily = poppinsFontFamily,
                        modifier = Modifier.weight(2f)
                    )
                    Text(
                        text = "04:45 AM",
                        fontSize = 16.sp,
                        fontFamily = poppinsFontFamily,
                        modifier = Modifier
                            .weight(2.5f)
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_alarm),
                        contentDescription = null,
                        modifier = Modifier
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(bottom = 24.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Dzuhur",
                        fontSize = 16.sp,
                        fontFamily = poppinsFontFamily,
                        modifier = Modifier.weight(2f)
                    )
                    Text(
                        text = "11:45 PM",
                        fontSize = 16.sp,
                        fontFamily = poppinsFontFamily,
                        modifier = Modifier
                            .weight(2.5f)
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_alarm),
                        contentDescription = null,
                        modifier = Modifier
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(bottom = 24.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Ashar",
                        fontSize = 16.sp,
                        fontFamily = poppinsFontFamily,
                        modifier = Modifier.weight(2f)
                    )
                    Text(
                        text = "15:45 PM",
                        fontSize = 16.sp,
                        fontFamily = poppinsFontFamily,
                        modifier = Modifier
                            .weight(2.5f)
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_alarm),
                        contentDescription = null,
                        modifier = Modifier
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(bottom = 24.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Maghrib",
                        fontSize = 16.sp,
                        fontFamily = poppinsFontFamily,
                        modifier = Modifier.weight(2f)
                    )
                    Text(
                        text = "17:45 PM",
                        fontSize = 16.sp,
                        fontFamily = poppinsFontFamily,
                        modifier = Modifier
                            .weight(2.5f)
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_alarm),
                        contentDescription = null,
                        modifier = Modifier
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(bottom = 24.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Isya",
                        fontSize = 16.sp,
                        fontFamily = poppinsFontFamily,
                        modifier = Modifier.weight(2f)
                    )
                    Text(
                        text = "18:00 PM",
                        fontSize = 16.sp,
                        fontFamily = poppinsFontFamily,
                        modifier = Modifier
                            .weight(2.5f)
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_alarm),
                        contentDescription = null,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SholatNowPreview() {
    TugasInfiniteAdvanceTheme {
        SholatNow()
    }
}