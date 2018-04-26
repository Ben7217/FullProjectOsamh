package marioclone;

import basicgraphics.Sprite;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;

import java.io.IOException;

public class Sky extends Sprite {
    private Picture basePic;
    SpriteComponent sc;

    Sky() throws IOException {
        basePic = new Picture("Sky.png");
        setPicture(basePic);
    }

    public void init(SpriteComponent sc) {
        setPicture(basePic);
        setX(0);
        setY(0);
        sc.addSprite(this);
        this.sc = sc;
    }
}
