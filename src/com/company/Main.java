package com.company;

import com.life.LifeFrame;
import com.life.LifeGame;

public class Main {
    public static void main(String[] args) {
        LifeFrame initFrame = new LifeFrame(new String[][]{
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
        LifeGame lifeGame = new LifeGame(initFrame);
        while (true) {
            lifeGame.print();
        }
    }
}
