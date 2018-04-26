/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marioclone;

import basicgraphics.CollisionEventType;
import basicgraphics.Sprite;
import basicgraphics.SpriteCollisionEvent;
import basicgraphics.SpriteComponent;
import basicgraphics.images.Picture;
import basicgraphics.sounds.ReusableClip;

import javax.swing.*;
import java.applet.AudioClip;
import java.io.IOException;


class Mario extends Sprite {
    public static int score = 0;
    private Picture basePic;
    public Game game = new Game();
    public int i = 0;
    private int level = 1;
    public static int getLevel = 0;
    public static int[] coinValueNeededToAdvance = {10, 15, 20, 50, 70};


    SpriteComponent sc;

    Mario() throws IOException {
        basePic = new Picture("Mario - Walk2.gif");
        setPicture(basePic);
    }

    private int count = 0;

    @Override
    public void preMove() {
        count++;
        if (count == 100)
            setPicture(basePic = new Picture("Mario - Walk3.gif"));
        else if (count == 200) {
            setPicture(basePic = new Picture("Mario - Walk1.gif"));
            count = 0;
        }
    }

    AudioClip clip = new ReusableClip("smw_coin.wav");

    @Override
    public void processEvent(SpriteCollisionEvent spriteCollisionEvent) {
        if (spriteCollisionEvent.eventType == CollisionEventType.WALL) {
            setX(800);
            basePic = basePic.resize(1.1);
        }

        if (spriteCollisionEvent.eventType == CollisionEventType.SPRITE) {
            if (spriteCollisionEvent.sprite2 instanceof Coin) {
                clip.play();
                spriteCollisionEvent.sprite2.setActive(false);
                Mario.score++;
            }
        }

        if (spriteCollisionEvent.eventType == CollisionEventType.SPRITE) {
            if (spriteCollisionEvent.sprite2 instanceof QuestionBlocks) {
                spriteCollisionEvent.sprite2.setActive(false);
                Mario.score = score + 5;
            }


            //Amount of coins needed to advance levels
            if (Mario.score >= coinValueNeededToAdvance[Game.gameLevel]) {
                JOptionPane.showMessageDialog(null, "Level " + level + ", finished! Coins: " + Mario.score + "!");
                Mario.score = 0;
                Game.gameLevel++;
                if (Game.gameLevel > 4) {
                    Game.gameLevel = 0;
                    level = 1;
                }

                level++;
                getLevel++;

                //Creating a new thread/frame

                return;
//                Game.main(null);
            }

            if (spriteCollisionEvent.sprite2 instanceof FlyingTurtle || spriteCollisionEvent.sprite2 instanceof ShroomMob) {
                setPicture(basePic = new Picture("MarioDeath.png"));
                spriteCollisionEvent.sprite2.setActive(true);
                JOptionPane.showMessageDialog(sc, "You lose! Game Over! \nCoins: " + score + "!");

                if(spriteCollisionEvent.sprite2 instanceof FlyingTurtle) {
                    System.out.println("Collided with a Flying Turtle");
                }

                if(spriteCollisionEvent.sprite2 instanceof ShroomMob) {
                    System.out.println("Collided with a Shroom");
                }
                System.exit(0);

            }





        }
    }
}







