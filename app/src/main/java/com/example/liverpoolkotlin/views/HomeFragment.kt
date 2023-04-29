package com.example.liverpoolkotlin.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.liverpoolkotlin.R
import dagger.android.support.AndroidSupportInjection

class HomeFragment : Fragment() {

//    private var _binding: FragmentHomeBinding? =null
//    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply {
            setContent {
                LoadUI()
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding.historyButton.setOnClickListener {
//            val action = HomeFragmentDirections.homeFragmentToHistoryFragment()
//            findNavController().navigate(action)
//        }
//        binding.teamButton.setOnClickListener {
//            val action = HomeFragmentDirections.homeFragmentToTeamFragment()
//            findNavController().navigate(action)
//        }
//        binding.videoUcl.setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("https://www.youtube.com/watch?v=t7_tnbSSXMQ")
//            startActivity(intent)
//        }
//    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun LoadUI() {
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

            Card(
                onClick = {
                    Toast.makeText(requireContext(), "History", Toast.LENGTH_SHORT).show()
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
                onClick = { Toast.makeText(requireContext(), "Lineup", Toast.LENGTH_SHORT).show() },
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
                onClick = { Toast.makeText(requireContext(), "UCL", Toast.LENGTH_SHORT).show() },
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

    private fun initializeFonts(): Typography {
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
}

