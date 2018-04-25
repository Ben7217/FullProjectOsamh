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

public class Block extends Sprite {
    private Picture basePic;
    SpriteComponent sc;

    Block() throws IOException {
        basePic = new Picture("Mario_brick.png");
        setPicture(basePic);
    }

    public void init(SpriteComponent sc) {
        setPicture(basePic);
        setX(400);
        setY(280);
        setVelX(-2);

        sc.addSprite(this);
        this.sc = sc;
    }


    @Override
    public void processEvent(SpriteCollisionEvent se) {

        if (se.eventType == CollisionEventType.SPRITE) {
            if (se.sprite2 instanceof Mario) {
                se.sprite2.setActive(false);
                JOptionPane.showMessageDialog(sc, "You lose! Game Over!");
                System.exit(0);
            }
        }
    }


}
