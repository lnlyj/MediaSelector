package com.lnlyj.media.selector;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lnlyj.media.selector.adapter.MediaAdapter;
import com.lnlyj.media.selector.bean.MediaInfo;
import com.lnlyj.media.selector.config.MediaConfig;
import com.lnlyj.media.selector.widget.EmptyRecyclerView;

import java.util.List;

import static com.lnlyj.media.selector.config.Config.EXTRA_DATA_CONFIG;

/**
 * Created by Wanglei on 2019/4/30.
 */

public class SelectorFragment extends Fragment implements MediaAdapter.OnItemClickListener  {

    private View rootView;
    private EmptyRecyclerView recyclerView;
    private MediaAdapter adapter;

    private MediaConfig config;

    private SelectorActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (SelectorActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_selector, null);

        config = getArguments().getParcelable(EXTRA_DATA_CONFIG);

        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setEmptyView(rootView.findViewById(R.id.empty));

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), config.spanCount);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter = new MediaAdapter(getActivity()));
        adapter.setOnItemClickListener(this);
        adapter.setDelegate(activity);
        return rootView;
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onCheckClick(int position) {
        adapter.toggleSelect(position);
    }

    public void swapResult(List<MediaInfo> list) {
        adapter.swapResult(list);
    }

}
