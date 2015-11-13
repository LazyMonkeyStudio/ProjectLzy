package com.lazymonkeystudio.engine;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

/**
 * Created by Will on 11/11/2015.
 */
public class Engine_GamePanel extends GamePanel {
    private DebugGUI debug_gui;
    int bg_count = 1;

    public Engine_GamePanel(Context context, int targetFPS)
    {
        super(context, targetFPS);
        thread.setGamePanel(this);
        //background = new Background_Scrolling(image); //pull image from drawable folder
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        background = new Background(this, BitmapFactory.decodeResource(getResources(), R.drawable.background));
        super.surfaceCreated(holder);
        debug_gui = new DebugGUI();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        super.surfaceDestroyed(holder);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch (bg_count)
        {
            case 0:
                background = new Background(this, BitmapFactory.decodeResource(getResources(), R.drawable.background));
                bg_count = 1;
                break;
            case 1:
                background = new Background_Scrolling(this, BitmapFactory.decodeResource(getResources(), R.drawable.background));
                bg_count = 2;
                break;
            case 2:
                background = new Background_World(this, BitmapFactory.decodeResource(getResources(), R.drawable.background), 8196, 1536);
                bg_count = 0;
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void  update()
    {
        super.update();
        debug_gui.update();
        debug_gui.fpsCount = (int)thread.averageFPS;
    }

    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        debug_gui.draw(canvas);
    }
}
