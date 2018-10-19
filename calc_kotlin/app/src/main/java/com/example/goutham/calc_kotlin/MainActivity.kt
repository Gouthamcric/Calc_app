package com.example.goutham.calc_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.sin

class MainActivity : AppCompatActivity() {
var flag=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        one.setOnClickListener{ append_exp("1",true,false)}
        two.setOnClickListener{ append_exp("2",true,false)}
        three.setOnClickListener{ append_exp("3",true,false)}
        four.setOnClickListener{ append_exp("4",true,false)}
        five.setOnClickListener{ append_exp("5",true,false)}
        six.setOnClickListener{ append_exp("6",true,false)}
        seven.setOnClickListener{ append_exp("7",true,false)}
        eight.setOnClickListener{ append_exp("8",true,false)}
        nine.setOnClickListener{ append_exp("9",true,false)}
        plus.setOnClickListener{ append_exp("+",true,true)}
        minus.setOnClickListener{ append_exp("-",true,true)}
        mul.setOnClickListener{ append_exp("*",true,true)}
        divide.setOnClickListener{ append_exp("/",true,true)}
        ce.setOnClickListener {
            expr.text = ""
            result.text = ""
        }
        sin.setOnClickListener{
var st=expr.text.toString()
            var v= sin(st.toDouble())
            expr.text=v.toString()
        }
            back.setOnClickListener{
                val str=expr.text.toString()
                expr.text=str.substring(0,str.length-1)
            }
        equal.setOnClickListener{
        try{
        val expression=ExpressionBuilder(expr.text.toString()).build()
        var res= expression.evaluate()
        expr.text=(res.toString())
        result.text=""
        }catch(e:Exception){}
        }

    }

    fun append_exp(text:String,clear:Boolean,isbool:Boolean)
    {
        expr.append(text)
            try{
                val expression=ExpressionBuilder(expr.text.toString()).build()
                var res= expression.evaluate()
                result.text=(res.toString())
            }catch(e:Exception){}



    }
}

