package company.petrifaction.client.adapter.ssjc;

import java.util.List;
import android.content.Context;
import android.support.annotation.Nullable;
import company.petrifaction.client.R;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import company.petrifaction.client.bean.ssjc.JcDetailInfo;

public class JcGlspAdapter extends BaseQuickAdapter<JcDetailInfo.CamerasBean, BaseViewHolder>
{
    private Context mContext;
    public JcGlspAdapter(Context context,@Nullable List<JcDetailInfo.CamerasBean> data)
    {
        super(R.layout.item_ssjcdetailglsp,data);
        mContext = context;
    }

    protected void convert(BaseViewHolder helper,JcDetailInfo.CamerasBean camerasBean)
    {
        helper.addOnClickListener(R.id.item_ssjcdetailglsp_img);
        helper.setText(R.id.item_ssjcdetailglsp_tv,null != camerasBean.getName() ? camerasBean.getName().trim() : "");
    }
}