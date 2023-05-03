package com.example.liverpoolkotlin.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.liverpoolkotlin.R

@Composable
fun HistoryScreen() {

    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFAB1A21))
    ) {
        Text(
            text = stringResource(id = R.string.history_text),
            color = Color.White,
            modifier = Modifier.verticalScroll(rememberScrollState()),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}