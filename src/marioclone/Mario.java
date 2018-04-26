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
    public int[] coinValueNeededToAdvance = {2, 7, 12};



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
                score++;
            }
        }


            //Amount of coins needed to advance levels
            if (Mario.score == coinValueNeededToAdvance[Game.gameLevel]) {
                JOptionPane.showMessageDialog(null, "Level " + level + ", finished! Coins: " + Mario.score + "!");
                Mario.score = 0;
                if (Game.gameLevel > 3) {
                    Game.gameLevel = 0;
                    level = 1;
                }
                Game.gameLevel++;
                level++;
                Game.main(null);
            }

        if (spriteCollisionEvent.eventType == CollisionEventType.SPRITE) {
            if (spriteCollisionEvent.sprite2 instanceof FlyingTurtle) {
                setPicture(basePic = new Picture("MarioDeath.png"));
                spriteCollisionEvent.sprite2.setActive(true);
                JOptionPane.showMessageDialog(sc, "You lose! Game Over! \nCoins: " + score + "!");
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?",
                        "Confirm Quit", JOptionPane.YES_NO_CANCEL_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else {
                    Game.main(null);
                }
            }
        }

    }
}







