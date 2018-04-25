/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marioclone;

import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;


class Mario extends Sprite {
    private static int score = 0;
    private Picture basePic;
    SpriteComponent sc;

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
    public void processEvent(SpriteCollisionEvent spriteCollisionEvent) {
        if(spriteCollisionEvent.eventType == CollisionEventType.WALL) {
            setX(800);
            basePic = basePic.resize(1.1);
        }
        if (spriteCollisionEvent.eventType == CollisionEventType.SPRITE) {
            if (spriteCollisionEvent.sprite2 instanceof Coin) {
                spriteCollisionEvent.sprite2.setActive(false);
                score++;
            }
        }
        if (spriteCollisionEvent.eventType == CollisionEventType.SPRITE) {
            if (spriteCollisionEvent.sprite2 instanceof Block) {
                setPicture(basePic = new Picture("MarioDeath.png"));
                spriteCollisionEvent.sprite2.setActive(true);
                JOptionPane.showMessageDialog(sc, "You lose! Game Over! \nCoins: " + score + "!");
                System.exit(0);
            }
        }
    }




}

