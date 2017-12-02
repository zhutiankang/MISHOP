package com.northlight.latte.ec.main.sort.content;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.northlight.latte.delegates.LatteDelegate;
import com.northlight.latte.ec.R;
import com.northlight.latte.ec.R2;
import com.northlight.latte.net.RestClient;
import com.northlight.latte.net.callback.ISuccess;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * author : 祝天康
 * tips   :
 * date   : 2017/10/27 15:10
 */

public class ContentListDelegate extends LatteDelegate{

    @BindView(R2.id.rv_content_list)
    RecyclerView mRecyclerView = null;
    private static final String ARG_CONTENT_ID = "CONTENT_ID";
    private int mContentId = -1;

    public static ContentListDelegate newInstance(int contentId){
        final Bundle args = new Bundle();
        args.putInt(ARG_CONTENT_ID,contentId);
        final ContentListDelegate delegate = new ContentListDelegate();
        delegate.setArguments(args);
        return delegate;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle args = getArguments();
        if (args != null){
            mContentId = args.getInt(ARG_CONTENT_ID);
        }
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_content_list;
    }

    @Override
    public void onBinderView(@Nullable Bundle savedInstanceState, View rootView) {
        final StaggeredGridLayoutManager manager =
                new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        initData();
    }

    //不用看界面一次性就可以写好
    //为了讲课已经写了无数遍了，快写吐了，体谅一下，一次性就能写好
    //不要认为很吊的人，只是写了很多遍而已
    private void initData(){
        RestClient.builder()
                .url("sort_content_list.php?contentId=" + mContentId)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final ArrayList<SectionBean> data =
                                new SectionDataConverter().setJsonData(response).convert();
                        final SectionAdapter sectionAdapter =
                                new SectionAdapter(R.layout.item_section_content,
                                        R.layout.item_section_header, data);
                        mRecyclerView.setAdapter(sectionAdapter);
                    }
                })
                .build()
                .get();
    }
}
