public interface Participant {

    default void overcomeObstacle(Obstacle obstacle) {
        if (obstacle instanceof Wall) {
            Wall wall = =(Wall) obstacle;
            this.jump(wall);
            else if (obstacle in RunningTrack) {
              RunningTrack runningTrack = (RunningTrack) obstacle; {
                  this.run(runningTrack);
              }
            }
            boolean getStatus();
            void run(RunningTrack runningTrack);
            void jump(Wall wall);
        }

    }

}
