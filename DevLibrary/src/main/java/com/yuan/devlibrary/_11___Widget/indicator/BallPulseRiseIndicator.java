package com.yuan.devlibrary._11___Widget.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.PropertyValuesHolder;

public class BallPulseRiseIndicator extends BaseIndicatorController
{
    public void draw(Canvas canvas, Paint paint)
    {
        float radius=getWidth()/10;
        canvas.drawCircle(getWidth()/4,radius*2,radius,paint);
        canvas.drawCircle(getWidth()*3/4,radius*2,radius,paint);
        canvas.drawCircle(radius,getHeight()-2*radius,radius,paint);
        canvas.drawCircle(getWidth()/2,getHeight()-2*radius,radius,paint);
        canvas.drawCircle(getWidth()-radius,getHeight()-2*radius,radius,paint);
    }

    public void createAnimation()
    {
        PropertyValuesHolder rotation6=PropertyValuesHolder.ofFloat("rotationX", 0, 360);
        animator=ObjectAnimator.ofPropertyValuesHolder(getTarget(), rotation6);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(-1);
        animator.setDuration(1500);
        animator.start();
    }

    ObjectAnimator animator  = null;
    public void showView()
    {
        if(animator == null)
            createAnimation();
        getTarget().setVisibility(View.VISIBLE);
        animator.start();
    }

    public void hideViewInvisible()
    {
        if(animator == null)
            createAnimation();
        getTarget().setVisibility(View.INVISIBLE);
        animator.cancel();
    }

    public void hideViewGone()
    {
        if(animator == null)
            createAnimation();
        getTarget().setVisibility(View.GONE);
        animator.cancel();
    }
}
