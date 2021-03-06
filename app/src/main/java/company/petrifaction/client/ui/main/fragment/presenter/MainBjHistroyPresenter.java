package company.petrifaction.client.ui.main.fragment.presenter;

import java.util.Map;
import company.petrifaction.client.bean.BaseReturnData;
import company.petrifaction.client.ui.base.BaseMvp_Presenter;
import company.petrifaction.client.bean.lsbj.BjHistroyPageInfo;
import company.petrifaction.client.bean.lsbj.BjHistroyCondition;
import company.petrifaction.client.ui.base.BaseMvp_LocalObjCallBack;
import company.petrifaction.client.ui.base.BaseMvp_EntranceOfModel;
import company.petrifaction.client.ui.main.fragment.model.MainBjHistroyModel;
import company.petrifaction.client.ui.main.fragment.view_v.MainBjHistroyFrag_V;

public class MainBjHistroyPresenter extends BaseMvp_Presenter<MainBjHistroyFrag_V>
{
    private int currentPageOfIndex;
    private int currentPageOfMaxSize;

    public MainBjHistroyPresenter()
    {
        currentPageOfIndex = 0;
        currentPageOfMaxSize = 20;
    }

    public void refreshDatas(Map conditionsMap)
    {
        if(isAttachContextAndViewLayer())
        {
            currentPageOfIndex = 0;
            BaseMvp_EntranceOfModel.requestDatas(MainBjHistroyModel.class).
            putForm("pageIndex",currentPageOfIndex + "").putForm("pageSize",currentPageOfMaxSize + "").putForms(conditionsMap).convertForms().executeOfNet(getContext(),MainBjHistroyModel.RequestHistroyAlarmDatas,new BaseMvp_LocalObjCallBack<BaseReturnData<BjHistroyPageInfo>>(this)
            {
                public void onSuccess(BaseReturnData<BjHistroyPageInfo> bjHistroyPageInfo)
                {
                    if(isAttachContextAndViewLayer())
                    {
                        getViewLayer().finishRefresh();
                        currentPageOfIndex = currentPageOfMaxSize;
                        getViewLayer().refreshDatas(bjHistroyPageInfo.getData());
                    }
                }

                public void onFailure(String msg)
                {
                    super.onFailure(msg);
                    if(isAttachContextAndViewLayer())
                    {
                        getViewLayer().finishRefresh();
                    }
                }

                public void onError(String msg)
                {
                    super.onError(msg);
                    if(isAttachContextAndViewLayer())
                    {
                        getViewLayer().finishRefresh();
                    }
                }
            });
        }
    }

    public void loadMoreDatas(Map conditionsMap)
    {
        if(isAttachContextAndViewLayer())
        {
            BaseMvp_EntranceOfModel.requestDatas(MainBjHistroyModel.class).
            putForm("pageIndex",currentPageOfIndex + "").putForm("pageSize",currentPageOfMaxSize + "").putForms(conditionsMap).convertForms().executeOfNet(getContext(),MainBjHistroyModel.RequestHistroyAlarmDatas,new BaseMvp_LocalObjCallBack<BaseReturnData<BjHistroyPageInfo>>(this)
            {
                public void onSuccess(BaseReturnData<BjHistroyPageInfo> bjHistroyPageInfo)
                {
                    if(isAttachContextAndViewLayer())
                    {
                        getViewLayer().finishLoadMore();
                        currentPageOfIndex += currentPageOfMaxSize;
                        getViewLayer().loadMoreDatas(bjHistroyPageInfo.getData());
                    }
                }

                public void onFailure(String msg)
                {
                    super.onFailure(msg);
                    if(isAttachContextAndViewLayer())
                    {
                        getViewLayer().finishLoadMore();
                    }
                }

                public void onError(String msg)
                {
                    super.onError(msg);
                    if(isAttachContextAndViewLayer())
                    {
                        getViewLayer().finishLoadMore();
                    }
                }
            });
        }
    }

    public void getDatasOfCondition(final boolean isNeedDrawableLayout)
    {
        if(isAttachContextAndViewLayer())
        {
            BaseMvp_EntranceOfModel.requestDatas(MainBjHistroyModel.class).
            executeOfNet(getContext(),MainBjHistroyModel.RequestDatasOfCondition,new BaseMvp_LocalObjCallBack<BaseReturnData<BjHistroyCondition>>(this)
            {
                public void onSuccess(BaseReturnData<BjHistroyCondition> bjHistroyCondition)
                {
                    if(isAttachContextAndViewLayer())
                    {
                        getViewLayer().getSuccessOfCondition(bjHistroyCondition.getData(),isNeedDrawableLayout);
                    }
                }
            });
        }
    }
}