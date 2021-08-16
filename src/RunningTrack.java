public class RunningTrack implements Obstacle {
    public final int length;
    public RunningTrack(int length) { this.length = length;}

    @Override
    public String toString() {
        return String.format("running track with length: %d", length);

    }
}
