package com.apb.apb_p2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    lateinit var username: EditText  // Globale Variable - Field
    lateinit var show: TextView  // Globale Variable - Field
    lateinit var ok: Button  // Globale Variable - Field

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        username = findViewById(R.id.username)
        ok = findViewById(R.id.ok)
        show = findViewById(R.id.show)

        createAnimationEditText(this, R.anim.zoom_in)
        createAnimationTextView(this, R.anim.blink_animation)
        createAnimationButton(R.anim.slide_animation)
    }
    private fun createAnimationEditText(context: Context, animationZoomId: Int) {
        username.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                val animation = AnimationUtils.loadAnimation(context, animationZoomId)
                username.startAnimation(animation)
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }
    private fun createAnimationButton(animationZoomId: Int) {
        ok.setOnClickListener {
            // Load the animation from the specified resource ID
            val animation = AnimationUtils.loadAnimation(this, animationZoomId)
            // Start the animation on the ImageView
            ok.startAnimation(animation)
            show.text = username.text.toString()
        }
    }
    private fun createAnimationTextView(context: Context, animationZoomId: Int) {
        show.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                val animation = AnimationUtils.loadAnimation(context, animationZoomId)
                show.startAnimation(animation)
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }
}