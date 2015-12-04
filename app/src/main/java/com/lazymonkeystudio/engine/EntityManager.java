package com.lazymonkeystudio.engine;

import android.graphics.Canvas;

/**
 * Created by Will on 11/17/2015.
 */
public class EntityManager {
    private final int MAX_GAME_OBJ = 15;
    public GameObject[] world_objects = new GameObject[MAX_GAME_OBJ];
    private int WORLD_OBJ_COUNT;

    public EntityManager()
    {

    }

    public void addEntity(GameObject obj)
    {
        for(GameObject go : world_objects)
        {
            if(go==null)
            {
                world_objects[WORLD_OBJ_COUNT] = obj;
                WORLD_OBJ_COUNT++;
                break;
            }
        }
    }

    public void removeEntity(String tag)
    {
        int count = 0;
        for(GameObject go : world_objects)
        {
            count++;
            if (go.tag == tag)
            {
                world_objects[count] = null;
                WORLD_OBJ_COUNT--;
                break;
            }
        }
    }

    public void update()
    {
        for(GameObject go : world_objects)
        {
            if(go!=null)
            {
                go.update();
            }
        }
    }

    public void draw(Canvas canvas)
    {
        for(GameObject go : world_objects)
        {
            if(go!=null)
            {
                go.draw(canvas);
                System.out.println("drew object");
            }
        }
    }
}
