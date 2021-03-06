package company.petrifaction.client.ui.main.fragment.model;

import android.content.Context;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;
import company.petrifaction.client.network.NetClient;
import company.petrifaction.client.ui.base.BaseMvp_PVModel;
import company.petrifaction.client.ui.base.BaseMvp_NetObjCallBack;
import company.petrifaction.client.ui.base.BaseMvp_LocalObjCallBack;

public class MainHzModel extends BaseMvp_PVModel
{
    public static final int RequestHztjDatas = 0x0001;
    public static final int RequestHztjCondtions = 0x0002;

    public void executeOfNet(Context context, int netRequestCode, BaseMvp_LocalObjCallBack localCallBack)
    {
        localCallBack.onStart();
        switch(netRequestCode)
        {
            case RequestHztjDatas:NetClient.getInstance(context).getNetUrl().requestHztjDatas(getMultipartForms()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new BaseMvp_NetObjCallBack(context,localCallBack));break;
            case RequestHztjCondtions:NetClient.getInstance(context).getNetUrl().requestHztjConditions().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new BaseMvp_NetObjCallBack(context,localCallBack));break;
        }
    }

    public void executeOfLocal(Context context, int localRequestCode, BaseMvp_LocalObjCallBack localCallBack)
    {
        localCallBack.onStart();
        localCallBack.onFinish();
    }
}