package com.lnlyj.selector.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lnlyj.media.selector.MediaSelector;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaSelector.init(this)
                .openGallery()
                .selector();
    }
}
