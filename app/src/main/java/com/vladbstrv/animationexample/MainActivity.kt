package com.vladbstrv.animationexample

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
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
import java.time.Duration

class MainActivity : AppCompatActivity() {


    //2.50.00



    val duration = 1000L

    lateinit var binding: ActivityMainBinding
    private var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.scrollView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->

            binding.header.isSelected = binding.scrollView.canScrollVertically(-1)
        }
    }

}