package com.lnlyj.media.selector.bean;

/**
 * Created by Wanglei on 2019/4/30.
 */

public class MediaInfo {

    private String path;
    private String mimeType;
    private boolean select;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MediaInfo mediaInfo = (MediaInfo) o;

        return path.equals(mediaInfo.path);
    }

    @Override
    public int hashCode() {
        return path.hashCode();
    }
}
