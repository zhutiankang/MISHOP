package com.northlight.latte.ec.main.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.joanzapata.iconify.widget.IconTextView;
import com.northlight.latte.delegates.bottom.BottomItemDelegate;
import com.northlight.latte.ec.R;
import com.northlight.latte.ec.R2;
import com.northlight.latte.net.RestClient;
import com.northlight.latte.net.callback.ISuccess;
import com.northlight.latte.ui.recycler.MultipleFields;
import com.northlight.latte.ui.recycler.MultipleItemEntity;
import com.northlight.latte.ui.refresh.RefreshHandler;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/10/13 15:36
 */

public class IndexDelegate extends BottomItemDelegate {


    @BindView(R2.id.rv_index)
    RecyclerView mRecyclerView = null;
    @BindView(R2.id.srl_index)
    SwipeRefreshLayout mRefreshLayout = null;
    @BindView(R2.id.icon_index_scan)
    IconTextView mIconScan = null;
    @BindView(R2.id.et_search_view)
    AppCompatEditText mSearchView = null;
    @BindView(R2.id.tb_index)
    Toolbar mToolbar = null;

    private RefreshHandler mRefreshHandler = null;
    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBinderView(@Nullable Bundle savedInstanceState, View rootView) {
        mRefreshHandler = new RefreshHandler(mRefreshLayout);
        RestClient.builder()
                .url("index.php")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final IndexDataConverter dataConverter = new IndexDataConverter();
                        dataConverter.setJsonData(response);
                        final ArrayList<MultipleItemEntity> entities = dataConverter.convert();
                        final String text = entities.get(2).getField(MultipleFields.TEXT);
                        Toast.makeText(getActivity(),text,Toast.LENGTH_SHORT).show();
                    }
                })
                .build()
                .get();
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initRefreshLayout();
//        mRefreshHandler.firstPage("index.php");
//        initRecyclerView();
    }

    private void initRecyclerView() {
//        final GridLayoutManager manager = new GridLayoutManager(getContext(),4);
//        mRecyclerView.setLayoutManager(manager);
//        mRecyclerView.addItemDecoration();
    }

    private void initRefreshLayout() {

        mRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
        );
        mRefreshLayout.setProgressViewOffset(true,120,300);
    }
}
