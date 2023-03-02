package com.birdushenin.kinopoisk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentManager = supportFragmentManager

        if (fragmentManager.findFragmentById(R.id.fragment_container) == null) {
            fragmentManager.commit {
                add<PageFragment>(R.id.fragment_container, FRAGMENT_CHARACTERS)
            }
        }

    }

    private companion object {
        private const val FRAGMENT_CHARACTERS = "characters"

    }
}
