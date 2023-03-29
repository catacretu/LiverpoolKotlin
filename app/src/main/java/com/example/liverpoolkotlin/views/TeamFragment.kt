package com.example.liverpoolkotlin.views

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        _binding = FragmentTeamBinding.inflate(inflater,container,false)
        val view = binding.root
        initRecyclerView(view)
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    private fun initRecyclerView(view: View){
        playerViewModel.getPlayerObserver().observe(viewLifecycleOwner){
            val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            playerAdapter = PlayerAdapter(it,view.context)
            recyclerView.adapter = playerAdapter
        }
    }
}