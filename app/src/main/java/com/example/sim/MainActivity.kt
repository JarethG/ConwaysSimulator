package com.example.sim

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val displayMetrics = DisplayMetrics()
        this.windowManager.defaultDisplay.getMetrics(displayMetrics);
        Constants.SCREEN_WIDTH = displayMetrics.widthPixels
        Constants.SCREEN_HEIGHT = displayMetrics.heightPixels
        setContentView(R.layout.activity_main)
    }

    fun setSteps(view:View){
        val steps = findViewById<TextView>(R.id.steps)
        val i = Integer.parseInt(steps.text.toString())

        when (view.id) {
            R.id.increase_steps -> steps.text = (i+1).toString()
            R.id.decrease_steps -> if(i!=0) steps.text = (i-1).toString()
        }
    }

    fun startGame(view :View) {
        println("game is starting")
        val b = findViewById<Button>(R.id.start_button)
        val gameView = findViewById<GameView>(R.id.gv)
        if(b.text == "stop"){
            gameView.setSteps(0)
            b.text = "start"
        } else {
            val steps = findViewById<TextView>(R.id.steps)
            val i = Integer.parseInt(steps.text.toString())
            gameView.setSteps(i)
            b.text = "stop"
        }
    }
}