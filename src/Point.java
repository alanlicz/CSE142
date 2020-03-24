// A class to represent a point on the x-y coordinate plane.
//
// This version is fully encapsulated and abstracted. Notice the
//   private fields, the getter/setter methods, and the constructor.
//   We've also added the toString method so we can print out points
//   easily.
public class Point {
   // fields 
   private int x;
   private int y;
   
   // constructor
   public Point(int origX, int origY) {
      x = origX;
      y = origY;
   }
   
   // modifier (setter) methods
   public void setX(int newX) {
      x = newX;
   }
   
   public void setY(int newY) {
      y = newY;
   }
   
   // accessor (getter) methods
   public int getX() {
      return x;
   }
   
   public int getY() {
      return y;
   }
   
   // instance methods
   
   // Calculates and returns the distance from this point to the
   //   origin.
   public double distanceFromOrigin() {
      return Math.sqrt(x * x + y * y);
   }
   
   // Calculates and returns the distance from this point to the given
   //   other point.
   //
   // Point p - the point to calculate the distance to
   public double distanceTo(Point p) {
      return Math.sqrt((p.x - x) * (p.x - x) + (p.y - y) * (p.y - y));
   }
   
   // Translates this point both horizontally and vertically.
   //
   // int dx - the horizontal translation
   // int dy - the vertical translation
   public void translate(int dx, int dy) {
      x += dx;
      y += dy;
   }
   
   // Returns a string representation of this point.
   public String toString() {
      return "(" + x + ", " + y + ")";
   }
}
