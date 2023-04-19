package com.example.liverpoolkotlin.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.liverpoolkotlin.R
import com.example.liverpoolkotlin.adapter.PlayerAdapter
import com.example.liverpoolkotlin.databinding.FragmentTeamBinding
import com.example.liverpoolkotlin.viewmodel.PlayerViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class TeamFragment : Fragment() {

    private var _binding: FragmentTeamBinding? = null
    private val binding get() = _binding!!
    private lateinit var playerAdapter: PlayerAdapter

    @Inject
    lateinit var playerViewModel: PlayerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                recyclerList()
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

//    private fun initRecyclerView(view: View){
//        playerViewModel.getPlayerObserver().observe(viewLifecycleOwner){
//            val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
//            recyclerView.layoutManager = LinearLayoutManager(requireContext())
//            playerAdapter = PlayerAdapter(it,view.context)
//            recyclerView.adapter = playerAdapter
//        }
//    }

    @Composable
    fun recyclerList() {

        val list = mutableListOf("1", "2", "3", "4")
        val playersList = playerViewModel.playerData.value
        LazyVerticalGrid(
            columns = GridCells.Fixed(1)
        ) {
            items(playersList.size) { index ->

                Card(
                    modifier = Modifier
                        .widthIn(min = 160.dp)
                        .heightIn(min = 225.dp)
                        .padding(horizontal = 8.dp, vertical = 8.dp),
                    backgroundColor = Color.LightGray,

                    shape = RoundedCornerShape(corner = CornerSize(16.dp))

                ) {
                    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

                        val (imageItem, title, price) = createRefs()

                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "",
                            modifier = Modifier
                                .size(150.dp)
                                .padding(top = 15.dp)
                                .constrainAs(imageItem) {
                                    top.linkTo(parent.top)
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                })

                        Text(
                            text = playersList[index].name,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 5.dp)
                                .constrainAs(title) {
                                    top.linkTo(imageItem.bottom)
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                }
                        )
                        Text(
                            text = playersList[index].position,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 5.dp)
                                .constrainAs(price) {
                                    top.linkTo(title.bottom)
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                }

                        )
                    }
                }
            }
        }
    }
}