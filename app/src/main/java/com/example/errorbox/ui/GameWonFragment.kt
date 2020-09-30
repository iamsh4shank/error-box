package com.example.errorbox.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.errorbox.R
import com.example.errorbox.databinding.FragmentGameWonBinding
import com.example.errorbox.hints.HintAFragment
import java.util.*

class GameWonFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game_won, container, false)
        binding.nextMatchButton.setOnClickListener{view: View->
            
            val hintAFragment = HintAFragment(context, activity)
            val rand = Random()
            val id: Int = rand.nextInt(1000)*1000
            hintAFragment.init("You did it! The final level is in /home/Kernel. Good Luck! And remember to take a screenshot of this window. ID is: $id")
        }
        return binding.root
    }
}