package id.indosw.liquidswipesample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import id.indosw.liquidswipe_lib.LiquidPager;
import id.indosw.liquidswipesample.adapter.AdapterJava;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LiquidPager pager = findViewById(R.id.pager);
        pager.setAdapter(new AdapterJava(getSupportFragmentManager()));
    }
}