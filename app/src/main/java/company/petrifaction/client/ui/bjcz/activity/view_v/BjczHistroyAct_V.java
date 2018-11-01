package company.petrifaction.client.ui.bjcz.activity.view_v;

import company.petrifaction.client.ui.base.BaseMvp_View;
import company.petrifaction.client.bean.bjcz.BjczHistroyPageInfo;

public interface BjczHistroyAct_V extends BaseMvp_View
{
    void finishRefresh();
    void finishLoadMore();
    void refreshDatas(BjczHistroyPageInfo bjczHistroyPageInfo);
    void loadMoreDatas(BjczHistroyPageInfo bjczHistroyPageInfo);
}