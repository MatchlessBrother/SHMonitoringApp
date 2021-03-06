package company.petrifaction.client.ui.main.activity.view;

import android.view.View;
import android.view.Gravity;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import company.petrifaction.client.R;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import company.petrifaction.client.base.BaseAct;
import android.support.v4.app.FragmentPagerAdapter;
import com.yuan.devlibrary._12_______Utils.SharepreferenceUtils;
import company.petrifaction.client.ui.main.fragment.view.MainBjFrag;
import company.petrifaction.client.ui.main.fragment.view.MainHzFrag;
import company.petrifaction.client.ui.main.fragment.view.MainJcFrag;
import company.petrifaction.client.ui.main.activity.view_v.MainAct_V;
import company.petrifaction.client.ui.main.activity.view_v.SignInAct_V;
import company.petrifaction.client.ui.main.fragment.view.MainBjHistroyFrag;
import company.petrifaction.client.ui.main.activity.presenter.MainPresenter;
import company.petrifaction.client.ui.main.activity.presenter.SignInPresenter;

public class MainAct extends BaseAct implements MainAct_V,SignInAct_V,View.OnClickListener
{
    private TabHost mTabHost;
    private ViewPager mViewPager;
    private MainPresenter mMainPresenter;
    private DrawerLayout mMainDrawerlayout;
    private SignInPresenter mSignInPresenter;
    private LinearLayout mMainhzfragConditions;
    private LinearLayout mMainjcfragConditions;
    private LinearLayout mMainbjhistroyfragConditions;
    private String mTabSpecTv[] = new String[]{ "汇总统计", "实时监测","报警处置","历史报警"};
    private Fragment[] mTabSpecFrag = new Fragment[]{new MainHzFrag(),new MainJcFrag(),new MainBjFrag(),new MainBjHistroyFrag()};
    private int[] mTabSpecImg= new int[]{ R.drawable.selector_tabspec_hz, R.drawable.selector_tabspec_jc,R.drawable.selector_tabspec_bj,R.drawable.selector_tabspec_bjhistroy};

    protected int setLayoutResID()
    {
        return R.layout.activity_main;
    }

    public View getRootView()
    {
        return mRootView;
    }

    protected void initWidgets(View rootView)
    {
        super.initWidgets(rootView);
        mTabHost = (TabHost)rootView.findViewById(R.id.main_tabhost);
        mViewPager = (ViewPager)rootView.findViewById(R.id.main_viewpager);
        mMainDrawerlayout = (DrawerLayout)rootView.findViewById(R.id.main_drawerlayout);
        mMainhzfragConditions = (LinearLayout)rootView.findViewById(R.id.mainhzfrag_conditions);
        mMainjcfragConditions = (LinearLayout)rootView.findViewById(R.id.mainjcfrag_conditions);
        mMainbjhistroyfragConditions = (LinearLayout)rootView.findViewById(R.id.mainbjhistroyfrag_conditions);
        /****************************************************************************************************/
        mTabHost.setup();
        mViewPager.setOffscreenPageLimit(4);
        mTabHost.getTabWidget().setDividerDrawable(null);
        mMainDrawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        for(int index = 0;index < mTabSpecTv.length;index++)
        {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTabSpecTv[index]).setIndicator(getTabSpecView(index)).setContent(android.R.id.tabcontent);
            mTabHost.addTab(tabSpec);
        }
    }

    private View getTabSpecView(int index)
    {
        View view = LayoutInflater.from(this).inflate(R.layout.item_tabspec,null);
        ImageView tabSpecImg = (ImageView)view.findViewById(R.id.item_bottomtab_img);
        TextView tabSpecTv = (TextView)view.findViewById(R.id.item_bottomtab_tv);
        tabSpecImg.setBackgroundResource(mTabSpecImg[index]);
        tabSpecTv.setText(mTabSpecTv[index]);
        return view;
    }

    protected void initDatas()
    {
        mMainPresenter = new MainPresenter();
        mSignInPresenter = new SignInPresenter();
        bindBaseMvpPresenter(mMainPresenter);
        bindBaseMvpPresenter(mSignInPresenter);
    }

    protected void initLogic()
    {
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager())
        {
            public Fragment getItem(int position)
            {
                return mTabSpecFrag[position];

            }

            public int getCount()
            {
                return mTabSpecFrag.length;

            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            public void onPageScrollStateChanged(int state)
            {

            }

            public void onPageSelected(int position)
            {
                mTabHost.setCurrentTab(position);

            }
        });

        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener()
        {
            public void onTabChanged(String tabId)
            {
                if(mTabHost.getCurrentTab() == 0)
                {
                    mMainhzfragConditions.setVisibility(View.VISIBLE);
                    mMainjcfragConditions.setVisibility(View.GONE);
                    mMainbjhistroyfragConditions.setVisibility(View.GONE);
                    mMainDrawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                }
                else if(mTabHost.getCurrentTab() == 1)
                {
                    mMainhzfragConditions.setVisibility(View.GONE);
                    mMainjcfragConditions.setVisibility(View.VISIBLE);
                    mMainbjhistroyfragConditions.setVisibility(View.GONE);
                    mMainDrawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                }
                else if(mTabHost.getCurrentTab() == 3)
                {
                    mMainhzfragConditions.setVisibility(View.GONE);
                    mMainjcfragConditions.setVisibility(View.GONE);
                    mMainbjhistroyfragConditions.setVisibility(View.VISIBLE);
                    mMainDrawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                }
                else
                {
                    mMainhzfragConditions.setVisibility(View.GONE);
                    mMainjcfragConditions.setVisibility(View.GONE);
                    mMainbjhistroyfragConditions.setVisibility(View.GONE);
                    mMainDrawerlayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                }mViewPager.setCurrentItem(mTabHost.getCurrentTab());
            }
        });
        if(!getIntent().getBooleanExtra("islogined",false))
            mSignInPresenter.signIn(SharepreferenceUtils.extractObject(this,"username",String.class).trim(),SharepreferenceUtils.extractObject(this,"password",String.class).trim());
    }

    public void onClick(View view)
    {
        super.onClick(view);
        switch(view.getId())
        {

        }
    }

    public void signInSuccess()
    {

    }

    public void signInFailure()
    {
        SignInAct.quitCrrentAccount(this,"账号发生异常，请重新登录！");

    }

    public void signOutAction()
    {
        mMainPresenter.signOut();

    }

    public void signOutSuccess()
    {
        SignInAct.quitCrrentAccount((BaseAct)mActivity,"退出登录成功！");

    }

    public void signOutFailure()
    {

    }

    public void onBackPressed()
    {
        if(null != mMainDrawerlayout && mMainDrawerlayout.isDrawerOpen(Gravity.END))
            mMainDrawerlayout.closeDrawers();
        else
            super.onBackPressed();
    }
}