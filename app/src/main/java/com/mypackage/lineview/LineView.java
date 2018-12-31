package com.mypackage.lineview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class LineView extends View
{
    public static int chk=0;
    private Paint paint = new Paint();

    private PointF pointA, pointB,pointC;

    public LineView(Context context) {
        super(context);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        paint.setColor(Color.BLACK);

        paint.setStrokeWidth(10);
        if(chk==0)
        {
            chk=1;
            pointA.set((float)canvas.getWidth()/2,0.3f*canvas.getHeight());
            pointB.set(0.1f*canvas.getWidth(),0.7f*canvas.getHeight());
            pointC.set(0.9f*canvas.getWidth(),0.7f*canvas.getHeight());
            MainActivity.pointA.set(this.pointA);
            MainActivity.pointB.set(this.pointB);
            MainActivity.pointC.set(this.pointC);
        }

        canvas.drawLine(pointA.x,pointA.y,pointB.x,pointB.y,paint);
        canvas.drawLine(pointB.x,pointB.y,pointC.x,pointC.y,paint);
        canvas.drawLine(pointC.x,pointC.y,pointA.x,pointA.y,paint);
        super.onDraw(canvas);



    }

    public void setPointA(PointF point)
    {
        pointA = point ;
    }

    public void setPointB(PointF point)
    {
        pointB = point ;
    }

    public void setPointC(PointF point)
    {
        pointC=point;
    }

    public void draw()
    {
        invalidate();
        requestLayout();
    }

}
