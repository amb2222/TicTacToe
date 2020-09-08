package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClick(view: View) {
        val buttonSelected = view as Button
        var cellID = 0
        when (buttonSelected.id) {
            R.id.button1 -> cellID = 1
            R.id.button2 -> cellID = 2
            R.id.button3 -> cellID = 3
            R.id.button4 -> cellID = 4
            R.id.button5 -> cellID = 5
            R.id.button6 -> cellID = 6
            R.id.button7 -> cellID = 7
            R.id.button8 -> cellID = 8
            R.id.button9 -> cellID = 9
        }
        //Toast.makeText(this,"Cell ID: " +cellID,Toast.LENGTH_SHORT).show()
        playGame(cellID, buttonSelected)
    }
    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var activePlayer=1

    private fun playGame(cellID:Int, buttonSelected:Button){
        if(activePlayer==1){
            buttonSelected.text = "X"
            buttonSelected.setBackgroundColor(Color.parseColor("#009193"))
            player1.add(cellID)
            activePlayer = 2
            AutoPlay()
        } else{
            buttonSelected.text = "O"
            buttonSelected.setBackgroundColor(Color.parseColor("#FF9300"))
            player2.add(cellID)
            activePlayer = 1
        }
        buttonSelected.isEnabled = false
        checkWinner()
    }

    private fun checkWinner() {
        var winner = -1
        //row1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }

        //row2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }

        //row3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }

        //col1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }

        //col2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }

        //col3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        //diagonls
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2
        }

        if(winner!=-1){
            if(winner==1){
                Toast.makeText(this,"Player1 won the game.", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Player2 won the game.", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun AutoPlay(){
        var empty = ArrayList<Int>()
        for(cellID in 1..9){
            if(!(player1.contains(cellID)|| player2.contains(cellID))){
                empty.add(cellID)
            }
        }
        var r = Random()
        val randIndex = r.nextInt(empty.size-0)
        val cellID = empty[randIndex]
        val buttonSelected:Button
        when(cellID){
            1 ->buttonSelected = button1
            2 ->buttonSelected = button2
            3 ->buttonSelected = button3
            4 ->buttonSelected = button4
            5 ->buttonSelected = button5
            6 ->buttonSelected = button6
            7 ->buttonSelected = button7
            8 ->buttonSelected = button8
            9 ->buttonSelected = button9
            else -> buttonSelected = button1
        }

        playGame(cellID,buttonSelected)
    }
}
