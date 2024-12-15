package com.example.ma_assignment

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ma_assignment.R.*

class FragmentContainerActivity : AppCompatActivity() {

    private var showingFragmentA = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_fragment_container)

        supportFragmentManager.beginTransaction()
            .add(id.fragment_container, FragmentA())
            .commit()

        val switchButton = findViewById<Button>(id.switch_button)

        switchButton.setOnClickListener {
            var fragment: Fragment

            if (showingFragmentA) {
                fragment = FragmentB()
            } else {
                fragment = FragmentA()
            }

            supportFragmentManager.beginTransaction()
                .replace(id.fragment_container, fragment)
                .commit()

            showingFragmentA = !showingFragmentA
        }
    }
}
