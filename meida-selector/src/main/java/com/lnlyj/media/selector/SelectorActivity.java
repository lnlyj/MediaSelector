package com.lnlyj.media.selector;

import android.support.v4.content.CursorLoader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lnlyj.media.selector.adapter.MediaAdapter;
import com.lnlyj.media.selector.config.Config;
import com.lnlyj.media.selector.config.MediaConfig;
import com.lnlyj.media.selector.widget.EmptyRecyclerView;

public class SelectorActivity extends AppCompatActivity implements MediaAdapter.OnItemClickListener {

    private EmptyRecyclerView recyclerView;
    private MediaAdapter adapter;

    private MediaConfig config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);

        config = getIntent().getParcelableExtra(Config.EXTRA_DATA_CONFIG);

        if (config == null) {
            config = MediaConfig.getInstance();
        }

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setEmptyView(findViewById(R.id.empty));

        GridLayoutManager layoutManager = new GridLayoutManager(this, config.spanCount);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter = new MediaAdapter(this));
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onCheckClick(int position) {

    }


}
