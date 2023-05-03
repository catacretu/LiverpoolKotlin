package com.example.liverpoolkotlin.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.liverpoolkotlin.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.steven_g),
                contentScale = ContentScale.FillBounds
            )
    ) {

        val (historyButton, lineupButton, uclButton, historyText, lineupText, uclText) = createRefs()
        val typography = initializeFonts()
        val uriHandler = LocalUriHandler.current

        Card(
            onClick = {
                navController.navigate("history")
            },
            modifier = Modifier
                .width(150.dp)
                .height(100.dp)
                .constrainAs(historyButton) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    centerVerticallyTo(parent, bias = 0.42F)
                    centerHorizontallyTo(parent, bias = 0.53F)
                },
        )
        {
            Image(
                painter = painterResource(id = R.drawable.anfield_01),
                contentScale = ContentScale.FillBounds,
                contentDescription = ""
            )
            Text(
                text = "HISTORY",
                style = typography.body1,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                fontSize = 19.sp,
                color = Color.White
            )
        }

        Card(
            onClick = {
                navController.navigate("lineup")
            },
            modifier = Modifier
                .width(150.dp)
                .height(100.dp)
                .constrainAs(lineupButton) {
                    top.linkTo(historyButton.bottom)
                    end.linkTo(parent.end)
                    centerHorizontallyTo(parent, bias = 0.53F)
                },
        )
        {
            Image(
                painter = painterResource(id = R.drawable.mo_back1),
                contentScale = ContentScale.FillBounds,
                contentDescription = ""
            )
            Text(
                text = "LINEUP",
                style = typography.body1,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                fontSize = 19.sp,
                color = Color.White
            )
        }
        Card(
            onClick = {
                uriHandler.openUri("https://www.youtube.com/watch?v=t7_tnbSSXMQ")
            },
            modifier = Modifier
                .width(150.dp)
                .height(100.dp)
                .constrainAs(uclButton) {
                    top.linkTo(lineupButton.bottom)
                    end.linkTo(parent.end)
                    centerHorizontallyTo(parent, bias = 0.53F)
                },
        )
        {
            Image(
                painter = painterResource(id = R.drawable.ucl1),
                contentScale = ContentScale.FillBounds,
                contentDescription = ""
            )
            Text(
                text = "UCL",
                style = typography.body1,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                fontSize = 19.sp,
                color = Color.White
            )
        }
    }
}

fun initializeFonts(): Typography {
    val fonts = FontFamily(
        Font(R.font.roboto_condensed_bold)
    )
    return Typography(
        body1 = TextStyle(
            fontFamily = fonts,
            fontWeight = FontWeight.Normal,
            fontSize = 40.sp,
            color = Color(0xFF0F205B)
        )
    )
}



