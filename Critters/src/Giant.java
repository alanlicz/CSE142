// Alan Li
// 03/11/2020
// CSE142
// TA: Eric Koegler
// Assignment #8
//
// This class will create a giant class which will infect critter at front, if there is no critter
// ahead it will hop if possible or otherwise it will turn right

import java.awt.*;

public class Giant extends Critter{

    int count;

    public Giant(){
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
        } else if (info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }

    /**
     * get the color of the bear
     * @return return the color
     */
    public Color getColor() {
        return Color.GRAY;
    }

    /**
     * display the critter in the window
     * @return what character should be displayed
     */
    public String toString() {

        if ((this.count - 1) % 24 < 6){
            return "fee";
        } else if ((this.count - 1) % 24 < 12){
            return "fie";
        } else if ((this.count - 1) % 24 < 18){
            return "foe";
        } else {
            return "fum";
        }
    }
}
