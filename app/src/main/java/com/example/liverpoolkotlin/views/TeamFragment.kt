package com.example.liverpoolkotlin.views

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

class TeamFragment : Fragment() {

    private var _binding: FragmentTeamBinding? = null
    private val binding get() = _binding!!
    private lateinit var playerAdapter: PlayerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTeamBinding.inflate(inflater,container,false)
        val view = binding.root
//        initRecyclerView(view)
        return view
    }

    //need more information
    private fun initRecyclerView(view: View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        //playerAdapter = PlayerAdapter()
    }
}