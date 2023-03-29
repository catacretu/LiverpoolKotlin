package com.example.liverpoolkotlin.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.liverpoolkotlin.databinding.FragmentHomeBinding
import dagger.android.support.AndroidSupportInjection

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? =null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.historyButton.setOnClickListener {
            val action = HomeFragmentDirections.homeFragmentToHistoryFragment()
            findNavController().navigate(action)
        }
        binding.teamButton.setOnClickListener {
            val action = HomeFragmentDirections.homeFragmentToTeamFragment()
            findNavController().navigate(action)
        }
    }
}

