
import java.awt.*;

public class MickeyBox {
    public static void main(String[] args){
        DrawingPanel panel = new DrawingPanel(220, 150);
        panel.setBackground(Color.YELLOW);
        Graphics brush = panel.getGraphics();
        drawFigure(brush);
    }

    public static void drawFigure(Graphics pen){
        pen.setColor(Color.BLUE);
        pen.fillOval(50, 25, 40, 40);
        pen.fillOval(130, 25, 40, 40);
        pen.setColor(Color.RED);
        pen.fillRect(70,45,80,80);
        pen.setColor(Color.BLACK);
        pen.drawLine(70,85,150,85);
    }
}
