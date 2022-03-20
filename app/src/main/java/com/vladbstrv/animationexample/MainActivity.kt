package com.vladbstrv.animationexample

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import com.vladbstrv.animationexample.databinding.ActivityMainBinding
import com.vladbstrv.animationexample.databinding.ActivityMainExplodeBinding
import com.vladbstrv.animationexample.databinding.ActivityMainZoomBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainZoomBinding
    private var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainZoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.setOnClickListener {

            val changeBounds = ChangeImageTransform()
            TransitionManager.beginDelayedTransition(binding.container, changeBounds)

            flag = !flag
            binding.imageView.scaleType = if(flag) ImageView.ScaleType.CENTER_CROP else ImageView.ScaleType.CENTER_INSIDE
        }
    }

}