package company.petrifaction.client.ui.bjcz.activity.view;

import android.view.View;
import company.petrifaction.client.R;
import com.github.chrisbanes.photoview.PhotoView;
import company.petrifaction.client.base.BaseAct;

public class BjczPreviewPhotoAct extends BaseAct
{
    private PhotoView mBjczPreviewPhotoView;

    protected int setLayoutResID()
    {
        return R.layout.activity_bjczpreviewphoto;
    }

    protected void initWidgets(View rootView)
    {
        super.initWidgets(rootView);
        setTitleContent("查看图片");
        mBjczPreviewPhotoView = (PhotoView)findViewById(R.id.bjczpreviewphoto_photoview);
    }

    protected void initDatas()
    {
        if(null != getIntent().getStringExtra("imgPath") && !"".equals(getIntent().getStringExtra("imgPath").trim()))
            useGlideLoadImg(mBjczPreviewPhotoView,getIntent().getStringExtra("imgPath"));
        else
            mBjczPreviewPhotoView.setVisibility(View.GONE);
    }

    protected void initLogic()
    {

    }
}