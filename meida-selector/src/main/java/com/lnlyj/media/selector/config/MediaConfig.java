package com.lnlyj.media.selector.config;

import android.os.Parcel;
import android.os.Parcelable;

import com.lnlyj.media.selector.bean.MediaInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wanglei on 2019/4/30.
 */

public class MediaConfig implements Parcelable {

    public int spanCount = Config.DEFAULT_COLUMN_COUNT;
    public int minCount = Config.DEFAULT_MIN_SELECT_COUNT;
    public int maxCount = Config.DEFAULT_MAX_SELECT_COUNT;
    public int mediaType = Config.MEDIA_TYPE_ALL;

    public List<MediaInfo> selects;

    private MediaConfig() {

    }

    protected MediaConfig(Parcel in) {
        spanCount = in.readInt();
        minCount = in.readInt();
        maxCount = in.readInt();
        mediaType = in.readInt();
    }

    public static final Creator<MediaConfig> CREATOR = new Creator<MediaConfig>() {
        @Override
        public MediaConfig createFromParcel(Parcel in) {
            return new MediaConfig(in);
        }

        @Override
        public MediaConfig[] newArray(int size) {
            return new MediaConfig[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(spanCount);
        dest.writeInt(minCount);
        dest.writeInt(maxCount);
        dest.writeInt(mediaType);
    }

    public void reset() {
        spanCount = Config.DEFAULT_COLUMN_COUNT;
        minCount = Config.DEFAULT_MIN_SELECT_COUNT;
        maxCount = Config.DEFAULT_MAX_SELECT_COUNT;
        mediaType = Config.MEDIA_TYPE_ALL;
        selects = new ArrayList<>();
    }

    public static MediaConfig getInstance() {
        MediaConfig instance = InnerDefaultConfig.CONFIG;
        instance.reset();
        return instance;
    }


    private static final class InnerDefaultConfig {
        public static final MediaConfig CONFIG = new MediaConfig();
    }
}
