package marioclone;

import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;

import javax.swing.*;
import java.util.Random;

public class FlyingTurtle extends Sprite {

    private Picture basePic;
    private SpriteComponent spriteComponent;
    private Random rand = new Random();


    private int count = 0;

    @Override
    public void preMove() {
        count++;
        if (count <= 30) {
            setX(800);
        }
    }

    public void init(SpriteComponent sc) {
        basePic = new Picture("FlyingTurtle.png");
        setPicture(basePic);


        setVelX(-.5 * rand.nextDouble() - 1);
        sc.addSprite(this);
        setX(rand.nextInt(MoveMario.BOARD_SIZE.width));
        setY(rand.nextInt(MoveMario.BOARD_SIZE.height - 100) - 5);


        this.spriteComponent = sc;

    }


    @Override
    public void processEvent(SpriteCollisionEvent spriteCollisionEvent) {
        if (spriteCollisionEvent.eventType == CollisionEventType.WALL_INVISIBLE) {

            if (!spriteCollisionEvent.xlo) {
                setX(rand.nextInt(MoveMario.BOARD_SIZE.width));

            } else {
                setX(spriteComponent.getSize().width - getWidth());
            }
            if (spriteCollisionEvent.xhi) {
                setX(0);
            }
            if (spriteCollisionEvent.ylo) {
                setY(spriteComponent.getSize().height - getHeight());
            }
            if (spriteCollisionEvent.yhi) {
                setY(0);
            }
        }
    }
}
