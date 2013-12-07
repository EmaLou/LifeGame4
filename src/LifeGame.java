import java.util.ArrayList;

public class LifeGame {
    private LifeFrame frame;

    public LifeGame(LifeFrame frame) {
         this.frame = frame;
    }

    public LifeFrame nextFrame() {
        return frame;
    }

    public LifeStatus shouldALive(LifePosition lifePosition) {
        if(calculateLifeAround(lifePosition) == 3 || calculateLifeAround(lifePosition) == 2 && alive(lifePosition))
            return LifeStatus.alive;
        return LifeStatus.dead;
    }

    private boolean alive(LifePosition lifePosition) {
        return frame.getFrame()[lifePosition.getPosition()[0]][lifePosition.getPosition()[1]].equals("*")? true:false;

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
           || lifePosition.getPosition()[0] >(frame.getFrame().length-1) || lifePosition.getPosition()[1] > (frame.getFrame()[0].length-1);
    }
}
