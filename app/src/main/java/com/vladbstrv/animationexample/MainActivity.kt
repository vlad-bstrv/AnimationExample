package com.vladbstrv.animationexample

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import com.vladbstrv.animationexample.databinding.ActivityMainBinding
import com.vladbstrv.animationexample.databinding.ActivityMainExplodeBinding
import com.vladbstrv.animationexample.databinding.ActivityMainPathBinding
import com.vladbstrv.animationexample.databinding.ActivityMainZoomBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titles: MutableList<String> = ArrayList()
        repeat(11) {
            titles.add("item $it")
        }

        binding.button.setOnClickListener {
            TransitionManager.beginDelayedTransition(binding.transitionContainer)
            titles.shuffle()
            binding.transitionContainer.removeAllViews()
            titles.forEach{ title: String ->
                binding.transitionContainer.addView(TextView(this).apply {
                    text = title
                    ViewCompat.setTransitionName(this, title)
                })

            }
        }
    }

}