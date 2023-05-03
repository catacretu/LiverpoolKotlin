package com.example.liverpoolkotlin.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.liverpoolkotlin.R
import com.example.liverpoolkotlin.data.local.model.PlayerEntity

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun LineupScreen(playersList: List<PlayerEntity>) {

    LazyColumn(
        modifier = Modifier
            .background(Color(0xFFAB1A21))
            .padding(top = 10.dp)
    ) {
        items(playersList.size) { index ->

            Card(
                modifier = Modifier
                    .widthIn(min = 160.dp)
                    .heightIn(min = 180.dp)
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                backgroundColor = Color(0xFFB8192B),
                shape = RoundedCornerShape(corner = CornerSize(16.dp))

            ) {
                ConstraintLayout(modifier = Modifier.fillMaxSize()) {

                    val (playerImage, title, price, liverpoolIcon) = createRefs()

                    GlideImage(model = playersList[index].imageUrl,
                        contentDescription = "",
                        modifier = Modifier
                            .size(150.dp)
                            .padding(top = 15.dp)
                            .constrainAs(playerImage) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                            })

                    Text(
                        text = playersList[index].name,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(top = 40.dp, start = 10.dp)
                            .constrainAs(title) {
                                top.linkTo(parent.top)
                                start.linkTo(playerImage.end)
                            }
                    )
                    Text(
                        text = playersList[index].position,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(top = 5.dp, start = 10.dp)
                            .constrainAs(price) {
                                top.linkTo(title.bottom)
                                start.linkTo(playerImage.end)
                            }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.liverpool_icon),
                        contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                            .constrainAs(liverpoolIcon) {
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                                linkTo(
                                    liverpoolIcon.end,
                                    parent.end,
                                    endMargin = 10.dp,
                                    bias = 0F
                                )
                            }
                    )
                }
            }
        }
    }
}
