package com.lnlyj.media.selector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lnlyj.media.selector.adapter.MediaAdapter;
import com.lnlyj.media.selector.bean.MediaInfo;
import com.lnlyj.media.selector.config.Config;
import com.lnlyj.media.selector.config.MediaConfig;

import java.util.ArrayList;
import java.util.List;

public class SelectorActivity extends AppCompatActivity implements MediaAdapter.MediaAdapterDelegate {

    private MediaConfig config;
    private List<MediaInfo> selects = new ArrayList<>();

    private SelectorFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);

        config = getIntent().getParcelableExtra(Config.EXTRA_DATA_CONFIG);

        if (config == null) {
            config = MediaConfig.getInstance();
        }

        if (savedInstanceState != null) {
            fragment = (SelectorFragment) getSupportFragmentManager().findFragmentByTag("SelectorFragment");
        }

        if (fragment == null) {
            fragment = new SelectorFragment();
            fragment.setArguments(getIntent().getExtras());
        }

        getSupportFragmentManager().beginTransaction().add(R.id.content, fragment, "SelectorFragment").show(fragment).commit();

    }

    @Override
    public boolean isSelect(MediaInfo info) {
        return selects.contains(info);
    }

    @Override
    public void toggleSelect(MediaInfo info) {
        if (selects.contains(info)) {
            selects.remove(info);
        } else {
            selects.add(info);
        }
    }

    @Override
    public int getSelectCount() {
        return selects.size();
    }
}
