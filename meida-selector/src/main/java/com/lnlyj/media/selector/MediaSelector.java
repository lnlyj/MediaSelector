package com.lnlyj.media.selector;

import android.app.Activity;
import android.support.v4.app.Fragment;

import java.lang.ref.WeakReference;

/**
 * Created by Wanglei on 2019/4/30.
 */

public class MediaSelector {
    
    WeakReference<Activity> activity;
    WeakReference<Fragment> fragment;

    private MediaSelector(Activity activity) {
        this.activity = new WeakReference<Activity>(activity);
    }

    private MediaSelector(Fragment fragment) {
        this.fragment = new WeakReference<Fragment>(fragment);
    }

    public static MediaSelector init(Activity activity) {
        return new MediaSelector(activity);
    }

    public static MediaSelector init(Fragment fragment) {
        return new MediaSelector(fragment);
    }

    public MediaSelectionHelper openGallery() {
        return new MediaSelectionHelper(this);
    }

    Activity getActivity() {
        return activity != null ? activity.get() : null;
    }

    Fragment getFragment() {
        return fragment != null ? fragment.get() : null;
    }
}
