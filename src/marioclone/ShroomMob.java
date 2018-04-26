package marioclone;

import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;

import java.util.Random;

public class ShroomMob extends Sprite {

    private Picture basePic;
    private SpriteComponent spriteComponent;
    private Random rand = new Random();


    private int count = 0;

    @Override
    public void preMove() {
        count++;
        if (count <= 30) {
            setX(675);
        }
    }

    public void init(SpriteComponent sc) {
        basePic = new Picture("Shroom.gif");
        setPicture(basePic);


        setVelX(-.5 * rand.nextDouble() - 1);
        sc.addSprite(this);
        setX(rand.nextInt(MoveMario.BOARD_SIZE.width));
        setY(310);


        this.spriteComponent = sc;

    }

    @Override
    public void processEvent(SpriteCollisionEvent spriteCollisionEvent) {
        if (spriteCollisionEvent.eventType == CollisionEventType.WALL_INVISIBLE) {

            if (!spriteCollisionEvent.xlo) {
                setVelX(-.5 * rand.nextDouble() - 1);
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