package com.lazymonkeystudio.engine;

import android.graphics.Bitmap;

/**
 * Created by Will on 11/13/2015.
 */
public class Animation {
    private Bitmap[] frames;
    private int currentFrame;
    private long startTime, delay;
    private boolean playedOnce;

    public void setFrames(Bitmap[] frames)
    {
        this.frames = frames;
        currentFrame = 0;
        startTime = System.nanoTime();
    }

    public Animation()
    {

    }

    public void update()
    {
        long elapsed = (System.nanoTime()-startTime)/1000000;

        if(elapsed>delay)
        {
            currentFrame++;
            startTime = System.nanoTime();
        }

        if(currentFrame == frames.length)
        {
            currentFrame = 0;
            playedOnce = true;
        }
    }
    public Bitmap getImage()
    {return frames[currentFrame];}

    public int getFrame()
    {return currentFrame;}

    public boolean playedOnce()
    {return playedOnce;}

    public void setDelay(int d)
    {delay = d;}

    public void setFrames(int i)
    {currentFrame = i;}
}
