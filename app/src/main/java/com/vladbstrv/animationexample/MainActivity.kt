package com.vladbstrv.animationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity

import android.view.View
import androidx.transition.*
import com.vladbstrv.animationexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    private var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val transition = TransitionSet()
            val fade = Slide()
            fade.slideEdge = Gravity.START
            fade.duration = 5000
            val changeBounds = ChangeBounds()
            changeBounds.duration = 2000
            transition.ordering = android.transition.TransitionSet.ORDERING_TOGETHER
            transition.addTransition(changeBounds)
            transition.addTransition(fade)
            TransitionManager.beginDelayedTransition(binding.transitionContainer, transition)
            flag = !flag
            binding.text.visibility = if(flag) View.VISIBLE else View.GONE
        }
    }
}