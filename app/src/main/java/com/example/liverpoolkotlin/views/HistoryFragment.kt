package com.example.liverpoolkotlin.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.liverpoolkotlin.R
import dagger.android.support.AndroidSupportInjection

class HistoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                loadUI()
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    @Composable
    fun loadUI() {

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
}