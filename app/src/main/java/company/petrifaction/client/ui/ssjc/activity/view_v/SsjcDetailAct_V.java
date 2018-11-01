package company.petrifaction.client.ui.ssjc.activity.view_v;

import company.petrifaction.client.ui.base.BaseMvp_View;
import company.petrifaction.client.bean.ssjc.JcDetailInfo;

public interface SsjcDetailAct_V extends BaseMvp_View
{
    public void failOfGetDatas();
    public void successOfGetDatas(JcDetailInfo jcDetailInfo);
}
