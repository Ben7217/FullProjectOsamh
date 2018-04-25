package marioclone;

import basicgraphics.*;
import basicgraphics.images.Picture;
import basicshooter.Shooter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;

public class MoveMario {
    final public static Dimension BOARD_SIZE = new Dimension(800,400);


    public static void main(String[] args) throws IOException {
        Mario mario = new Mario();
        mario.setVelX(0);
        mario.setVelY(0);
        mario.setX(0);
        mario.setY(350);
        mario.setDrawingPriority(0);


        BasicFrame bf = new BasicFrame("Mario Clone");

        //Adding Mario sprite to frame
        SpriteComponent sprintComponent = new SpriteComponent();
        sprintComponent.setPreferredSize(BOARD_SIZE);
        bf.add("mario", sprintComponent, 0, 0, 1, 1);
        sprintComponent.setPreferredSize(BOARD_SIZE);
        sprintComponent.addSprite(mario);

        Block block = new Block();
        block.setDrawingPriority(-1);
        Random rand = new Random();


        block.init(sprintComponent);


        bf.show();
        sprintComponent.start(0, 10);

        bf.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    mario.setVelY(-2.0);
                    if (mario.top() == 400) {
                        mario.setY(350);
                    }


                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    mario.setVelX(1.0);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    mario.setVelX(-1.0);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    mario.setVelX(0);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                mario.setVelY(0);
                mario.setY(350);

            }
        });

    }


}

