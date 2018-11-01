package company.petrifaction.client.ui.main.fragment.view_v;

import java.util.List;
import company.petrifaction.client.bean.ssjc.JcDataInfo;
import company.petrifaction.client.ui.base.BaseMvp_View;
import company.petrifaction.client.bean.ssjc.JcCondition;

public interface MainJcFrag_V extends BaseMvp_View
{
    void getFailOfDataInfos();
    void getSuccessOfDataInfos(List<JcDataInfo> jcDataInfos);
    void getSuccessOfCondition(JcCondition jcCondition,boolean isNeedDrawableLayout);
}