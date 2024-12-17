package com.example.loveappmvp.ui.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.loveappmvp.view.fragments.OnBoardPagerFragment
import com.example.loveappmvp.view.fragments.OnBoardPagerFragment.Companion.ARG_ONBOARD_POSITION

class OnBoardAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int)= OnBoardPagerFragment().apply {
        arguments = Bundle().apply {
            putInt(ARG_ONBOARD_POSITION, position)
        }
    }
}