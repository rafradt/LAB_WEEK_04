package com.example.lab_week_04

import androidx.viewpager2.adapter.FragmentStateAdapter

val TABS_FIXED = listOf(
    R.string.starbucks_title,
    R.string.janjijiwa_title,
    R.string.kopikenangan_title,
    Pair(R.string.starbucks_title, R.string.starbucks_desc),
    Pair(R.string.janjijiwa_title, R.string.janjijiwa_desc),
    Pair(R.string.kopikenangan_title, R.string.kopikenangan_desc),
)

class CafeAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return TABS_FIXED.size
    }
    override fun createFragment(position: Int): Fragment
    {
        return CafeDetailFragment()
        override fun getItemCount(): Int = TABS_FIXED.size

        override fun createFragment(position: Int): Fragment {
            val (titleRes, descRes) = TABS_FIXED[position]
            return CafeDetailFragment.newInstance(
                titleRes,
                descRes
            )
        }
    }
}