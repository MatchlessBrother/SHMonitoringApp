package company.petrifaction.client.adapter.bjcz;

import java.util.List;
import android.content.Context;
import company.petrifaction.client.R;
import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import company.petrifaction.client.bean.bjcz.BjczDetailInfo;

public class GlspAdapter extends BaseQuickAdapter<BjczDetailInfo.CamerasBean, BaseViewHolder>
{
    private Context mContext;

    public GlspAdapter(Context context,@Nullable List<BjczDetailInfo.CamerasBean> data)
    {
        super(R.layout.item_bjczdetailglsp,data);
        mContext = context;
    }

    protected void convert(BaseViewHolder helper,BjczDetailInfo.CamerasBean camerasBean)
    {
        helper.addOnClickListener(R.id.item_bjczdetailglsp_img);
        helper.setText(R.id.item_bjczdetailglsp_tv,null != camerasBean.getName() ? camerasBean.getName().trim() : "");
    }
}