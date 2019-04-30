package com.lnlyj.media.selector;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.lnlyj.media.selector.bean.MediaInfo;
import com.lnlyj.media.selector.config.Config;
import com.lnlyj.media.selector.config.MediaConfig;

import java.util.List;

import static com.lnlyj.media.selector.config.Config.EXTRA_DATA_CONFIG;
import static com.lnlyj.media.selector.config.Config.REQUEST_SELECTOR;

/**
 * Created by Wanglei on 2019/4/30.
 */

public class MediaSelectionHelper {

    private MediaConfig mediaConfig;
    private MediaSelector selector;

    public MediaSelectionHelper(MediaSelector selector) {
        this(selector, Config.MEDIA_TYPE_PHOTO);
    }

    public MediaSelectionHelper(MediaSelector selector, int mediaType) {
        this.selector = selector;
        mediaConfig = MediaConfig.getInstance();
        mediaConfig.mediaType = mediaType;
    }

    public MediaSelectionHelper mediaType(int mediaType) {
        mediaConfig.mediaType = mediaType;
        return this;
    }

    public MediaSelectionHelper minCount(int minCount) {
        mediaConfig.minCount = minCount;
        return this;
    }

    public MediaSelectionHelper maxCount(int maxCount) {
        mediaConfig.maxCount = maxCount;
        return this;
    }

    public MediaSelectionHelper spanCount(int spanCount) {
        mediaConfig.spanCount = spanCount;
        return this;
    }

    public MediaSelectionHelper selects(List<MediaInfo> selects) {
        mediaConfig.selects = selects;
        return this;
    }

    public void selector() {
        Fragment fragment = selector.getFragment();

        Intent intent = new Intent("com.lnlyj.media.MEDIA_SELECTOR");
        intent.putExtra(EXTRA_DATA_CONFIG, mediaConfig);

        if (fragment != null) {
            fragment.startActivityForResult(intent, REQUEST_SELECTOR);
        } else {
            selector.getActivity().startActivityForResult(intent, REQUEST_SELECTOR);
        }
    }
}
