// Alan Li
// 03/11/2020
// CSE142
// TA: Eric Koegler
// Assignment #8
//
// This class will create a lion class which will infect critter at front, if there is no critter
// ahead and a wall is in front or to the right, it will turn left. If a lion is in the front it
// will turn right otherwise it will hop
import java.awt.*;
import java.util.Random;

public class Lion extends Critter{

    int count;
    Color color;

    public Lion(){
        this.count = 0;
    }

    /**
     * control how bear will move
     * @param info contain the movement
     * @return the action
     */
    public Critter.Action getMove(CritterInfo info) {
        this.count += 1;
        if (info.getFront() == Critter.Neighbor.OTHER) {
            return Critter.Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL){
            return Critter.Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME){
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }

    /**
     * get the color of the bear
     * @return return the color
     */
    public Color getColor() {

        if ((this.count - 1) % 3 == 0){
            this.color = getRandom();
        }
        return this.color;
    }

    /**
     * display the critter in the window
     * @return what character should be displayed
     */
    public static Color getRandom(){
        Random r = new Random();
        int number = r.nextInt(3) + 1;
        if (number == 1){
            return Color.RED;
        } else if (number == 2){
            return Color.GREEN;
        } else {
            return Color.BLUE;
        }
    }

    public String toString() {
        return "L";
    }
}
