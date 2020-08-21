package com.example.errorbox.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.errorbox.R
import com.example.errorbox.databinding.FragmentGameOverBinding

class  GameOverFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameOverBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game_over, container, false)
        binding.tryAgainButton.setOnClickListener { view: View ->
            val nextFrag = GameFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container_a, nextFrag, "findThisFragment")
                    .addToBackStack(null)
                    .commit()
        }
        return binding.root
    }
}