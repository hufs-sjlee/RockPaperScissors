package com.leesj.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var Scissors:ImageView
    lateinit var Rock:ImageView
    lateinit var Paper:ImageView
    lateinit var Computer:ImageView
    lateinit var Result:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Scissors=findViewById(R.id.scissors)
        Rock=findViewById(R.id.rock)
        Paper=findViewById(R.id.paper)
        Computer=findViewById(R.id.computer)
        Result=findViewById(R.id.result)
        Scissors.setOnClickListener(){
            Game(1,"가위")
        }
        Rock.setOnClickListener(){
            Game(2,"바위")
        }
        Paper.setOnClickListener(){
            Game(3,"보")
        }
    }

    private fun Game(num:Int,Str:String){
        var ran = Random.nextInt(3)+1
        var ResultText:String
        var ComputerImage = when(ran)
        {
            1->R.drawable.scissors
            2->R.drawable.rock
            else->R.drawable.paper
        }
        if(ran==1) {
            ResultText = "가위"
        }else if(ran==2) {
            ResultText = "바위"
        }else{
            ResultText="보"
        }
        if(ran==num) {
            Result.text =""+Str+"vs"+ResultText+"\n비겼습니다"
        }else if((ran==1&&num==2)||(ran==2&&num==3)||(ran==3&&num==1)) {
            Result.text =""+Str+"vs"+ResultText+"\n이겼습니다"
        }else{
            Result.text =""+Str+"vs"+ResultText+"\n졌습니다"
        }
        Computer.setImageResource(ComputerImage)
    }
}