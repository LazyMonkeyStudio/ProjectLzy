package com.lazymonkeystudio.engine;

import android.graphics.Canvas;

/**
 * Created by Will on 11/13/2015.
 */
public class Physics {
    private GamePanel gamePanel;

    public Physics(GamePanel gp)
    {
        gamePanel = gp;
    }

    public void update()
    {
        for(GameObject go : gamePanel.entity_m.world_objects)
        {
            if(go!=null)
            {
                if(go.up)
                {
                    go.setDy((int)(go.dya-=1.1));
                }else if(go.down)
                {
                    go.setDy((int)(go.dya+=1.1));
                }

                if(go.forward)
                {
                    go.setDx((int) (go.dxa += 1.1));
                } else if(go.backward)
                {
                    go.setDx((int) (go.dxa -= 1.1));
                }

                if(go.getDy()>14)go.setDy(14);
                if(go.getDy()<-14)go.setDy(-14);
                if(go.getDx()>14)go.setDx(14);
                if(go.getDx()<-14)go.setDx(-14);

                go.setY(go.getY()+go.getDy()*2);
                go.setDy(0);
            }
        }
    }
}
