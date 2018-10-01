package com.livedata_sample.yellow.ui


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.livedata_sample.yellow.R
import com.livedata_sample.yellow.model.MedalViewModel
import kotlinx.android.synthetic.main.fragment_control.*

class ControlFragment : Fragment(), View.OnClickListener {

    lateinit var mMedalViewModel: MedalViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_control, container, false)

        mMedalViewModel = ViewModelProviders.of(activity!!).get(MedalViewModel::class.java)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayMedal()

        btnGoldMinus.setOnClickListener(this)
        btnGoldPlus.setOnClickListener(this)
        btnSilverMinus.setOnClickListener(this)
        btnSilverPlus.setOnClickListener(this)
        btnBronzeMinus.setOnClickListener(this)
        btnBronzePlus.setOnClickListener(this)
    }

    fun displayMedal() {
        tvMainGoldNumber.text = mMedalViewModel?.numberOfGoldMedal?.value.toString()
        tvMainSilverNumber.text = mMedalViewModel?.numberOfSilverMedal.value.toString()
        tvMainBronzeNumber.text = mMedalViewModel?.numberOfBronzeMedal.value.toString()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            btnGoldMinus.id -> {
                mMedalViewModel?.numberOfGoldMedal.value = mMedalViewModel?.numberOfGoldMedal?.value?.minus(1)
                displayMedal()
            }
            btnGoldPlus.id -> {
                mMedalViewModel?.numberOfGoldMedal.value = mMedalViewModel?.numberOfGoldMedal?.value?.plus(1)
                displayMedal()
            }
            btnSilverMinus.id -> {
                mMedalViewModel?.numberOfSilverMedal.value = mMedalViewModel?.numberOfSilverMedal?.value?.minus(1)
                displayMedal()
            }
            btnSilverPlus.id -> {
                mMedalViewModel?.numberOfSilverMedal.value = mMedalViewModel?.numberOfSilverMedal?.value?.plus(1)
                displayMedal()
            }
            btnBronzeMinus.id -> {
                mMedalViewModel?.numberOfBronzeMedal.value = mMedalViewModel?.numberOfBronzeMedal?.value?.minus(1)
                displayMedal()
            }
            btnBronzePlus.id -> {
                mMedalViewModel?.numberOfBronzeMedal.value = mMedalViewModel?.numberOfBronzeMedal?.value?.plus(1)
                displayMedal()
            }
        }
    }
}
