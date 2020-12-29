package com.example.writingproject

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var myNumberViewModel: MyNumberViewModel
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)
    //가져오고 싶은 뷰모델 클래스 넣어서 뷰모델 가져오기
        myNumberViewModel = ViewModelProvider(this).get(MyNumberViewModel::class.java)
        myNumberViewModel.currenValue.observe(this, Observer {
            number_textView.text = it.toString()

            //리스너 연결
            plus_btn.setOnClickListener(this)
            minus_button.setOnClickListener(this)
        })

    }

    //클릭
    override fun onClick(v: View?) {
        val userInput = userinput_edittext.text.toString().toInt()

        when (v) {
            plus_btn ->
                myNumberViewModel.updateValue(actionType = ActionType.PLUS, input = userInput)
            minus_button ->
                myNumberViewModel.updateValue(actionType = ActionType.MINUS, input = userInput)

        }
    }
}