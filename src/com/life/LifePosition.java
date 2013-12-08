package com.life;

public class LifePosition {
    private int[] position = new int[2];

    public LifePosition(int x, int y) {
        this.position[0] = x;
        this.position[1] = y;
    }

    public int[] getPosition() {
        return position;
    }
}
