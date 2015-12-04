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
    private Physics physics = new Physics(this);
    private GameObject player;

    public Engine_GamePanel(Context context, int targetFPS)
    {
        super(context, targetFPS);
        thread.setGamePanel(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        debug_gui = new DebugGUI();
        background = new Background_Scrolling(this, BitmapFactory.decodeResource(getResources(), R.drawable.background));
        player = new GameObject("player", BitmapFactory.decodeResource(getResources(), R.drawable.player), 100, 100, 1, 3);
        entity_m.addEntity(player);

        super.surfaceCreated(holder);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        super.surfaceDestroyed(holder);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        entity_m.addEntity(player);
        System.out.println("tapped");
        return super.onTouchEvent(event);
    }

    @Override
    public void  update()
    {
        super.update();
        physics.update();
        background.update();

        debug_gui.update();
        debug_gui.fpsCount = (int) thread.averageFPS;

        entity_m.update();
    }

    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        background.draw(canvas);

        debug_gui.draw(canvas);

        entity_m.draw(canvas);
    }
}
