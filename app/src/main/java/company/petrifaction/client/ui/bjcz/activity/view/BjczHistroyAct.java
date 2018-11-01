package company.petrifaction.client.ui.bjcz.activity.view;

import android.view.View;
import java.util.ArrayList;
import android.content.Intent;
import company.petrifaction.client.R;
import android.support.v7.widget.RecyclerView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import company.petrifaction.client.base.BaseAct;
import company.petrifaction.client.bean.bjcz.BjczHistroyPageInfo;
import company.petrifaction.client.adapter.bjcz.BjczHistroyAdapter;
import company.petrifaction.client.ui.bjcz.activity.view_v.BjczHistroyAct_V;
import company.petrifaction.client.ui.bjcz.activity.presenter.BjczHistroyPresenter;

public class BjczHistroyAct extends BaseAct implements BjczHistroyAct_V,View.OnClickListener
{
    private RecyclerView mBjczHistroyRecycler;
    private BjczHistroyAdapter mBjczHistroyAdapter;
    private BjczHistroyPresenter mBjczHistroyPresenter;
    private SwipeRefreshLayout mBjczHistroySwiperefreshlayout;

    protected int setLayoutResID()
    {
        return R.layout.activity_bjczhistroy;
    }

    protected void initWidgets(View rootView)
    {
        super.initWidgets(rootView);
        setTitleContent("报警处置历史");
        mBjczHistroySwiperefreshlayout = (SwipeRefreshLayout)rootView.findViewById(R.id.bjczhistroy_swiperefreshlayout);
        mBjczHistroyAdapter = new BjczHistroyAdapter(mActivity,new ArrayList<BjczHistroyPageInfo.ContentBean>());
        mBjczHistroyRecycler = (RecyclerView)rootView.findViewById(R.id.bjczhistroy_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mBjczHistroyRecycler.setLayoutManager(linearLayoutManager);
        mBjczHistroyRecycler.setAdapter(mBjczHistroyAdapter);
        mBjczHistroySwiperefreshlayout.setEnabled(true);
        mBjczHistroyAdapter.setEnableLoadMore(true);
    }

    protected void initDatas()
    {
        mBjczHistroyPresenter = new BjczHistroyPresenter();
        bindBaseMvpPresenter(mBjczHistroyPresenter);
    }

    protected void initLogic()
    {
        mBjczHistroyPresenter.refreshDatas();
        mBjczHistroySwiperefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            public void onRefresh()
            {
                mBjczHistroyPresenter.refreshDatas();
            }
        });

        mBjczHistroyAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener()
        {
            public void onLoadMoreRequested()
            {
                mBjczHistroyPresenter.loadMoreDatas();
            }
        },mBjczHistroyRecycler);

        mBjczHistroyAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener()
        {
            public void onItemClick(BaseQuickAdapter adapter, View view, int position)
            {
                Intent intent = new Intent(BjczHistroyAct.this,BjczDetailAct.class);
                intent.putExtra("alarmid",String.valueOf(mBjczHistroyAdapter.getData().get(position).getId()));
                startActivity(intent);
            }
        });
    }

    public void finishRefresh()
    {
        mBjczHistroySwiperefreshlayout.setRefreshing(false);

    }

    public void finishLoadMore()
    {
        mBjczHistroyAdapter.loadMoreComplete();

    }

    public void onClick(View view)
    {
        super.onClick(view);
        switch(view.getId())
        {

        }
    }

    public void refreshDatas(BjczHistroyPageInfo bjczHistroyPageInfo)
    {
        mBjczHistroyAdapter.setNewData(bjczHistroyPageInfo.getContent());
        if(bjczHistroyPageInfo.getContent().size() < bjczHistroyPageInfo.getPageSize())
            mBjczHistroyAdapter.setEnableLoadMore(false);
        else
            mBjczHistroyAdapter.setEnableLoadMore(true);
    }

    public void loadMoreDatas(BjczHistroyPageInfo bjczHistroyPageInfo)
    {
        mBjczHistroyAdapter.addData(bjczHistroyPageInfo.getContent());
        mBjczHistroyAdapter.notifyDataSetChanged();
        if(bjczHistroyPageInfo.getContent().size() < bjczHistroyPageInfo.getPageSize())
            mBjczHistroyAdapter.setEnableLoadMore(false);
        else
            mBjczHistroyAdapter.setEnableLoadMore(true);
    }
}