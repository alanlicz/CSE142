// Alan Li
// 03/11/2020
// CSE142
// TA: Eric Koegler
// Assignment #8
//
// This class will create a husky class which will infect critter at front, if there is no critter
// ahead 50% it will hop if possible or otherwise it will turn left
import java.awt.*;

public class Husky extends Critter{

    private boolean face;

    public Husky(){
        this.face = true;
    }

    public Critter.Action getMove(CritterInfo info) {
        if (info.getFront() == Critter.Neighbor.OTHER) {
            this.face = false;
            return Critter.Action.INFECT;

        } else if (info.getFront() == Neighbor.EMPTY){
            this.face = true;
            double number = Math.random();
            if (number < 0.5) {
                return Action.HOP;
            } else {
                return Action.RIGHT;
            }
        } else {
            return Action.LEFT;
        }
    }

    public Color getColor() {
        return Color.BLUE;
    }

    public String toString() {
        if (this.face) {
            return "∪◣_◢∪"; // if the husky didn't infect a critter it will display an angry face
        } else {
            return "u^I^u"; // other wise it will display a happy face
        }
    }
}
