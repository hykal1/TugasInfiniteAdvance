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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SholatNowScreen() {

    val systemUiController = rememberSystemUiController()
    val currentDate = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(Date())
    val viewModel: SholatNowViewModel = viewModel(
        factory = PrayerTimesViewModelFactory(
            kota = "0506",
            tanggal = currentDate
        )
    )
    val prayerTime by viewModel.prayerTime.observeAsState()
    var showDialog by remember { mutableStateOf(prayerTime == null) }

    LaunchedEffect(prayerTime) {
        if (prayerTime == null) {
            showDialog = true
        } else {
            delay(1000)
            showDialog = false
        }
    }

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = false
        )
    }
    
    val context = LocalContext.current
    var currentTime by remember { mutableStateOf(getCurrentTime()) }
    var countdown by remember { mutableStateOf("N/A") }

    // Update currentTime every second
    LaunchedEffect(Unit) {
        while (true) {
            currentTime = getCurrentTime()
            countdown = prayerTime?.data?.jadwal?.let { jadwal ->
                val nextPrayer = getNextPrayerTime(jadwal, currentTime)
                nextPrayer?.second?.let { getTimeDifference(currentTime, it) } ?: "N/A"
            } ?: "N/A"
            delay(1000)
        }
    }

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
        if (showDialog) {
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
                            text = "Login Berhasil",
                            fontFamily = poppinsFontFamily,
                        )
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

            LaunchedEffect(prayerTime) {
                prayerTime?.data?.jadwal?.let { jadwal ->
                    viewModel.schedulePrayerAlarm(context, "Subuh", jadwal.subuh)
                    viewModel.schedulePrayerAlarm(context, "Dzuhur", jadwal.dzuhur)
                    viewModel.schedulePrayerAlarm(context, "Ashar", jadwal.ashar)
                    viewModel.schedulePrayerAlarm(context, "Maghrib", jadwal.maghrib)
                    viewModel.schedulePrayerAlarm(context, "Isya", jadwal.isya)
                }
            }

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

fun getCurrentTime(): String {
    return SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
}

fun getNextPrayerTime(jadwal: Jadwal?, currentTime: String): Pair<String, String>? {
    jadwal?.let { prayerTimes ->
        val prayerTimesList = listOf(
            "Subuh Pukul" to prayerTimes.subuh,
            "Dzuhur Pukul" to prayerTimes.dzuhur,
            "Ashar Pukul" to prayerTimes.ashar,
            "Maghrib Pukul" to prayerTimes.maghrib,
            "Isya Pukul" to prayerTimes.isya
        )

        for (prayer in prayerTimesList) {
            if (currentTime < prayer.second) {
                return prayer
            }
        }
        return "Subuh Pukul" to prayerTimes.subuh
    }
    return null
}

fun getTimeDifference(currentTime: String, nextPrayerTime: String?): String {
    nextPrayerTime?.let {
        if (it == "N/A") {
            return "N/A"
        }

        val currentHour = currentTime.substringBefore(":").toInt()
        val currentMinute = currentTime.substringAfter(":").substringBefore(":").toInt()
        val currentSecond = currentTime.substringAfterLast(":").toInt()

        val nextHour = it.substringBefore(":").toInt()
        val nextMinute = it.substringAfter(":").substringBefore(":").toInt()
        val nextSecond = it.substringAfterLast(":").toInt()

        val currentTotalSeconds = currentHour * 3600 + currentMinute * 60 + currentSecond
        val nextTotalSeconds = nextHour * 3600 + nextMinute * 60 + nextSecond

        var difference = nextTotalSeconds - currentTotalSeconds

        if (difference < 0) {
            difference += 24 * 3600
        }

        val hours = difference / 3600
        val minutes = (difference % 3600) / 60
        val seconds = difference % 60

        return "$hours jam $minutes menit $seconds detik lagi"
        //return String.format("%02d:%02d:%02d lagi", hours, minutes, seconds)
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