package com.livedata_sample.yellow.model

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MedalViewModel : ViewModel() {

    var numberOfGoldMedal: MutableLiveData<Int> = MutableLiveData()
    var numberOfSilverMedal: MutableLiveData<Int> = MutableLiveData()
    var numberOfBronzeMedal: MutableLiveData<Int> = MutableLiveData()

    init {
        numberOfGoldMedal.value = 0
        numberOfSilverMedal.value = 0
        numberOfBronzeMedal.value = 0
    }
}