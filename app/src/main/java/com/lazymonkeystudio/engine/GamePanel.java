package com.lazymonkeystudio.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Will on 11/5/2015.
 */
public class GamePanel extends SurfaceView implements SurfaceHolder.Callback
{
    public static int WIDTH;
    public static int HEIGHT;
    public MainThread thread;
    public Background background;
    public EntityManager entity_m;

    public GamePanel(Context context, int targetFPS)
    {
        super(context);
        entity_m = new EntityManager();
        //add the callback to the surface holder to intercept events
        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        thread.FPS = targetFPS;
        //make panel focusable so it can handle events
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
    {}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        boolean retry = true;
        while(retry)
        {
            try
            {
                thread.setRunning(false);
                thread.join();
            }
            catch (InterruptedException e)
            { e.printStackTrace(); }
            retry = false;
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        //start game loop
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        return super.onTouchEvent(event);
    }

    public void update()
    {
    }

    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);
    }
}
