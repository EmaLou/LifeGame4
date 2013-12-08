package com.life;

import java.util.ArrayList;

public class LifeGame {
    private LifeFrame frame;

    public LifeGame(LifeFrame frame) {
         this.frame = frame;
    }

    public LifeFrame nextFrame() {
        LifeFrame next = new LifeFrame(new String[frame.height()][frame.width()]);
        for (int i = 0; i < frame.height(); i++) {
            for (int j = 0; j < frame.width(); j++) {
                LifePosition lifePosition = new LifePosition(i, j);
                if (shouldALive(lifePosition).equals(LifeStatus.alive))
                    next.changeStatusToAlive(lifePosition);
                else
                    next.changeStatusToDead(lifePosition);
            }
        }
        refreshFrame(next);
        return frame;
    }

    private void refreshFrame(LifeFrame next) {
        frame = next;
    }

    public LifeStatus shouldALive(LifePosition lifePosition) {
        if(calculateLifeAround(lifePosition) == 3 || calculateLifeAround(lifePosition) == 2 && alive(lifePosition))
            return LifeStatus.alive;
        return LifeStatus.dead;
    }

    private boolean alive(LifePosition lifePosition) {
          return frame.getLifeStatus(lifePosition).equals(LifeStatus.alive)?true:false;
    }

    public int calculateLifeAround(LifePosition coord) {
        int aliveNumber = 0;
        ArrayList<LifePosition> lifePositionsAround = calculatePositionAround(coord);
        for (LifePosition lifePosition : lifePositionsAround) {
            if(frame.getFrame()[lifePosition.getPosition()[0]][lifePosition.getPosition()[1]].equals("*"))
                aliveNumber++;
        }
        return aliveNumber;
    }

    public ArrayList<LifePosition> calculatePositionAround(LifePosition coord) {
        ArrayList<LifePosition> lifePositionsAround = new ArrayList<LifePosition>();
        addPositionToAroundPosition(lifePositionsAround, new LifePosition(coord.getPosition()[0] - 1, coord.getPosition()[1] - 1));
        addPositionToAroundPosition(lifePositionsAround, new LifePosition(coord.getPosition()[0] - 1, coord.getPosition()[1]));
        addPositionToAroundPosition(lifePositionsAround, new LifePosition(coord.getPosition()[0] - 1, coord.getPosition()[1] + 1));

        addPositionToAroundPosition(lifePositionsAround, new LifePosition(coord.getPosition()[0], coord.getPosition()[1] - 1));
        addPositionToAroundPosition(lifePositionsAround, new LifePosition(coord.getPosition()[0], coord.getPosition()[1] + 1));

        addPositionToAroundPosition(lifePositionsAround, new LifePosition(coord.getPosition()[0] + 1, coord.getPosition()[1] - 1));
        addPositionToAroundPosition(lifePositionsAround, new LifePosition(coord.getPosition()[0] + 1, coord.getPosition()[1]));
        addPositionToAroundPosition(lifePositionsAround, new LifePosition(coord.getPosition()[0] + 1, coord.getPosition()[1] + 1));

        return lifePositionsAround;
    }

    private void addPositionToAroundPosition(ArrayList<LifePosition> lifePositionsAround, LifePosition lifePosition) {
        if(!isPositionOutOfFrame(lifePosition)){
            lifePositionsAround.add(lifePosition);
        }
    }

    private boolean isPositionOutOfFrame(LifePosition lifePosition) {
        return lifePosition.getPosition()[0] < 0 || lifePosition.getPosition()[1] < 0
           || lifePosition.getPosition()[0] >(frame.height()-1) || lifePosition.getPosition()[1] > (frame.width()-1);
    }

    public void print() {
        String[][] output = nextFrame().getFrame();
        for(int i = 0; i< frame.height(); i++) {
            for(int j = 0; j< frame.width(); j++){
                System.out.print(output[i][j]);
            }
            System.out.print("\r\n");
        }
    }
}
