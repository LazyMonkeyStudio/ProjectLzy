package com.lazymonkeystudio.engine;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Will on 11/11/2015.
 */
public class Background {
    public GamePanel gamePanel;
    public Bitmap image;
    public int X;
    public int Y;

    public Background(GamePanel gp, Bitmap res)
    {
        gamePanel = gp;
        image = res;
        GamePanel.WIDTH = image.getWidth();
        GamePanel.HEIGHT = image.getHeight();
    }

    public void update()
    {
    }

    public void draw(Canvas canvas)
    {

        float scaleFactorY = (float)gamePanel.getHeight()/gamePanel.HEIGHT;
        if(canvas != null) {
            final int savedState = canvas.save();
            canvas.scale(1, scaleFactorY);
            canvas.drawBitmap(image, X, Y, null);
            canvas.restoreToCount(savedState);
        }
    }
}
