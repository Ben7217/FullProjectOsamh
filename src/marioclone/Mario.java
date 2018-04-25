/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marioclone;

import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.images.Picture;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;


class Mario extends Sprite {
    private Picture basePic;

    Mario() throws IOException {
        basePic = new Picture("Mario - Walk2.gif");
        setPicture(basePic);
    }
    private int count = 0;

    @Override
    public void preMove() {
        count++;
        if(count == 100)
            setPicture(basePic = new Picture("Mario - Walk3.gif"));
        else if(count == 200) {
            setPicture(basePic = new Picture("Mario - Walk1.gif"));
            count=0;
        }
    }

    @Override
    public void processEvent(SpriteCollisionEvent ev) {
        if(ev.eventType == CollisionEventType.WALL) {
            setX(800);
            basePic = basePic.resize(1.1);
        }
    }




}

