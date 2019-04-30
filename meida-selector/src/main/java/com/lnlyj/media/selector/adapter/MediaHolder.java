package com.lnlyj.media.selector.adapter;

import android.media.MediaMetadataRetriever;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.lnlyj.media.selector.R;
import com.lnlyj.media.selector.bean.MediaInfo;

import static com.bumptech.glide.load.resource.bitmap.VideoDecoder.FRAME_OPTION;

/**
 * Created by Wanglei on 2019/4/30.
 */

public class MediaHolder extends RecyclerView.ViewHolder {

    private ImageView img;
    private ImageView check;

    private RequestOptions options;

    public MediaHolder(View itemView) {
        super(itemView);

        img = itemView.findViewById(R.id.iv_img);
        check = itemView.findViewById(R.id.iv_check);

        options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .set(FRAME_OPTION, MediaMetadataRetriever.OPTION_CLOSEST)
                .placeholder(R.mipmap.ic_empty);
    }

    public void bindView(MediaInfo info, boolean select, final MediaAdapter.OnItemClickListener listener) {

        check.setActivated(select);

        Glide.with(img).load(info.getPath()).apply(options).into(img);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(getAdapterPosition());
                }
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onCheckClick(getAdapterPosition());
                }
            }
        });
    }
}
