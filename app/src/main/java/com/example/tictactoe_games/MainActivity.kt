package com.example.tictactoe_games

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var isPlay = true
    var isYou = true

    lateinit var playAgainBtn : Button
    lateinit var gameResultTV : TextView

    lateinit var item00 : ImageView
    lateinit var item01 : ImageView
    lateinit var item02 : ImageView
    lateinit var item10 : ImageView
    lateinit var item11 : ImageView
    lateinit var item12 : ImageView
    lateinit var item20 : ImageView
    lateinit var item21 : ImageView
    lateinit var item22 : ImageView

    private var board = Array(3){IntArray(3)}

    private fun initComponent(){
        playAgainBtn = findViewById(R.id.playAgainBtn)
        gameResultTV = findViewById(R.id.gameResultTV)

        item00 = findViewById(R.id.item00)
        item01 = findViewById(R.id.item01)
        item02 = findViewById(R.id.item02)
        item10 = findViewById(R.id.item10)
        item11 = findViewById(R.id.item11)
        item12 = findViewById(R.id.item12)
        item20 = findViewById(R.id.item20)
        item21 = findViewById(R.id.item21)
        item22 = findViewById(R.id.item22)
    }

    private fun initBoard(){
        for (i in 0..2){
            for (j in 0..2){
                board[i][j] = 0
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent()
        initBoard()

        if (isPlay){
            playAgainBtn.visibility = Button.INVISIBLE
            gameResultTV.visibility = TextView.INVISIBLE
        }
    }


}