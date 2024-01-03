package com.example.tictactoe_games

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private var isPlay = false
    private var isPlayer1 by Delegates.notNull<Boolean>()

    private lateinit var playBtn : Button
    private lateinit var gameResultTV : TextView

    private lateinit var item00 : ImageView
    private lateinit var item01 : ImageView
    private lateinit var item02 : ImageView
    private lateinit var item10 : ImageView
    private lateinit var item11 : ImageView
    private lateinit var item12 : ImageView
    private lateinit var item20 : ImageView
    private lateinit var item21 : ImageView
    private lateinit var item22 : ImageView

    private var board = Array(3){IntArray(3)}

    private fun initComponent(){
        playBtn = findViewById(R.id.playBtn)
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

        gameResultTV.visibility = TextView.INVISIBLE

        playBtn.setOnClickListener {
            isPlay = true
            if (isPlay){
                playGame()
            }
        }
    }

    private fun playGame() {
        isPlayer1 = true
        gameResultTV.visibility = TextView.INVISIBLE
        playBtn.visibility = Button.INVISIBLE
        initOnclick()
    }

    private fun insertItem(item : ImageView, i: Int, j: Int) {


        if (isPlayer1){
            board[i][j] = 1
            item.setImageResource(R.drawable.x_icon)
        }else{
            board[i][j] = 2
            item.setImageResource(R.drawable.o_icon)
        }
        item.isEnabled = false
        isPlayer1 = !isPlayer1
    }

    private fun initOnclick() {
        item00.setOnClickListener{
            insertItem(it as ImageView, 0,0)
        }
        item01.setOnClickListener{
            insertItem(it as ImageView, 0,1)
        }
        item02.setOnClickListener{
            insertItem(it as ImageView, 0,2)
        }
        item10.setOnClickListener{
            insertItem(it as ImageView, 1,0)
        }
        item11.setOnClickListener{
            insertItem(it as ImageView, 1,1)
        }
        item12.setOnClickListener{
            insertItem(it as ImageView, 1,2)
        }
        item20.setOnClickListener{
            insertItem(it as ImageView, 2,0)
        }
        item21.setOnClickListener{
            insertItem(it as ImageView, 2,1)
        }
        item22.setOnClickListener{
            insertItem(it as ImageView, 2,2)
        }
    }


}