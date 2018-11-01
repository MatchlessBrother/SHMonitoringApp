package company.petrifaction.client.ui.main.fragment.view_v;

import company.petrifaction.client.bean.hztj.TjDataInfo;
import company.petrifaction.client.ui.base.BaseMvp_View;
import company.petrifaction.client.bean.hztj.TjCondition;

public interface MainHzFrag_V extends BaseMvp_View
{
    void getFailureOfDatas();
    void getSuccessOfDatas(TjDataInfo tjDataInfo);
    void getSuccessOfConditions(TjCondition tjCondition,boolean isNeedDrawableLayout);
}