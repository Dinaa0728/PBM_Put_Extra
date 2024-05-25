package com.example.pbm_put_extra

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MoveWithDataActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_move_with_data)
        val tvDataReceived: TextView = findViewById(R.id.tv_data_received)
        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Person>(EXTRA_PERSON,
                Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }
        if (person != null) {
            val text = "Name : ${person.name},\nEmail : ${person.email}, \nAge : ${person.age},  \nLocation : ${person.city}"
            tvDataReceived.text = text
        }

        val name = intent.getStringExtra(EXTRA_NAME)
        val age = intent.getIntExtra(EXTRA_AGE, 0)

        val text = "Name : $name, Your Age : $age"

        tvDataReceived.text = text

    }
}