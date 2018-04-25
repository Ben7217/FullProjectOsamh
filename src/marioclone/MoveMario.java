package marioclone;

import basicgraphics.BasicFrame;
import basicgraphics.SpriteComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;

public class MoveMario {
    private final static Dimension BOARD_SIZE = new Dimension(800,400);


    public static void main(String[] args) throws IOException {

        Random random = new Random();
        Coin coin;


        Mario mario = new Mario();
        mario.setVelX(0);
        mario.setVelY(0);
        mario.setX(0);
        mario.setY(319);
        mario.setDrawingPriority(0);


        BasicFrame basicFrame = new BasicFrame("Mario Clone");

        //Adding Mario sprite to frame
        SpriteComponent spriteComponent = new SpriteComponent();
        spriteComponent.setPreferredSize(BOARD_SIZE);
        basicFrame.add("mario", spriteComponent, 0, 0, 1, 1);
        spriteComponent.setPreferredSize(BOARD_SIZE);
        spriteComponent.addSprite(mario);

        Ground ground = new Ground();
        ground.setDrawingPriority(0);
        ground.init(spriteComponent);

        for(int i = 0; i <= 3;  i++) {
            Block block = new Block();
            block.setDrawingPriority(-1);
            block.init(spriteComponent);
        }

        for(int i = 0; i < 1; i++) {
            QuestionBlocks questionBlocks = new QuestionBlocks();
            questionBlocks.setDrawingPriority(-1);
            questionBlocks.init(spriteComponent);

        }

        for (int i = 0; i <= 12;  i++) {
            coin = new Coin();
            coin.setDrawingPriority(-2);
            coin.init(spriteComponent);
        }









        basicFrame.show();
        spriteComponent.start(0, 10);

        basicFrame.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    mario.setVelY(-2.0);

                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    mario.setVelX(1.5);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    mario.setVelX(-1.5);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    mario.setVelX(0);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                mario.setVelY(0);
                mario.setY(319);

            }
        });



        System.out.println("Level One");


    }

    public static void levelTwo() throws IOException {

        Random random = new Random();
        Coin coin;


        Mario mario = new Mario();
        mario.setVelX(0);
        mario.setVelY(0);
        mario.setX(0);
        mario.setY(319);
        mario.setDrawingPriority(0);


        BasicFrame basicFrame = new BasicFrame("Mario Clone");

        //Adding Mario sprite to frame
        SpriteComponent spriteComponent = new SpriteComponent();
        spriteComponent.setPreferredSize(BOARD_SIZE);
        basicFrame.add("mario", spriteComponent, 0, 0, 1, 1);
        spriteComponent.setPreferredSize(BOARD_SIZE);
        spriteComponent.addSprite(mario);

        Ground ground = new Ground();
        ground.setDrawingPriority(0);
        ground.init(spriteComponent);

        for(int i = 0; i <= 4;  i++) {
            Block block = new Block();
            block.setDrawingPriority(-1);
            block.init(spriteComponent);
        }

        for(int i = 0; i < 2; i++) {
            QuestionBlocks questionBlocks = new QuestionBlocks();
            questionBlocks.setDrawingPriority(-1);
            questionBlocks.init(spriteComponent);

        }

        for (int i = 0; i <= 30;  i++) {
            coin = new Coin();
            coin.setDrawingPriority(-2);
            coin.init(spriteComponent);
        }









        basicFrame.show();
        spriteComponent.start(0, 10);

        basicFrame.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    mario.setVelY(-2.0);

                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    mario.setVelX(1.5);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    mario.setVelX(-1.5);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    mario.setVelX(0);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                mario.setVelY(0);
                mario.setY(319);

            }
        });






    }


}

