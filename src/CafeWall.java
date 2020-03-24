// Alan Li
// 01/23/2020
// CSE142
// TA: Eric Koegler
// Assignment #3
//
// This program will output a cafe wall illusion image
import java.awt.*;

public class CafeWall {

    public static final int MORTAR = 2;

    public static void main(String[] args){
        DrawingPanel panel = new DrawingPanel(650, 400);
        panel.setBackground(Color.GRAY);
        Graphics brush = panel.getGraphics();

        drawRow(brush, 20, 4, 0, 0);
        drawRow(brush, 30, 5, 50, 70);
        drawGrid(brush, 4, 35, 35, 2, 400, 20);
        drawGrid(brush, 8, 0, 25, 4, 10, 150);
        drawGrid(brush, 6, 10, 25, 3, 250, 200);
        drawGrid(brush, 10, 10, 20, 5, 425, 180);
    }

    // Draw a single row
    public static void drawRow(Graphics brush, int size, int pair, int x, int y){
        for (int i = 1; i <= pair; i++){
            brush.setColor(Color.BLACK);
            brush.fillRect(size * 2 * (i - 1) + x, y, size, size);
            brush.setColor(Color.BLUE);
            brush.drawLine(size * 2 * (i - 1) + x,y, size * 2 * (i - 1) + size + x, size + y);
            brush.drawLine(size * (2 * i - 1) + x, y,size * 2 * i - (size * 2) + x, size + y);
            brush.setColor(Color.WHITE);
            brush.fillRect(size * (2 * i - 1) + x, y, size, size);
        }
    }

    // Draw a grid by calling the method drawRow
    public static void drawGrid(Graphics brush, int row, int offset, int size, int pair, int x, int y){
        for (int i = 1; i <= row; i++){
            drawRow(brush, size, pair, x + ((i + 1) % 2) * offset, y + size * (i - 1) + MORTAR * (i - 1));
        }
    }

}
