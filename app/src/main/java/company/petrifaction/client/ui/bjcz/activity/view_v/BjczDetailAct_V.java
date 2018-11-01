package company.petrifaction.client.ui.bjcz.activity.view_v;

import company.petrifaction.client.ui.base.BaseMvp_View;
import company.petrifaction.client.bean.bjcz.BjczDetailInfo;

public interface BjczDetailAct_V extends BaseMvp_View
{
    public void failOfGetDatas();
    public void successOfGetDatas(BjczDetailInfo bjczDetailInfo);
}