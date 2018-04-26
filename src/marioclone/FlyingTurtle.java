package marioclone;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;

import java.util.Random;

public class FlyingTurtle extends Sprite {

    private Picture basePic;
    private SpriteComponent spriteComponent;
    private Random rand = new Random();

    public void init(SpriteComponent sc) {
        basePic = new Picture("FlyingTurtle.png");
        setPicture(basePic);


        setVelX(-.5 * rand.nextDouble() - 1);
        sc.addSprite(this);
        setX(rand.nextInt(MoveMario.BOARD_SIZE.width));
        setY(rand.nextInt(MoveMario.BOARD_SIZE.height - 100) - 5);


        this.spriteComponent = sc;

    }

}
