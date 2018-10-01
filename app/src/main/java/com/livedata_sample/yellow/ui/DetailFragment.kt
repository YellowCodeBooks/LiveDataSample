package com.livedata_sample.yellow.ui


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.livedata_sample.yellow.R
import com.livedata_sample.yellow.model.MedalViewModel
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    lateinit var mMedalViewModel: MedalViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var root = inflater.inflate(R.layout.fragment_detail, container, false)

        mMedalViewModel = ViewModelProviders.of(activity!!).get(MedalViewModel::class.java)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mMedalViewModel.numberOfGoldMedal.observe(activity!!, Observer<Int> { displayMedal() })
        mMedalViewModel.numberOfSilverMedal.observe(activity!!, Observer<Int> { displayMedal() })
        mMedalViewModel.numberOfBronzeMedal.observe(activity!!, Observer<Int> { displayMedal() })
    }

    fun displayMedal() {
        tvDetailGoldNumber.text = activity?.getString(R.string.number_of_gold_label, mMedalViewModel?.numberOfGoldMedal?.value)
        tvDetailSilverNumber.text = activity?.getString(R.string.number_of_silver_label, mMedalViewModel?.numberOfSilverMedal?.value)
        tvDetailBronzeNumber.text = activity?.getString(R.string.number_of_bronze_label, mMedalViewModel?.numberOfBronzeMedal?.value)
    }
}
