package company.petrifaction.client.ui.ssjc.activity.presenter;

import company.petrifaction.client.bean.BaseReturnData;
import company.petrifaction.client.bean.ssjc.JcDetailInfo;
import company.petrifaction.client.ui.base.BaseMvp_Presenter;
import company.petrifaction.client.ui.base.BaseMvp_EntranceOfModel;
import company.petrifaction.client.ui.base.BaseMvp_LocalObjCallBack;
import company.petrifaction.client.ui.ssjc.activity.model.SsjcDetailModel;
import company.petrifaction.client.ui.ssjc.activity.view_v.SsjcDetailAct_V;

public class SsjcDetailPresenter extends BaseMvp_Presenter<SsjcDetailAct_V>
{
    public SsjcDetailPresenter()
    {

    }

    public void getDatas(String alarmId)
    {
        if(isAttachContextAndViewLayer())
        {
            BaseMvp_EntranceOfModel.requestDatas(SsjcDetailModel.class).
            putForm("id",alarmId).convertForms().executeOfNet(getContext(),SsjcDetailModel.RequestSsjcDetailDatas,new BaseMvp_LocalObjCallBack<BaseReturnData<JcDetailInfo>>(this)
            {
                public void onSuccess(BaseReturnData<JcDetailInfo> jcDetailInfo)
                {
                    if(isAttachContextAndViewLayer())
                    {
                        getViewLayer().successOfGetDatas(jcDetailInfo.getData());
                    }
                }

                public void onFailure(String msg)
                {
                    super.onFailure(msg);
                    if(isAttachContextAndViewLayer())
                    {
                        getViewLayer().failOfGetDatas();
                    }
                }

                public void onError(String msg)
                {
                    super.onError(msg);
                    if(isAttachContextAndViewLayer())
                    {
                        getViewLayer().failOfGetDatas();
                    }
                }
            });
        }
    }
}