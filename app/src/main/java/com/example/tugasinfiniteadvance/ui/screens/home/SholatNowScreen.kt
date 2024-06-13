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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tugasinfiniteadvance.R
import com.example.tugasinfiniteadvance.data.remote.model.Jadwal
import com.example.tugasinfiniteadvance.helper.PrayerTimesViewModelFactory
import com.example.tugasinfiniteadvance.ui.theme.TugasInfiniteAdvanceTheme
import com.example.tugasinfiniteadvance.ui.theme.poppinsFontFamily
import com.example.tugasinfiniteadvance.ui.viewmodel.SholatNowViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SholatNowScreen() {

    val currentDate = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(Date())
    val currentTime = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
    val viewModel: SholatNowViewModel = viewModel(
        factory = PrayerTimesViewModelFactory(
            kota = "0506",
            tanggal = currentDate
        )
    )
    val prayerTime by viewModel.prayerTime.observeAsState()

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
                        color = White,
                    )
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_hamburger),
                        contentDescription = "hamburger",
                        tint = White,
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
        if (prayerTime == null) {
            Dialog(
                onDismissRequest = {  },
                DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
            ) {
                Box(
                    modifier = Modifier
                        .size(180.dp)
                        .background(White, shape = RoundedCornerShape(8.dp))
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .align(Alignment.Center)
                    ) {
                        Text(
                            text = "Tunggu Sebentar",
                            fontFamily = poppinsFontFamily,
                            modifier = Modifier.padding(
                                bottom = 24.dp
                            )
                        )
                        CircularProgressIndicator(
                            color = Color(0xFF365E32)
                        )
                    }
                }
            }
        } else {
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
                        val nextPrayer = getNextPrayerTime(prayerTime?.data?.jadwal, currentTime)
                        val timeDifference = nextPrayer?.second?.let { getTimeDifference(currentTime, it) }
                        Text(
                            text = "${nextPrayer?.first} ${nextPrayer?.second}",
                            fontSize = 35.sp,
                            fontFamily = poppinsFontFamily,
                            color = White,
                            modifier = Modifier
                        )
                        Text(
                            text = timeDifference ?: "",
                            fontSize = 15.sp,
                            fontFamily = poppinsFontFamily,
                            color = White,
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
                            text = "Hari ini di ${prayerTime?.data?.lokasi}",
                            fontSize = 18.sp,
                            fontFamily = poppinsFontFamily,
                            color = White,
                            modifier = Modifier
                        )
                        Text(
                            text = "${prayerTime?.data?.jadwal?.tanggal}",
                            fontSize = 15.sp,
                            fontFamily = poppinsFontFamily,
                            color = White,
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
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .padding(bottom = 24.dp)
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
                            text = "${prayerTime?.data?.jadwal?.subuh} AM",
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
                            text = "${prayerTime?.data?.jadwal?.dzuhur} PM",
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
                            text = "${prayerTime?.data?.jadwal?.ashar} PM",
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
                            text = "${prayerTime?.data?.jadwal?.maghrib} PM",
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
                            text = "${prayerTime?.data?.jadwal?.isya} PM",
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
}

fun getNextPrayerTime(jadwal: Jadwal?, currentTime: String): Pair<String, String>? {
    jadwal?.let { prayerTimes ->
        val prayerTimesList = listOf(
            "Subuh" to prayerTimes.subuh,
            "Dzuhur" to prayerTimes.dzuhur,
            "Ashar" to prayerTimes.ashar,
            "Maghrib" to prayerTimes.maghrib,
            "Isya" to prayerTimes.isya
        )

        for (prayer in prayerTimesList) {
            if (currentTime < prayer.second) {
                return prayer
            }
        }

        return "Subuh" to prayerTimes.subuh
    }
    return null
}


fun getTimeDifference(currentTime: String, nextPrayerTime: String?): String {
    nextPrayerTime?.let {
        if (it == "N/A") {
            return "N/A"
        }

        val currentHour = currentTime.substringBefore(":").toInt()
        val currentMinute = currentTime.substringAfter(":").toInt()

        val nextHour = it.substringBefore(":").toInt()
        val nextMinute = it.substringAfter(":").toInt()

        val currentTotalMinutes = currentHour * 60 + currentMinute
        val nextTotalMinutes = nextHour * 60 + nextMinute

        var difference = nextTotalMinutes - currentTotalMinutes

        if (difference < 0) {
            difference += 24 * 60
        }

        val hours = difference / 60
        val minutes = difference % 60

        return "$hours jam $minutes menit lagi"
    }
    return "N/A"
}



@Preview(showBackground = true)
@Composable
private fun SholatNowPreview() {
    TugasInfiniteAdvanceTheme {
        SholatNowScreen()
    }
}