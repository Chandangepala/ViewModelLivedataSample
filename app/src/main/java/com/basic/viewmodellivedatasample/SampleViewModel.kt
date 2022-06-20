package com.basic.viewmodellivedatasample

import android.util.MutableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SampleViewModel : ViewModel() {
    var number: Int = 0

    val currentCount: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val currentBoolean: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
}