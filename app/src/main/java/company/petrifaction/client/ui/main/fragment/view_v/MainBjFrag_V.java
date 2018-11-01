package company.petrifaction.client.ui.main.fragment.view_v;

import company.petrifaction.client.ui.base.BaseMvp_View;
import company.petrifaction.client.bean.bjcz.BjczPageInfo;

public interface MainBjFrag_V extends BaseMvp_View
{
    void finishRefresh();
    void finishLoadMore();
    void refreshDatas(BjczPageInfo bjczPageInfo);
    void loadMoreDatas(BjczPageInfo bjczPageInfo);
}