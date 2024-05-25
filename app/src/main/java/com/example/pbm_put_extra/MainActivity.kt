package com.example.pbm_put_extra

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)

        btnMoveActivity.setOnClickListener(this)
        btnMoveWithDataActivity.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_move_activity -> {
                val person = Person("Dina", 5, "Dina@gmail.com", "Surabaya")
                val moveWithObjectIntent =
                    Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithObjectIntent.putExtra(
                    MoveWithDataActivity.EXTRA_PERSON, person
                )
            }
            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Ferdina")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 20)
                startActivity(moveWithDataIntent)
            }
        }
    }
}