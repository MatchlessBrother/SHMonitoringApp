package company.petrifaction.client.ui.bjcz.activity.view;

import android.net.Uri;
import android.view.View;
import java.util.ArrayList;
import com.google.gson.Gson;
import android.webkit.WebView;
import android.content.Intent;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.view.LayoutInflater;
import android.webkit.WebViewClient;
import company.petrifaction.client.R;
import android.support.v7.widget.RecyclerView;
import company.petrifaction.client.base.BaseAct;
import android.support.v7.widget.GridLayoutManager;
import android.support.v4.widget.SwipeRefreshLayout;
import company.petrifaction.client.widget.EchartView;
import android.support.v7.widget.LinearLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import company.petrifaction.client.bean.bjcz.BjczDetailInfo;
import company.petrifaction.client.adapter.bjcz.GlspAdapter;
import company.petrifaction.client.adapter.bjcz.BjczDetailImgAdapter;
import company.petrifaction.client.ui.bjcz.activity.view_v.BjczDetailAct_V;
import company.petrifaction.client.ui.bjcz.activity.presenter.BjczDetailPresenter;

public class BjczDetailAct extends BaseAct implements BjczDetailAct_V,View.OnClickListener
{
    private String mAlarmId;
    private String mBaseImgPath;
    private boolean mIsProcessed;
    private TextView mBjczdetailCzr;
    private TextView mBjczdetailFzr;
    private TextView mBjczdetailSsz;
    private TextView mBjczdetailBjz;
    private GlspAdapter mGlspAdapter;
    private TextView mBjczdetailName;
    private TextView mBjczdetailArea;
    private TextView mBjczdetailType;
    private TextView mBjczdetailLsgj;
    private TextView mBjczdetailLxgj;
    private TextView mBjczdetailLxdh;
    private TextView mBjczdetailBgdh;
    private TextView mBjczdetailSjtx;
    private TextView mBjczdetailCzsm;
    private TextView mBjczdetailSskbh;
    private TextView mBjczdetailCzrlxdh;
    private TextView mBjczdetailCzrbgdh;
    private RecyclerView mBjczdetailGlsp;
    private RecyclerView mBjczdetailCztp;
    private TextView mBjczdetailPosition;
    private EchartView mBjczdetailLsbjqxt;
    private TextView mBjczdetailDepartment;
    private LinearLayout mBjczdetailKeyvalue;
    private BjczDetailPresenter mBjczDetailPresenter;
    private BjczDetailImgAdapter mBjczDetailImgAdapter;
    private SwipeRefreshLayout mBjczdetailSwiperefreshlayout;
    /*******************************************************/
    private View mBjczdetailCzrLine;
    private LinearLayout mBjczdetailCzrAll;
    private View mBjczdetailCzrlxdhLine;
    private LinearLayout mBjczdetailCzrlxdhAll;
    private View mBjczdetailCzrbgdhLine;
    private LinearLayout mBjczdetailCzrbgdhAll;
    private View mBjczdetailCzsmLine;
    private LinearLayout mBjczdetailCzsmAll;
    private View mBjczdetailCztpLine;
    private LinearLayout mBjczdetailCztpAll;
    /*******************************************************/

    protected int setLayoutResID()
    {
        return R.layout.activity_bjczdetail;
    }

