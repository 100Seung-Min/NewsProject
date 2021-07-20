package com.example.newspaper

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newspaper.fragment.FirstFragment
import com.example.newspaper.fragment.SecFragment
import com.example.newspaper.fragment.ThirdFragment


class Adapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                FirstFragment()
            }
            1 -> {
                SecFragment()
            }
            2 -> {
                ThirdFragment()
            }
            else -> {
                Fragment()
            }
        }
    }
}