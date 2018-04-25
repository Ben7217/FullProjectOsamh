package marioclone;

import java.io.IOException;

public class Game implements Runnable{


    public static void main(String[] args) throws IOException {
        MoveMario.levelOne();



    }

    @Override
    public void run() {
        try {
            MoveMario.levelOne();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
