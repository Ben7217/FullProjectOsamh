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
    SpriteComponent sc;

    Block() throws IOException {
        basePic = new Picture("Mario_brick.png");
        setPicture(basePic);
    }

    public void init(SpriteComponent sc) {
        setPicture(basePic);
//        setX(400);
//        setY(280);


        while (true) {
            setVelX(-.5 * rand.nextDouble() - 1);
            sc.addSprite(this);
            setX(Game.RAND.nextInt(Game.BOARD_SIZE.width)-Game.SMALL);
            setY(Game.RAND.nextInt(Game.BOARD_SIZE.height)-Game.SMALL);
            if (Math.abs(getX() - Game.BOARD_SIZE.width / 2) < 2 * Game.BIG
                    && Math.abs(getY() - Game.BOARD_SIZE.height / 2) < 2 * Game.BIG) {
                // Overlaps with center, try again
            } else {
                break;
            }
        }
        this.sc = sc;
    }


    @Override
    public void processEvent(SpriteCollisionEvent spriteCollisionEvent) {
        if(spriteCollisionEvent.eventType == CollisionEventType.WALL_INVISIBLE) {
            if (!spriteCollisionEvent.xlo) {
            } else {
                setX(sc.getSize().width - getWidth());
            }
            if (spriteCollisionEvent.xhi) {
                setX(0);
            }
            if (spriteCollisionEvent.ylo) {
                setY(sc.getSize().height - getHeight());
            }
            if (spriteCollisionEvent.yhi) {
                setY(0);
            }
        }

        if (spriteCollisionEvent.eventType == CollisionEventType.SPRITE) {
            if (spriteCollisionEvent.sprite2 instanceof Mario) {
                spriteCollisionEvent.sprite2.setActive(true);

            }
        }
    }


}
