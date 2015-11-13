package com.lazymonkeystudio.engine;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Will on 11/11/2015.
 */
public class Background_Scrolling extends Background {
    private int dx = -5;

    public Background_Scrolling(GamePanel gp, Bitmap res)
    {
        super(gp, res);
    }

    @Override
    public void update()
    {
        super.update();
        X+=dx;
        if(X<-GamePanel.WIDTH)
        {
            X=0;
        }
    }

    @Override
    public void draw(Canvas canvas)
    {
        //super.draw(canvas);
        float scaleFactorY = (float)gamePanel.getHeight()/gamePanel.HEIGHT;
        if(canvas != null) {
            final int savedState = canvas.save();
            canvas.scale(1, scaleFactorY);
            canvas.drawBitmap(image, X, Y, null);
            if (X < 0) {
                canvas.drawBitmap(image, X + GamePanel.WIDTH, Y, null);
            }
            canvas.restoreToCount(savedState);
        }
    }

    public void setVector(int dx)
    {
        this.dx = dx;
    }
}
