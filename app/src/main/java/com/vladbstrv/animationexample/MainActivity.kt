package com.vladbstrv.animationexample

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.*
import com.vladbstrv.animationexample.databinding.ActivityMainBinding
import com.vladbstrv.animationexample.databinding.ActivityMainExplodeBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainExplodeBinding
    private var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainExplodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = Adapter()
    }

    private fun explode(clickedView: View){
        val set = TransitionSet()
        val explode = Explode()
        val fade = Fade()
        fade.duration = 5000
        val rect = Rect()
        clickedView.getGlobalVisibleRect(rect)
        explode.duration = 2000
        explode.excludeTarget(clickedView, true)
        set.addTransition(explode)
        set.addTransition(fade)
        explode.epicenterCallback = object : Transition.EpicenterCallback() {
            override fun onGetEpicenter(transition: Transition): Rect {
                return rect
            }

        }
        TransitionManager.beginDelayedTransition(binding.recyclerView, set)
        binding.recyclerView.adapter = null
    }

    inner class Adapter : RecyclerView.Adapter<ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.activity_main_explode_recycler_item,
                    parent,
                    false
                ) as View
            )
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.itemView.setOnClickListener {
                explode(it)
            }
        }

        override fun getItemCount(): Int {
            return 32
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}