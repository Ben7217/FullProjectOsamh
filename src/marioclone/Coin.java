package marioclone;

import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import basicshooter.Game;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class Coin extends Sprite{

    private Picture basePic;
    private Random rand = new Random();
    SpriteComponent sc;


    public void init(SpriteComponent sc) {
        basePic = new Picture("coin.png");
        setPicture(basePic);


        while (true) {
            setVelX(-.5 * rand.nextDouble() - 1);
            sc.addSprite(this);
            setX(Game.RAND.nextInt(Game.BOARD_SIZE.width)-Game.SMALL);
            setY(Game.RAND.nextInt(Game.BOARD_SIZE.height - 75)-Game.SMALL);
         {
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

    }

}
