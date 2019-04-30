package com.lnlyj.media.selector.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.lnlyj.media.selector.R;
import com.lnlyj.media.selector.bean.MediaInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wanglei on 2019/4/30.
 */

public class MediaAdapter extends RecyclerView.Adapter<MediaHolder> {

    private Context context;
    private List<MediaInfo> medias = new ArrayList<>();
    private List<MediaInfo> selects = new ArrayList<>();

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
        void onCheckClick(int position);
    }

    public MediaAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MediaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MediaHolder(View.inflate(context, R.layout.item_media, null));
    }

    @Override
    public void onBindViewHolder(MediaHolder holder, int position) {
        holder.bindView(getMediaInfo(position), isSelect(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return medias.size();
    }

    public void swapResult(List<MediaInfo> result) {
        medias.clear();
        if (result != null && result.size() != 0) {
            medias.addAll(result);
        }
        notifyDataSetChanged();
    }

    public List<MediaInfo> getSelections() {
        return selects;
    }

    public boolean isSelect(int position) {
        MediaInfo info = getMediaInfo(position);
        return selects.contains(info);
    }

    public void toggleSelect(int position) {
        MediaInfo info = getMediaInfo(position);

        if (selects.contains(info)) {
            selects.remove(info);
        } else {
            selects.add(info);
        }
    }

    public MediaInfo getMediaInfo(int position) {
        return medias.get(position);
    }

    public int getSelectCount() {
        return selects.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
