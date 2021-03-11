package com.example.writingproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class ActionType() {
    PLUS, MINUS
}

class MyNumberViewModel : ViewModel() {

    //내부에서 설정하는 자료형 뮤텨블
    private val _currenValue = MutableLiveData<Int>()

    val currenValue: LiveData<Int>
        get() = _currenValue

    init {
        _currenValue.value = 0
    }

    fun updateValue(actionType: ActionType,input:Int){
        when(actionType){
            ActionType.PLUS->
                _currenValue.value=_currenValue.value?.plus(input)
            ActionType.MINUS->
                _currenValue.value= _currenValue.value?.minus(input)
        }
    }
}