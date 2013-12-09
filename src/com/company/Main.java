package com.company;

import com.life.LifeFrame;
import com.life.LifeGame;

public class Main {
    public static void main(String[] args) {
        final LifeFrame initFrame = new LifeFrame(new String[][]{
                {" ","*","*","*"," "," ","*","*","*","*"},
                {" "," "," "," "," "," ","*"," ","*"," "},
                {" ","*","*"," "," "," ","*"," ","*"," "},
                {" ","*"," "," ","*","*"," "," "," "," "},
                {" "," "," "," ","*"," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "," "," "} });

        final LifeGame lifeGame = new LifeGame(initFrame);

        while (true) {
            try {
                lifeGame.print();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
