package com.mypackage.lineview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    static int currentX=0,currentY=0;
    private LineView mLineView ;

    public static PointF pointA = new PointF(0,0);

    public static PointF pointB = new PointF(0,500);

    public static PointF pointC = new PointF(300,250);





    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mLineView.chk=0;


        setContentView(R.layout.activity_main);

        mLineView = (LineView) findViewById(R.id.lineView);

        mLineView.setPointA(pointA);

        mLineView.setPointB(pointB);

        mLineView.setPointC(pointC);

        mLineView.draw();



        mLineView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int action= motionEvent.getAction();
                switch(action & MotionEvent.ACTION_MASK)
                {
                    case MotionEvent.ACTION_DOWN:
                    {
                        setCurrentX((int)motionEvent.getX());
                        setCurrentY((int)motionEvent.getY());
                        if((currentX>=pointA.x-10 && currentX<=pointA.x+10) && (currentY>=pointA.y-10 && currentY<=pointA.y+10))
                        {
                            pointA.x=currentX;
                            pointA.y=currentY;
                            mLineView.draw();
                        }
                        else if(currentX==pointB.x && currentY==pointB.y)
                        {
                            pointB.x=currentX;
                            pointB.y=currentY;
                            mLineView.draw();
                        }
                        else if(currentX==pointC.x && currentY==pointC.y)
                        {
                            pointC.x=currentX;
                            pointC.y=currentY;
                            mLineView.draw();
                        }
                        break;
                    }
                    case MotionEvent.ACTION_MOVE:
                    {
                        setCurrentX((int)motionEvent.getX());
                        setCurrentY((int)motionEvent.getY());
                        if((currentX>=pointA.x-50 && currentX<=pointA.x+50) && (currentY>=pointA.y-50 && currentY<=pointA.y+50))
                        {
                            pointA.x=currentX;
                            pointA.y=currentY;
                            mLineView.draw();
                        }
                        else if((currentX>=pointB.x-50 && currentX<=pointB.x+50) && (currentY>=pointB.y-50 && currentY<=pointB.y+50))
                        {
                            pointB.x=currentX;
                            pointB.y=currentY;
                            mLineView.draw();
                        }
                        else if((currentX>=pointC.x-50 && currentX<=pointC.x+50) && (currentY>=pointC.y-50 && currentY<=pointC.y+50))
                        {
                            pointC.x=currentX;
                            pointC.y=currentY;
                            mLineView.draw();
                        }
                        break;
                    }
                }
                return true;
            }
        });

    }
    static void setCurrentX(int x)
    {
        currentX=x;
    }
    static void setCurrentY(int y)
    {
        currentY=y;
    }
}
