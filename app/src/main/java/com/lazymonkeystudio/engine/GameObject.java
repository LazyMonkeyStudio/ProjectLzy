package com.lazymonkeystudio.engine;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.animation.Animation;

/**
 * Created by Will on 11/13/2015.
 */
public class GameObject {
    public int x, y, dx, dy, dya, WIDTH, HEIGHT;
    public Bitmap image;
    public Rect bounds;
    public boolean isPhysics = true;

    public GameObject(Bitmap image, int x, int y, int columns, int rows)
    {
        this.image = image;
        this.x = x;
        this.y = x;
        this.WIDTH = image.getWidth()/columns;
        this.HEIGHT = image.getHeight()/rows;
        bounds = new Rect(x, y, x+WIDTH, y+HEIGHT);
    }

    public void update()
    {
        if(isPhysics)
        {

        }
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(image, x, y, null);
    }
}
