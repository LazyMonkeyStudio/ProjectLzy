package com.lazymonkeystudio.engine;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Will on 11/12/2015.
 */
public class Background_World extends Background {

    public Background_World(GamePanel gp, Bitmap res, int width, int height)
    {
        super(gp, res);
        GamePanel.WIDTH = width;
        GamePanel.HEIGHT = height;
    }

    @Override
    public void update()
    {
        super.update();
        System.out.println(gamePanel.getHeight() + "/" + gamePanel.HEIGHT);
        System.out.println(gamePanel.getWidth() + "/" + gamePanel.WIDTH);
    }

    @Override
    public void draw(Canvas canvas)
    {
        //super.draw(canvas);        //1980
        float scaleFactorX = (float)gamePanel.WIDTH/gamePanel.getWidth();
        float scaleFactorY = (float)gamePanel.HEIGHT/gamePanel.getHeight();
        if(canvas != null) {
            final int savedState = canvas.save();
            canvas.scale(scaleFactorX, scaleFactorY);
            canvas.drawBitmap(image, X, Y, null);
            canvas.restoreToCount(savedState);
        }
    }
}
