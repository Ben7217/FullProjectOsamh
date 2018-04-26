package marioclone;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;

import java.io.IOException;

public class Ground extends Sprite {

    private Picture basePic;
    SpriteComponent sc;

    Ground() throws IOException {
        basePic = new Picture("MarioGround.png");
        setPicture(basePic);
    }

    public void init(SpriteComponent sc) {
        setPicture(basePic);
        setX(0);
        setY(350);
        sc.addSprite(this);
        this.sc = sc;
    }

}
