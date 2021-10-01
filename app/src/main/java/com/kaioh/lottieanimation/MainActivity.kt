package com.kaioh.lottieanimation

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable

class MainActivity : AppCompatActivity() {

    private val dogAnim by lazy {
        findViewById<LottieAnimationView>(R.id.animation)
    }

    private val username by lazy {
        findViewById<EditText>(R.id.et_type_username)
    }

    private val password by lazy {
        findViewById<EditText>(R.id.et_type_password)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startAnimation()
        setupOnListeners()
    }

    private fun setupOnListeners() {
        username.apply {
            setOnFocusChangeListener { _, _ ->
                listenerOnTypeUsername()
            }
        }
        password.setOnFocusChangeListener { _, _ ->
            listenerOnTypePassword()
        }
    }

    private fun listenerOnTypeUsername() {
        dogAnim.apply {
            setAnimation("anim_dog.json")
            setMinAndMaxProgress(0.5f, 0.8f)
            repeatCount = LottieDrawable.INFINITE
            playAnimation()
        }
    }

    private fun listenerOnTypePassword() {
        dogAnim.apply {
            setAnimation("anim_dog.json")
            setMinAndMaxProgress(0.2f, 0.3f)
            repeatCount = LottieDrawable.INFINITE
            playAnimation()
        }
    }

    private fun startAnimation() {
        listenerOnTypeUsername()
    }
}