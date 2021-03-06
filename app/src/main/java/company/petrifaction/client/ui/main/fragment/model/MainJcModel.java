package company.petrifaction.client.ui.main.fragment.model;

import android.content.Context;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;
import company.petrifaction.client.network.NetClient;
import company.petrifaction.client.ui.base.BaseMvp_PVModel;
import company.petrifaction.client.ui.base.BaseMvp_NetObjCallBack;
import company.petrifaction.client.ui.base.BaseMvp_NetListCallBack;
import company.petrifaction.client.ui.base.BaseMvp_LocalObjCallBack;
import company.petrifaction.client.ui.base.BaseMvp_LocalListCallBack;

public class MainJcModel extends BaseMvp_PVModel
{
    public static final int RequestDatasInfo = 0x0001;
    public static final int RequestDatasOfCondition = 0x0002;
    public static final int RequestDatasInfoWithProgress = 0x0003;

    public void executeOfNet(Context context, int netRequestCode, BaseMvp_LocalObjCallBack localCallBack)
    {
        switch(netRequestCode)
        {
            case RequestDatasOfCondition:NetClient.getInstance(context).getNetUrl().requestJcDatasOfCondition().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new BaseMvp_NetObjCallBack(context,localCallBack));break;
        }
    }

    public void executeOfNet(Context context, int netRequestCode, BaseMvp_LocalListCallBack localCallBack)
    {
        switch(netRequestCode)
        {
            case RequestDatasInfo:NetClient.getInstance(context).getNetUrl().requestJcDatasInfo(getMultipartForms()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new BaseMvp_NetListCallBack(context,localCallBack));break;
            case RequestDatasInfoWithProgress:localCallBack.onStart();NetClient.getInstance(context).getNetUrl().requestJcDatasInfo(getMultipartForms()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new BaseMvp_NetListCallBack(context,localCallBack));break;
        }
    }

    public void executeOfLocal(Context context, int localRequestCode, BaseMvp_LocalObjCallBack localCallBack)
    {
        localCallBack.onStart();
        localCallBack.onFinish();
    }
}