    protected void initWidgets(View rootView)
    {
        super.initWidgets(rootView);
        setTitleContent("详情");
        mAlarmId = getIntent().getStringExtra("alarmid");
        mBaseImgPath = "http://git.yunfanwulian.com:20001";
        mIsProcessed = getIntent().getBooleanExtra("isprocessed",false);
        mBjczdetailCzr = (TextView) rootView.findViewById(R.id.bjczdetail_czr);
        mBjczdetailBjz = (TextView) rootView.findViewById(R.id.bjczdetail_bjz);
        mBjczdetailSsz = (TextView) rootView.findViewById(R.id.bjczdetail_ssz);
        mBjczdetailFzr = (TextView) rootView.findViewById(R.id.bjczdetail_fzr);
        mBjczdetailName = (TextView) rootView.findViewById(R.id.bjczdetail_name);
        mBjczdetailArea = (TextView) rootView.findViewById(R.id.bjczdetail_area);
        mBjczdetailType = (TextView) rootView.findViewById(R.id.bjczdetail_type);
        mBjczdetailLsgj = (TextView) rootView.findViewById(R.id.bjczdetail_lsgj);
        mBjczdetailLxgj = (TextView) rootView.findViewById(R.id.bjczdetail_lxgj);
        mBjczdetailLxdh = (TextView) rootView.findViewById(R.id.bjczdetail_lxdh);
        mBjczdetailBgdh = (TextView) rootView.findViewById(R.id.bjczdetail_bgdh);
        mBjczdetailSjtx = (TextView) rootView.findViewById(R.id.bjczdetail_sjtx);
        mBjczdetailCzsm = (TextView) rootView.findViewById(R.id.bjczdetail_czsm);
        mBjczdetailSskbh = (TextView) rootView.findViewById(R.id.bjczdetail_sskbh);
        mBjczdetailGlsp = (RecyclerView) rootView.findViewById(R.id.bjczdetail_glsp);
        mBjczdetailCztp = (RecyclerView) rootView.findViewById(R.id.bjczdetail_cztp);
        mBjczdetailCzrlxdh = (TextView) rootView.findViewById(R.id.bjczdetail_czrlxdh);
        mBjczdetailCzrbgdh = (TextView) rootView.findViewById(R.id.bjczdetail_czrbgdh);
        mBjczdetailPosition = (TextView) rootView.findViewById(R.id.bjczdetail_position);
        mBjczdetailLsbjqxt = (EchartView) rootView.findViewById(R.id.bjczdetail_lsbjqxt);
        mBjczdetailKeyvalue = (LinearLayout) rootView.findViewById(R.id.bjczdetail_keyvalue);
        mBjczdetailDepartment = (TextView)  rootView.findViewById(R.id.bjczdetail_department);
        mBjczdetailSwiperefreshlayout = (SwipeRefreshLayout) rootView.findViewById(R.id.bjczdetail_swiperefreshlayout);
        mGlspAdapter = new GlspAdapter(this,new ArrayList<BjczDetailInfo.CamerasBean>());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mBjczdetailGlsp.setLayoutManager(linearLayoutManager);
        mBjczdetailGlsp.setAdapter(mGlspAdapter);
        /******************************************************************************************/
        mBjczdetailCzrLine = (View)rootView.findViewById(R.id.bjczdetail_czr_line);
        mBjczdetailCzrAll = (LinearLayout)rootView.findViewById(R.id.bjczdetail_czr_all);
        mBjczdetailCzrlxdhLine = (View)rootView.findViewById(R.id.bjczdetail_czrlxdh_line);
        mBjczdetailCzrlxdhAll = (LinearLayout)rootView.findViewById(R.id.bjczdetail_czrlxdh_all);
        mBjczdetailCzrbgdhLine = (View)rootView.findViewById(R.id.bjczdetail_czrbgdh_line);
        mBjczdetailCzrbgdhAll = (LinearLayout)rootView.findViewById(R.id.bjczdetail_czrbgdh_all);
        mBjczdetailCzsmLine = (View)rootView.findViewById(R.id.bjczdetail_czsm_line);
        mBjczdetailCzsmAll = (LinearLayout)rootView.findViewById(R.id.bjczdetail_czsm_all);
        mBjczdetailCztpLine = (View)rootView.findViewById(R.id.bjczdetail_cztp_line);
        mBjczdetailCztpAll = (LinearLayout)rootView.findViewById(R.id.bjczdetail_cztp_all);
        /******************************************************************************************/
        mBjczDetailImgAdapter =  new BjczDetailImgAdapter(this,new ArrayList<BjczDetailInfo.HandleImagesBean>());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mActivity,3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mBjczdetailCztp.setLayoutManager(gridLayoutManager);
        mBjczdetailCztp.setAdapter(mBjczDetailImgAdapter);
        mBjczdetailCztp.setNestedScrollingEnabled(false);
        mBjczdetailCztp.setFocusableInTouchMode(false);
    }

