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

    private lateinit var playBtn: Button
    private lateinit var gameResultTV: TextView

    private lateinit var item00: ImageView
    private lateinit var item01: ImageView
    private lateinit var item02: ImageView
    private lateinit var item10: ImageView
    private lateinit var item11: ImageView
    private lateinit var item12: ImageView
    private lateinit var item20: ImageView
    private lateinit var item21: ImageView
    private lateinit var item22: ImageView

    private var board = Array(3) { IntArray(3) }

    private fun initComponent() {
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

    private fun initBoard() {
        for (i in 0..2) {
            for (j in 0..2) {
                board[i][j] = 0
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponent()

        gameResultTV.visibility = TextView.INVISIBLE

        playBtn.setOnClickListener {
            resetGame()
            isPlay = true
            if (isPlay) {
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

    private fun insertItem(item: ImageView, i: Int, j: Int) {
        if (isPlayer1) {
            board[i][j] = 1
            item.setImageResource(R.drawable.x_icon)
        } else {
            board[i][j] = 2
            item.setImageResource(R.drawable.o_icon)
        }
        item.isEnabled = false
        isPlayer1 = !isPlayer1
        checkWinner()
    }

    private fun winnerRules(player: Int): Boolean {
        for (i in 0..2) {
            if (
                board[i][0] == player && board[i][1] == player && board[i][2] == player // Check row Winner
                ||
                board[0][i] == player && board[1][i] == player && board[2][i] == player // Check column Winner
            ) {
                return true
            }

        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true
        }
        return false
    }

    private fun checkWinner() {
        if (winnerRules(1)) {
            gameResultTV.text = getString(R.string.player_1_win)
            gameEnd()
        }

        if (winnerRules(2)) {
            gameResultTV.text = getString(R.string.player_2_win)
            gameEnd()
        }
    }

    private fun gameEnd () {
        if (isPlay) {
            disableAllItem()
            gameResultTV.visibility = TextView.VISIBLE
            playBtn.visibility = Button.VISIBLE
            playBtn.text = getString(R.string.play_again)
            isPlay = false
        }
    }

    private fun resetGame () {
        initBoard()
        item00.setImageResource(0)
        item01.setImageResource(0)
        item02.setImageResource(0)
        item10.setImageResource(0)
        item11.setImageResource(0)
        item12.setImageResource(0)
        item20.setImageResource(0)
        item21.setImageResource(0)
        item22.setImageResource(0)
        item00.isEnabled = true
        item01.isEnabled = true
        item02.isEnabled = true
        item10.isEnabled = true
        item11.isEnabled = true
        item12.isEnabled = true
        item20.isEnabled = true
        item21.isEnabled = true
        item22.isEnabled = true
    }

    private fun initOnclick() {
        item00.setOnClickListener {
            insertItem(it as ImageView, 0, 0)
        }
        item01.setOnClickListener {
            insertItem(it as ImageView, 0, 1)
        }
        item02.setOnClickListener {
            insertItem(it as ImageView, 0, 2)
        }
        item10.setOnClickListener {
            insertItem(it as ImageView, 1, 0)
        }
        item11.setOnClickListener {
            insertItem(it as ImageView, 1, 1)
        }
        item12.setOnClickListener {
            insertItem(it as ImageView, 1, 2)
        }
        item20.setOnClickListener {
            insertItem(it as ImageView, 2, 0)
        }
        item21.setOnClickListener {
            insertItem(it as ImageView, 2, 1)
        }
        item22.setOnClickListener {
            insertItem(it as ImageView, 2, 2)
        }
    }

    private fun disableAllItem() {
        item00.isEnabled = false
        item01.isEnabled = false
        item02.isEnabled = false
        item10.isEnabled = false
        item11.isEnabled = false
        item12.isEnabled = false
        item20.isEnabled = false
        item21.isEnabled = false
        item22.isEnabled = false
    }

}