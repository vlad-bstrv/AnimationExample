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
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import com.vladbstrv.animationexample.databinding.ActivityMainBinding
import com.vladbstrv.animationexample.databinding.ActivityMainExplodeBinding
import com.vladbstrv.animationexample.databinding.ActivityMainPathBinding
import com.vladbstrv.animationexample.databinding.ActivityMainZoomBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainPathBinding
    private var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainPathBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            val changeBounds = ChangeBounds()
            changeBounds.duration = 5000
            changeBounds.setPathMotion(ArcMotion())
            TransitionManager.beginDelayedTransition(binding.root, changeBounds)
            flag = !flag
            val params = binding.button.layoutParams as FrameLayout.LayoutParams
            params.gravity = if(flag) Gravity.BOTTOM or Gravity.END else Gravity.START or Gravity.TOP
            binding.button.layoutParams = params
        }
    }

}