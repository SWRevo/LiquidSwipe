package id.indosw.liquidswipesample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.indosw.liquidswipe_lib.LiquidPager
import id.indosw.liquidswipesample.adapter.AdapterKt

class MainActivityKt : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager = findViewById<LiquidPager>(R.id.pager)
        pager.adapter = AdapterKt(supportFragmentManager)
    }
}