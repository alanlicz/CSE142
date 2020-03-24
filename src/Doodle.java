// Alan Li
// 01/22/2020
// CSE142
// TA: Eric Koegler
// Assignment #3
//
// This program will print a Microsoft logo

import java.awt.*;

public class Doodle {
    public static void main(String[] args){
        DrawingPanel canvas = new DrawingPanel(500, 500);
        Graphics brush = canvas.getGraphics();
        drawLogo(brush, 10, 10, Color.RED);
        drawLogo(brush, 70, 10, Color.GREEN);
        drawLogo(brush, 10, 70, Color.BLUE);
        drawLogo(brush, 70, 70, Color.ORANGE);
    }

    public static void drawLogo(Graphics brush, int x, int y, Color color){
        brush.setColor(color);
        brush.fillRect(x, y, 50,50);
    }

}
