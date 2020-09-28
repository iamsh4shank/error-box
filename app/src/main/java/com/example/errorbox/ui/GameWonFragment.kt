package com.example.errorbox.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.errorbox.R
import com.example.errorbox.databinding.FragmentGameWonBinding
import com.example.errorbox.hints.HintAFragment

class GameWonFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game_won, container, false)
        binding.nextMatchButton.setOnClickListener{view: View->
            val hintAFragment = HintAFragment(context, activity)
            hintAFragment.init("Password for next module zip file is 'amFOSS@pRoB3'")
        }
        return binding.root
    }
}