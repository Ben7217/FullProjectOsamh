package marioclone;

import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import basicshooter.Game;
import basicshooter.Shooter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class Block extends Sprite {

    private Picture basePic;
    private Random rand = new Random();

    private SpriteComponent sc;

    public void init(SpriteComponent sc) {
        basePic = new Picture("Mario_brick.png");
        setPicture(basePic);

            sc.addSprite(this);
            setX(rand.nextInt(MoveMario.BOARD_SIZE.width));
            setY(rand.nextInt(MoveMario.BOARD_SIZE.height - 100) - 5);


            this.sc = sc;

    }

    @Override
    public void processEvent(SpriteCollisionEvent spriteCollisionEvent) {
        if(spriteCollisionEvent.eventType == CollisionEventType.SPRITE) {
            if(spriteCollisionEvent.sprite2 instanceof Mario) {
                //somewhere in here implement way to allow Mario to jump on blocks.
            }
        }

    }


}
