// Alan Li
// 03/11/2020
// CSE142
// TA: Eric Koegler
// Assignment #8
//
// This class will create a bear class which will infect critter at front, if there is no critter
// it will hop if possible or otherwise it will turn left
import java.awt.*;

public class Bear extends Critter{
    private boolean polar;
    private int count;

    public Bear(boolean initialPolar){
        this.polar = initialPolar;
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
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Critter.Action.HOP;
        } else {
            return  Action.LEFT;
        }
    }

    /**
     * get the color of the bear
     * @return return the color
     */
    public Color getColor() {
        if (this.polar) {
            return Color.WHITE;
        } else {
            return Color.BLACK;
        }
    }

    /**
     * display the critter in the window
     * @return what character should be displayed
     */
    public String toString() {
        if ((this.count - 1) % 2 == 0){
            return "\\";
        } else {
            return "/";
        }
    }
}
