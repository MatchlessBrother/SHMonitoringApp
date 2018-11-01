package company.petrifaction.client.ui.main.fragment.view_v;

import company.petrifaction.client.ui.base.BaseMvp_View;
import company.petrifaction.client.bean.lsbj.BjHistroyPageInfo;
import company.petrifaction.client.bean.lsbj.BjHistroyCondition;

public interface MainBjHistroyFrag_V extends BaseMvp_View
{
    void finishRefresh();
    void finishLoadMore();
    void refreshDatas(BjHistroyPageInfo bjHistroyPageInfo);
    void loadMoreDatas(BjHistroyPageInfo bjHistroyPageInfo);
    void getSuccessOfCondition(BjHistroyCondition bjHistroyCondition,boolean isNeedDrawableLayout);
}