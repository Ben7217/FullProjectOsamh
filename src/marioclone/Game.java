package marioclone;

import java.io.IOException;

public class Game implements Runnable{


    public static void main(String[] args) throws IOException {
        MoveMario.levelTwo();

    }

    @Override
    public void run() {
        try {
            MoveMario.levelTwo();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Level Two");
    }

}
