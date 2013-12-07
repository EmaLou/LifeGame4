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
}
