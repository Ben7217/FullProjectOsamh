package marioclone;

import java.io.IOException;

public class Game {

    public static int gameLevel = 0;


    public static void main(String[] args) {
        try {
            MoveMario.runGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
