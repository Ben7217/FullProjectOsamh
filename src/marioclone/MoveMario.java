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
    public final static Dimension BOARD_SIZE = new Dimension(800,400);




    public static void runGame() throws IOException {

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


        spriteComponent.addSprite(mario);

//        JLabel jLabel = new JLabel();
//        basicFrame.add("score", jLabel,0 , 0, 0, 0);
//        Mario.score++;
//        jLabel.setText("Coins " + Mario.score);

        Ground ground = new Ground();
        ground.setDrawingPriority(0);
        ground.init(spriteComponent);

        Sky sky = new Sky();
        sky.setDrawingPriority(-5);
        sky.init(spriteComponent);

        for(int i = 0; i <= 2;  i++) {
            Block block = new Block();
            block.setDrawingPriority(-1);
            block.init(spriteComponent);
        }





        if (Game.gameLevel == 0) {
//            basicFrame.show();
            for (int i = 0; i <= 20; i++) {
                coin = new Coin();
                coin.setDrawingPriority(-2);
                coin.init(spriteComponent);
            }

            for (int i = 0; i <= 2; i++) {
                FlyingTurtle flyingTurtle = new FlyingTurtle();
                flyingTurtle.setDrawingPriority(-1);
                flyingTurtle.init(spriteComponent);
            }

            for (int i = 0; i <= 1; i++) {
                ShroomMob shroom = new ShroomMob();
                shroom.setDrawingPriority(-1);
                shroom.init(spriteComponent);
            }

            for(int i = 0; i < 1; i++) {
                QuestionBlocks questionBlocks = new QuestionBlocks();
                questionBlocks.setDrawingPriority(-1);
                questionBlocks.init(spriteComponent);

            }
        }

        if (Game.gameLevel == 1) {
//            basicFrame.dispose();
//            basicFrame.show();
            for (int i = 0; i <= 30; i++) {
                coin = new Coin();
                coin.setDrawingPriority(-2);
                coin.init(spriteComponent);
            }
            for(int i = 0; i <= 4; i++) {
                FlyingTurtle flyingTurtle = new FlyingTurtle();
                flyingTurtle.setDrawingPriority(-1);
                flyingTurtle.init(spriteComponent);
            }

            for(int i = 0; i <= 2; i++) {
                ShroomMob shroom = new ShroomMob();
                shroom.setDrawingPriority(-1);
                shroom.init(spriteComponent);
            }
            for(int i = 0; i < 2; i++) {
                QuestionBlocks questionBlocks = new QuestionBlocks();
                questionBlocks.setDrawingPriority(-1);
                questionBlocks.init(spriteComponent);

            }

        }
        if (Game.gameLevel == 2) {
//            basicFrame.dispose();
//            basicFrame.show();
            for (int i = 0; i <= 45; i++) {
                coin = new Coin();
                coin.setDrawingPriority(-2);
                coin.init(spriteComponent);
            }
            for(int i = 0; i <= 5; i++) {
                FlyingTurtle flyingTurtle = new FlyingTurtle();
                flyingTurtle.setDrawingPriority(-1);
                flyingTurtle.init(spriteComponent);
            }

            for(int i = 0; i <= 3; i++) {
                ShroomMob shroom = new ShroomMob();
                shroom.setDrawingPriority(-1);
                shroom.init(spriteComponent);
            }
            for(int i = 0; i < 2; i++) {
                QuestionBlocks questionBlocks = new QuestionBlocks();
                questionBlocks.setDrawingPriority(-1);
                questionBlocks.init(spriteComponent);

            }
        }

        if (Game.gameLevel == 3) {
//            basicFrame.dispose();
//            basicFrame.show();
            for (int i = 0; i <= 55; i++) {
                coin = new Coin();
                coin.setDrawingPriority(-2);
                coin.init(spriteComponent);
            }

            for(int i = 0; i <= 5; i++) {
                FlyingTurtle flyingTurtle = new FlyingTurtle();
                flyingTurtle.setDrawingPriority(-1);
                flyingTurtle.init(spriteComponent);
            }

            for(int i = 0; i <= 4; i++) {
                ShroomMob shroom = new ShroomMob();
                shroom.setDrawingPriority(-1);
                shroom.init(spriteComponent);
            }
            for(int i = 0; i < 3; i++) {
                QuestionBlocks questionBlocks = new QuestionBlocks();
                questionBlocks.setDrawingPriority(-1);
                questionBlocks.init(spriteComponent);

            }
        }

        if (Game.gameLevel == 4) {
            for (int i = 0; i <= 75; i++) {
                coin = new Coin();
                coin.setDrawingPriority(-2);
                coin.init(spriteComponent);
            }
            for(int i = 0; i <= 6; i++) {
                FlyingTurtle flyingTurtle = new FlyingTurtle();
                flyingTurtle.setDrawingPriority(-1);
                flyingTurtle.init(spriteComponent);
            }

            for(int i = 0; i <= 4; i++) {
                ShroomMob shroom = new ShroomMob();
                shroom.setDrawingPriority(-1);
                shroom.init(spriteComponent);
            }
            for(int i = 0; i < 3; i++) {
                QuestionBlocks questionBlocks = new QuestionBlocks();
                questionBlocks.setDrawingPriority(-1);
                questionBlocks.init(spriteComponent);

            }
        }

        spriteComponent.start(0, 10);
        basicFrame.show();

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
//                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//                    FireBall fireball = new FireBall();
//                    fireball.init(sc,shooter,e.getX(),e.getY());
//                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                mario.setVelY(0);
                mario.setY(319);

            }
        });

        System.out.println("Level " + Game.gameLevel);




    }


}

