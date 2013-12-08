package com.life;

public class LifeFrame {
    private String[][] frame;

    public LifeFrame(String[][] frame) {
        this.frame = frame;
    }

    public String[][] getFrame() {
        return frame;
    }

    public LifeStatus getLifeStatus(LifePosition lifePosition) {
        return frame[lifePosition.getPosition()[0]][lifePosition.getPosition()[1]].equals("*")
                ?LifeStatus.alive:LifeStatus.dead;
    }

    public void changeStatusToAlive(LifePosition position) {
        frame[position.getPosition()[0]][position.getPosition()[1]] = "*";
    }

    public void changeStatusToDead(LifePosition lifePosition) {
        frame[lifePosition.getPosition()[0]][lifePosition.getPosition()[1]] = " ";
    }

    public int height() {
        if(frame != null)
            return frame.length;
        return 0;
    }

    public int width() {
        if(frame[0] != null)
            return frame[0].length;
        return 0;
    }
}
