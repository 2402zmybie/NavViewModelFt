package com.hr.navviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    var number:MutableLiveData<Int> = MutableLiveData()
    init {
        number.value = 0
    }

    fun add(x:Int) {
       number.value = number.value!! + x
        if(number.value!! < 0) {
            number.value = 0
        }
    }
}