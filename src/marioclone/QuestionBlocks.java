package marioclone;

import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import basicshooter.Game;

import java.io.IOException;
import java.util.Random;

public class QuestionBlocks extends Sprite {

    private Picture basePic;
    private Random rand = new Random();
    SpriteComponent sc;

    QuestionBlocks() throws IOException {
        basePic = new Picture("QuestionBlock1.png");
        setPicture(basePic);
    }

    private int count = 0;

    @Override
    public void preMove() {
        count++;
        if(count == 100)
            setPicture(basePic = new Picture("QuestionBlock2.png"));
        else if(count == 200) {
            setPicture(basePic = new Picture("QuestionBlock1.png"));
            count=0;
        }
    }

    public void init(SpriteComponent sc) {
        setPicture(basePic);
//        setX(400);
// setY(280);



            setVelX(- 2.5 * rand.nextDouble() - 1);
            sc.addSprite(this);
            setX(basicshooter.Game.RAND.nextInt(basicshooter.Game.BOARD_SIZE.width) - basicshooter.Game.SMALL);
            setY(rand.nextInt(MoveMario.BOARD_SIZE.height - 100) - 5);

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
