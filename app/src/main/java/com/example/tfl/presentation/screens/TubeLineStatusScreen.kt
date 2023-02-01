package com.example.tfl.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tfl.presentation.components.TubeLineCard
import com.example.tfl.presentation.viewModel.TubeLineStatusViewModel

@Composable
fun TubeLineStatusScreen(
    navHostController: NavController,
    viewModel: TubeLineStatusViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Column(modifier = Modifier
        .padding(top = 15.dp)
        .padding(start = 10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Status updates",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        )
        Column(modifier = Modifier
            .padding(top = 15.dp)) {

            LazyColumn() {
                items(state.tubeLineStatus) { tubeLineStatus ->
                    Row() {
                        TubeLineCard(tubeLineResponses = tubeLineStatus)
                    }
                }
            }
        }
    }


}