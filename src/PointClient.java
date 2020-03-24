// Ayaz Latif
// TA: Grace Hopper
// CSE 142

// A client program using the Point class (creating multiple Point instances and 
// asking for their distance from the origin).
public class PointClient {
   public static void main(String[] args) {
      // construct a point p1 at coordinates (3, 5)
      // construct a point p2 at coordinates (12, 4)
      Point p1 = new Point(3, 5);
      Point p2 = new Point(12, 4);
      
      System.out.println("p1: x = " + p1.getX() + ", y = " + p1.getY());
      System.out.println("p2: x = " + p2.getX() + ", y = " + p2.getY());
      // translate p1 by (-1, 4)
      // translate p2 by (6, 3)
      
      p1.translate(-1, 4); // new OOP way!
      // translate(p1, -1, 4); // verb(p1) old style!
      
      p2.translate(6, 3);      
      
      System.out.println("p1: x = " + p1.getX() + ", y = " + p1.getY());
      System.out.println("p2: x = " + p2.getX() + ", y = " + p2.getY());
           
      // formula: square root of x^2 + y^2
      // print p1 distance to origin
      double distanceOfP1 = p1.distanceFromOrigin();
      System.out.println("distance from origin p1 = " + distanceOfP1);
      
      
      // formula: square root (x2 - x1)^2 + (x2 - x1)^2
      // distance to another point
      double distanceBetween = p1.distanceTo(p2);
      System.out.println("distance between p1 and p2 = " + distanceBetween);
   }
   
   
   // bad style! Having translate here would mean having to reimplement
   // this method everytime the Point class is used. It is better to
   // have this in the point class as an instance method!
    
   //public static void translate(Point p, int dx, int dy) {
   //   p.x = p.x + dx;
   //   p.y = p.y + dy;
   //}
}

// Notes from lecture:
// procedural programming: static methods
// object oriented programming (OOP)

// command line interface
// rm hi.txt
// verb noun

// Graphical User Interface: GUI
// clicked on the icon, action (dragging something to trash)
// noun verb
// Random, DrawingPanel, Scanner
// Clients: Scanner input = new Scanner(new File("hi.txt"));
// input.hasNextLine();
// noun.verb()