    protected void initDatas()
    {
        mBjczDetailPresenter = new BjczDetailPresenter();
        bindBaseMvpPresenter(mBjczDetailPresenter);
        mBjczdetailSwiperefreshlayout.setEnabled(true);
        mBjczdetailSwiperefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            public void onRefresh()
            {
                mBjczDetailPresenter.getDatas(mAlarmId);
            }
        });

        mGlspAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener()
        {
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position)
            {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse(null != mGlspAdapter.getData().get(position).getAccessUrl() ? mGlspAdapter.getData().get(position).getAccessUrl().trim() : "");
                intent.setData(content_url);
                if(getPackageManager().queryIntentActivities(intent,0).size() > 0)
                    startActivity(intent);
                else
                    showToast("未找到可以播放该视频的浏览器");
            }
        });

        mBjczDetailImgAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener()
        {
            public void onItemClick(BaseQuickAdapter adapter, View view, int position)
            {
                Intent intent = new Intent(BjczDetailAct.this,BjczPreviewPhotoAct.class);
                intent.putExtra("imgPath",mBaseImgPath + mBjczDetailImgAdapter.getData().get(position).getImageUrl().trim());
                startActivity(intent);
            }
        });
    }

    protected void initLogic()
    {
        mBjczDetailPresenter.getDatas(mAlarmId);
        if(mIsProcessed)//已处置
        {
            mBjczdetailCzrLine.setVisibility(View.VISIBLE);
            mBjczdetailCzrAll.setVisibility(View.VISIBLE);
            mBjczdetailCzrlxdhLine.setVisibility(View.VISIBLE);
            mBjczdetailCzrlxdhAll.setVisibility(View.VISIBLE);
            mBjczdetailCzrbgdhLine.setVisibility(View.VISIBLE);
            mBjczdetailCzrbgdhAll.setVisibility(View.VISIBLE);
            mBjczdetailCzsmLine.setVisibility(View.VISIBLE);
            mBjczdetailCzsmAll.setVisibility(View.VISIBLE);
            mBjczdetailCztpLine.setVisibility(View.VISIBLE);
            mBjczdetailCztpAll.setVisibility(View.VISIBLE);
        }
        else//未处置
        {
            mBjczdetailCzrLine.setVisibility(View.GONE);
            mBjczdetailCzrAll.setVisibility(View.GONE);
            mBjczdetailCzrlxdhLine.setVisibility(View.GONE);
            mBjczdetailCzrlxdhAll.setVisibility(View.GONE);
            mBjczdetailCzrbgdhLine.setVisibility(View.GONE);
            mBjczdetailCzrbgdhAll.setVisibility(View.GONE);
            mBjczdetailCzsmLine.setVisibility(View.GONE);
            mBjczdetailCzsmAll.setVisibility(View.GONE);
            mBjczdetailCztpLine.setVisibility(View.GONE);
            mBjczdetailCztpAll.setVisibility(View.GONE);
        }
    }

    public void failOfGetDatas()
    {

    }

    public void successOfGetDatas(final BjczDetailInfo bjczDetailInfo)
    {
        mBjczdetailSwiperefreshlayout.setRefreshing(false);
        mBjczdetailName.setText(null != bjczDetailInfo.getSensorName() ? bjczDetailInfo.getSensorName().trim() : "");
        mBjczdetailLxgj.setText(null != bjczDetailInfo.getAlarmNumber() ? bjczDetailInfo.getAlarmNumber().trim() : "");
        String ssz = "";
        if(null != bjczDetailInfo.getRealtimeData() && bjczDetailInfo.getRealtimeData().trim().indexOf(".") > 0)
        {
            ssz = bjczDetailInfo.getRealtimeData().trim();
            ssz = ssz.replaceAll("0+?$", "");
            ssz = ssz.replaceAll("[.]$", "");
        }
        mBjczdetailSsz.setText(!"".equals(ssz.trim()) ? ssz + (null != bjczDetailInfo.getUnit() ? bjczDetailInfo.getUnit().trim() : ""): (null != bjczDetailInfo.getRealtimeData() ? bjczDetailInfo.getRealtimeData().trim() + (null != bjczDetailInfo.getUnit() ? bjczDetailInfo.getUnit().trim() : "") : ""));
        String bjz = "";
        if(null != bjczDetailInfo.getAlarmValue() && bjczDetailInfo.getAlarmValue().trim().indexOf(".") > 0)
        {
            bjz = bjczDetailInfo.getAlarmValue().trim();
            bjz = bjz.replaceAll("0+?$", "");
            bjz = bjz.replaceAll("[.]$", "");
        }
        mBjczdetailBjz.setText(!"".equals(bjz.trim()) ? bjz + (null != bjczDetailInfo.getUnit() ? bjczDetailInfo.getUnit().trim() : "") : (null != bjczDetailInfo.getAlarmValue() ? bjczDetailInfo.getAlarmValue().trim() + (null != bjczDetailInfo.getUnit() ? bjczDetailInfo.getUnit().trim() : "") : ""));
        mBjczdetailArea.setText(null != bjczDetailInfo.getDeviceAreaName() ? bjczDetailInfo.getDeviceAreaName().trim() : "");
        mBjczdetailLsgj.setText(null != bjczDetailInfo.getAlarmTotalNumber() ? bjczDetailInfo.getAlarmTotalNumber().trim() : "");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(null != bjczDetailInfo.getParentCategoryName() ? bjczDetailInfo.getParentCategoryName().trim(): "");
        //stringBuffer.append(null != bjczDetailInfo.getMedium() && !"".equals( bjczDetailInfo.getMedium().trim()) ? "-" + bjczDetailInfo.getMedium().trim(): "");
        mBjczdetailType.setText(stringBuffer.toString());
        mBjczdetailCzsm.setText(null != bjczDetailInfo.getHandleDescription() ? bjczDetailInfo.getHandleDescription().trim() : "");
        mBjczdetailSskbh.setText(null != bjczDetailInfo.getRealtimeDbPositionId() ? bjczDetailInfo.getRealtimeDbPositionId().trim() : "");
        mBjczdetailPosition.setText(null != bjczDetailInfo.getAddress() ? bjczDetailInfo.getAddress().trim() : "");
        mBjczdetailDepartment.setText(null != bjczDetailInfo.getDepartmentName() ? bjczDetailInfo.getDepartmentName().trim() : "");
        mBjczdetailFzr.setText(null != bjczDetailInfo.getPeopleName() ? bjczDetailInfo.getPeopleName().trim() : "");
        mBjczdetailLxdh.setText(null != bjczDetailInfo.getTelephone() ? bjczDetailInfo.getTelephone().trim() : "");
        mBjczdetailBgdh.setText(null != bjczDetailInfo.getPeopleWorkTelephone() ? bjczDetailInfo.getPeopleWorkTelephone().trim() : "");
        mBjczdetailCzr.setText(null != bjczDetailInfo.getHandlePeopleName() ? bjczDetailInfo.getHandlePeopleName().trim() : "");
        mBjczdetailCzrlxdh.setText(null != bjczDetailInfo.getHandlePeopleTelephone() ? bjczDetailInfo.getHandlePeopleTelephone().trim() : "");
        mBjczdetailCzrbgdh.setText(null != bjczDetailInfo.getHandlePeopleWorkTelephone() ? bjczDetailInfo.getHandlePeopleWorkTelephone().trim() : "");
        mBjczdetailSjtx.setText(null != bjczDetailInfo.getDataSyncStatusDescription() ? bjczDetailInfo.getDataSyncStatusDescription().trim() : "");
        mBjczdetailSjtx.setTextColor((null != bjczDetailInfo.getDataSyncStatus() && "1".equals(bjczDetailInfo.getDataSyncStatus().trim())) ? Color.argb(255,0,153,0) : Color.argb(255,255,0,0));
        /******************************************************************************************/
        mBjczdetailKeyvalue.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(this);
        for(int index = 0;index < bjczDetailInfo.getSettings().size();index++)
        {
           View view = inflater.inflate(R.layout.item_bjczdetail,null);
           TextView key = (TextView)view.findViewById(R.id.bjczdetail_key);
           TextView value = (TextView)view.findViewById(R.id.bjczdetail_value);
           key.setText(null != bjczDetailInfo.getSettings().get(index).getLevelName() ? bjczDetailInfo.getSettings().get(index).getLevelName().trim() : "");
           value.setText(null != bjczDetailInfo.getSettings().get(index).getRuleDescription() ? bjczDetailInfo.getSettings().get(index).getRuleDescription().trim() : "");
           mBjczdetailKeyvalue.addView(view);
        }
        /******************************************************************************************/
        mGlspAdapter.setNewData(null != bjczDetailInfo.getCameras() ? bjczDetailInfo.getCameras() : new ArrayList<BjczDetailInfo.CamerasBean>());
        /******************************************************************************************/
        mBjczDetailImgAdapter.setNewData(null != bjczDetailInfo.getHandleImages() ? bjczDetailInfo.getHandleImages() : new ArrayList<BjczDetailInfo.HandleImagesBean>());
        /******************************************************************************************/
        mBjczdetailLsbjqxt.loadUrl("file:///android_asset/detail.html");
        if(null != mBjczdetailLsbjqxt)
        {
            mBjczdetailLsbjqxt.setWebViewClient(new WebViewClient()
            {
                public void onPageFinished(WebView view, String url)
                {
                    super.onPageFinished(view, url);
                    mBjczdetailLsbjqxt.refreshEchartsViewWithDataJson(new Gson().toJson(bjczDetailInfo));
                }
            });
        }
    }
}