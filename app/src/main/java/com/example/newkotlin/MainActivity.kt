package com.example.newkotlin

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Collections.list
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list1 : MutableList<Button> = ArrayList()
        list1.add(findViewById<Button>(R.id.b1))
        list1.add(findViewById<Button>(R.id.b2))
        list1.add(findViewById<Button>(R.id.b3))
        list1.add(findViewById<Button>(R.id.b4))
        list1.add(findViewById<Button>(R.id.b5))
        list1.add(findViewById<Button>(R.id.b6))
        list1.add(findViewById<Button>(R.id.b7))
        list1.add(findViewById<Button>(R.id.b8))
        list1.add(findViewById<Button>(R.id.b9))
        list1.add(findViewById<Button>(R.id.b10))
        list1.add(findViewById<Button>(R.id.p1))
        list1.add(findViewById<Button>(R.id.p2))
        list1.add(findViewById<Button>(R.id.p3))
        list1.add(findViewById<Button>(R.id.p4))
        list1.add(findViewById<Button>(R.id.p5))
        list1.add(findViewById<Button>(R.id.q1))
        list1.add(findViewById<Button>(R.id.q2))
        list1.add(findViewById<Button>(R.id.q3))
        list1.add(findViewById<Button>(R.id.q4))
        list1.add(findViewById<Button>(R.id.q5))
        @SuppressLint("SetTextI18n")
        fun Main(list3: List<Int>){
            list1[10].setBackgroundColor(Color.BLACK)
            list1[11].setBackgroundColor(Color.BLACK)
            list1[12].setBackgroundColor(Color.BLACK)
            list1[13].setBackgroundColor(Color.BLACK)
            list1[14].setBackgroundColor(Color.BLACK)
            list1[15].setBackgroundColor(Color.BLACK)
            list1[16].setBackgroundColor(Color.BLACK)
            list1[17].setBackgroundColor(Color.BLACK)
            list1[18].setBackgroundColor(Color.BLACK)
            list1[19].setBackgroundColor(Color.BLACK)
            list1[10].text = ""
            list1[11].text = ""
            list1[12].text = ""
            list1[13].text = ""
            list1[14].text = ""
            list1[15].text = ""
            list1[16].text = ""
            list1[17].text = ""
            list1[18].text = ""
            list1[19].text = ""
            val list2: MutableList<Int> = ArrayList();
                for (i in 0..9) {
                    val randominteger = Random.nextInt(1, 100)
                    list2.add(i, randominteger);
                    list1[i].text = randominteger.toString();
                }
            val list3: MutableList<TextView> = ArrayList();
            list3.add(findViewById<TextView>(R.id.a1))
            list3.add(findViewById<TextView>(R.id.a2))
            list3.add(findViewById<TextView>(R.id.a3))
            list3.add(findViewById<TextView>(R.id.a4))
            list3.add(findViewById<TextView>(R.id.a5))
            list2.shuffle();
            list3[0].text = (list2[0] + list2[1].toInt()).toString();
            list3[1].text = (list2[2] - list2[3]).toString();
            list3[2].text = (list2[4] * list2[5]).toString();
            if(list2[7]>list2[6]){
                var t= list2[7]
                list2[7]= list2[6]
                list2[6] = t
                list3[3].text = (list2[6] / list2[7]).toDouble().toString();
            }else{
                list3[3].text = (list2[6] / list2[7]).toDouble().toString();
            }

            list3[4].text = (list2[8] + list2[9]).toString();

        var temp = ""
        fun buttonClick(view: View){

            with(view as Button) {
                Log.d("TAG", "$text, $id")
            }
            view.setOnClickListener {
                if ((temp == "") && (view.text != "")) {
                    temp = view.text.toString()
                    view.text = ""
                    view.setBackgroundColor(Color.BLACK)
                } else if ((view.text == "") && (temp != "")) {
                    view.text = temp
                    temp = ""
                    view.setBackgroundColor(Color.GRAY)

                }
            }

        }
                for (i in list1){
            i.setOnClickListener(::buttonClick)
        }
        var mark = 0;
        var lives = 3
        fun checking(){
//            var a= 0;
//            for (i in 10..19){
//                if (list1[i].text ==""){
//                    a += 1;
//                }
//            }
//            if (a>0){
//                Toast.makeText(this@MainActivity, "Fill all the answers", Toast.LENGTH_SHORT).show()
//            }

            if (list1[10].text.toString().toInt()+ list1[15].text.toString().toInt() == list3[0].text.toString().toInt()) {
                mark += 1
            }
            if (list1[11].text.toString().toInt() - list1[16].text.toString().toInt() == list3[1].text.toString().toInt()) {
                mark += 1
            }
            if (list1[12].text.toString().toInt() * list1[17].text.toString().toInt() == list3[2].text.toString().toInt()) {
                mark+= 1
            }
            if (list1[13].text.toString().toInt() / list1[18].text.toString().toInt() == list3[3].text.toString().toInt()) {
                mark+= 1
            }
            if (list1[14].text.toString().toInt() + list1[19].text.toString().toInt() == list3[4].text.toString().toInt()) {
                mark+= 1
            }
        }
            var t1 = findViewById<TextView>(R.id.t1)

            t1.text="Lives : $lives"

        var sub = findViewById<Button>(R.id.sub)
            sub.setOnClickListener{
                checking();
                if(mark == 5){
                    Main(list3 as List<Int>)
                    Toast.makeText(this@MainActivity, "made no mistake!", Toast.LENGTH_SHORT).show()
                }
                else if(lives>0){
                    lives = lives - 1;
                    Main(list3 as List<Int>)
                    t1.text = "Lives: $lives"
                    Toast.makeText(this@MainActivity, "Ops you lost a life! Lives remaining is $lives, Highscore is $mark", Toast.LENGTH_SHORT).show()
                    mark = 0;
                }
                else{
                    Toast.makeText(this@MainActivity, "No more lives to play", Toast.LENGTH_SHORT).show()
                    Main( listOf())
                }
            }
        }
        Main(listOf());
        }
}






















