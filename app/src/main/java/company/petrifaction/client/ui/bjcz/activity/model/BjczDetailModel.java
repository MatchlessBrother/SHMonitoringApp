package company.petrifaction.client.ui.bjcz.activity.model;

import android.content.Context;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;
import company.petrifaction.client.network.NetClient;
import company.petrifaction.client.ui.base.BaseMvp_PVModel;
import company.petrifaction.client.ui.base.BaseMvp_NetObjCallBack;
import company.petrifaction.client.ui.base.BaseMvp_LocalObjCallBack;

public class BjczDetailModel extends BaseMvp_PVModel
{
    public static final int RequestAlarmDetailDatas = 0x0001;

    public void executeOfNet(Context context, int netRequestCode, BaseMvp_LocalObjCallBack localCallBack)
    {
        localCallBack.onStart();
        switch(netRequestCode)
        {
            case RequestAlarmDetailDatas:
                NetClient.getInstance(context).getNetUrl().requestAlarmDetailDatas(getMultipartForms()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new BaseMvp_NetObjCallBack(context,localCallBack));break;
        }
    }

    public void executeOfLocal(Context context, int localRequestCode, BaseMvp_LocalObjCallBack localCallBack)
    {
        localCallBack.onStart();
        localCallBack.onFinish();
    }
}