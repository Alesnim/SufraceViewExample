package com.itschool.draw.sufraceviewexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;


class MySurface extends SurfaceView {
    Paint paint;
    Path path;
    SurfaceHolder mSurfaceHolder;


    public MySurface(Context context) {
        super(context);
        mSurfaceHolder = getHolder();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        paint.setColor(Color.GREEN);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            path = new Path();
            path.moveTo(event.getX(), event.getY());
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            path.lineTo(event.getX(), event.getY());
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            path.lineTo(event.getX(), event.getY());
        }


        if (path != null) {

            Canvas canvas = mSurfaceHolder.lockCanvas();
            canvas.drawPath(path, paint);
            mSurfaceHolder.unlockCanvasAndPost(canvas);
        }

        return true;
    }
}
