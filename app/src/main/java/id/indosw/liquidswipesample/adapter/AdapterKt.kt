package id.indosw.liquidswipesample.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.indosw.liquidswipesample.fragment.PageFragmentKt

class AdapterKt(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val total: Int = 6
    private val data : ArrayList<PageFragmentKt> = ArrayList(total)

    init {
        for (i in 0 until total) {
            val fragment = PageFragmentKt()
            val bundle = Bundle()
            bundle.putInt("POSITION", i+1)
            fragment.arguments = bundle
            data.add(fragment)
        }
    }


    override fun getItem(position: Int): Fragment {
        return data[position]
    }

    override fun getCount(): Int {
        return total
    }
}
