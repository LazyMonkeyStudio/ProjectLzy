package com.lazymonkeystudio.engine;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by Will on 11/13/2015.
 */
public class GameObject {
    public Bitmap spritesheet;
    public String tag = "";
    private int x, y, dx, dy, WIDTH, HEIGHT;
    public double dxa, dya;
    private Rect bounds;
    private boolean playing;
    private boolean animate = true;
    public boolean forward, backward, up = false;
    public boolean down = true;
    private Animation animation = new Animation();
    private long startTime;

    public GameObject(String tag, Bitmap res, int x, int y, int columns, int rows)
    {
        //spritesheet = res;
        this.tag = tag;
        setX(x);
        setY(y);
        this.WIDTH = res.getWidth()/rows;
        this.HEIGHT = res.getHeight()/columns;
        bounds = new Rect(x, y, WIDTH, HEIGHT);
        int numframes = columns*rows;
        int sheet_index = 0;

        Bitmap[] image = new Bitmap[numframes];

        for (int col = 0; col < columns; col++)
        {
            for(int r = 0; r < rows; r++)
            {
                image[sheet_index] = Bitmap.createBitmap(res, r*WIDTH, col*HEIGHT, WIDTH, HEIGHT);

                System.out.println(image[sheet_index] + "," + image.length);
                sheet_index++;
            }
        }

        if(animate) {
            animation.setFrames(image);
            animation.setDelay(10);
        }
        startTime = System.nanoTime();
    }

    public void update()
    {
        if(animate)
        {
            animation.update();
        }

        //System.out.println(WIDTH + "," + HEIGHT);
        //System.out.println(GamePanel.WIDTH + "," + GamePanel.HEIGHT);
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(animation.getImage(), x, y, null);
    }

    public boolean getPlaying()
    {return playing;}

    public void setPlaying(boolean p)
    {playing = p;}

    public void resetDYA()
    {dya=0;}

    public void setAnimate(boolean a)
    {this.animate = a;}

    public void setX(int x)
    {this.x = x;}

    public void setY(int y)
    {this.y = y;}

    public void setDx(int dx)
    {this.dx = dx;}

    public void setDy(int dy)
    {this.dy = dy;}

    public void setUp(boolean u)
    {this.up = u;}

    public void setDown(boolean d)
    {this.down = d;}

    public void setForward(boolean f)
    {this.forward = f;}

    public void setBackward(boolean b)
    {this.backward = b;}

    public int getDy()
    {return dy;}

    public int getDx()
    {return dx;}

    public int getX()
    {return x;}

    public int getY()
    {return y;}
}
