package company.petrifaction.client.ui.bjcz.activity.view_v;

import java.util.List;
import company.petrifaction.client.ui.base.BaseMvp_View;
import company.petrifaction.client.bean.bjcz.BjczUploadImgInfo;

public interface BjczAct_V extends BaseMvp_View
{
    void failOfUploadDatas();
    void failOfUploadImgDatas();
    void successOfUploadDatas();
    void successOfUploadImgDatas(List<BjczUploadImgInfo> bjczUploadImgInfos);
}