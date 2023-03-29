import java.awt.Color;
import java.lang.Exception;
import java.util.ArrayList;

public class GraphicsCreator extends ImageGenerator {

  public GraphicsCreator(int width, int height, String filename) {
    super(width, height, filename);
  }

  // Converts all pixels to this color
  // Covers image
  public void cover(Color color) {
    for (int i = 0; i < this.getWidth(); i++) {
      for (int j = 0; j < this.getHeight(); j++) {
        this.setPixel(i, j, color);
      }
    }
  }

  public void fill(Point start, Color color)
  {
    this.scanFill(start, color, this.getPixel(start));
  }

  private void scanFill(Point start, Color color, Color target)
  {
    
    boolean canFindUp = true;
    boolean canFindDown = true;
    ArrayList<Point> seeds = new ArrayList<Point>();
    
    //Change start Point to the left most spot
    while(start.x > 0 && this.getPixel(new Point(start.x-1,start.y)).equals(target))
    {
      start = new Point(start.x-1,start.y);
    }

    //System.out.println(start);
    
    
    // Checks if the pixel above is the target
    Point current = start.copy();
    //System.out.println(this.getPixel(current) + " " + target);
    while(current.x < this.getWidth() && this.getPixel(current).equals(target))
    {
      this.setPixel(current,color);
      
      // Checks if the pixel above is the target
      Point up = new Point(current.x, current.y+1);
      if(up.y < this.getHeight()){
        
        if(this.getPixel(up).equals(target) && canFindUp){
          //this.scanFill(up,color,target,lim-1);
          seeds.add(up);
          canFindUp = false;
        } else if(!this.getPixel(up).equals(target) && !canFindUp){
          canFindUp = true;
        } 
        
      }


      // Checks if the pixel below is the target
      Point down = new Point(current.x, current.y-1);
      if(down.y >= 0){
        //System.out.println(down + " " + this.getPixel(down) + " | " + target);
        if(this.getPixel(down).equals(target) && canFindDown){
          //this.scanFill(down,color,target,lim-1);
          seeds.add(down);
          canFindDown = false;
        } else if(!this.getPixel(down).equals(target) && !canFindDown){
          canFindDown = true;
        }  
        
      }

      
      current = new Point(current.x+1,current.y);  
    }

    // Planting Seeds
    for(Point p: seeds)
    {
      this.scanFill(p, color, target);
    }
    
  }
  
  // RECURSIVE FLOODFILL . Breaks and doesn't work properly
  // Wrapper for brokenFill 
  // Had to do this because I didn't want to have the user
  // pass in the original color :)
  /*public void fill(Point start, Color color, int lim) {
    this.brokenFill(start, color, this.getPixel(start), lim);
  }

  // Fills a shape until the walls are reached
  // Recursivly checks the walls and changes the colors
  private void brokenFill(Point start, Color color, Color original, int lim) {

    if (lim < 1) {
      return;
    }

    if(!this.getPixel(start).equals(original) || this.getPixel(start).equals(color)){
      return;
    }

    // Cross Shape
    Point left = new Point(start.x - 1, start.y);
    Point right = new Point(start.x + 1, start.y);
    Point up = new Point(start.x, start.y + 1);
    Point down = new Point(start.x, start.y - 1);

    // Set the Pixel
    // This makes it so the recursion doesn't double back on itself
    // Many StackOverflow errors were present in the making
    this.setPixel(start, color);
    this.image.flush();

    // Travels to the Right
    if (right.x < this.getWidth()) {
      this.brokenFill(right, color, original, lim - 1);
    }

    // Travels Up
    if (up.y < this.getHeight()) {
      this.brokenFill(up, color, original, lim - 1);
    }

    // Travels to the Left
    if (left.x > 0) {
      this.brokenFill(left, color, original, lim - 1);
    }

    // Travels Down
    if (down.y > 0) {
      this.brokenFill(down, color, original, lim - 1);
    }
    
  }*/

  // Bresenham's Algorithm for Line Drawing
  public void line(Point point1, Point point2, Color color) {

    int x, y, dx, dy, neg;

    dx = point2.x - point1.x;
    dy = point2.y - point1.y;

    neg = (dy < 0 ^ dx < 0) ? -1 : 1;

    if (dy == 0) // Horizontal Line
    {

      // Swap points so the points go from left to right
      if (point1.x > point2.x) {
        Point temp = point1;
        point1 = point2;
        point2 = temp;
      }

      x = point1.x;

      while (x <= point2.x) {
        this.setPixel(x, point1.y, color);
        x++;
      }
    } else if (dx == 0) // Vertical Line
    {

      // Swap points to go from bottom to top
      // Note: Bottom is at the top of the screen
      if (point1.y > point2.y) {
        Point temp = point1;
        point1 = point2;
        point2 = temp;
      }

      y = point1.y;
      while (y <= point2.y) {
        this.setPixel(point1.x, y, color);
        y++;
      }
    } else if (Math.abs(dx) >= Math.abs(dy)) // Slope < 1
    {

      // Swap points to go from left to right
      if (point1.x > point2.x) {
        Point temp = point1;
        point1 = point2;
        point2 = temp;

        // Opposite values due to swap
        dx *= -1;
        dy *= -1;
      }

      x = point1.x;
      y = point1.y;

      int p = ((2 * dy) * neg) - dx;

      while (x <= point2.x) {
        this.setPixel(x, y, color);
        x++;
        if (p < 0) {
          p = p + ((2 * dy) * neg);
        } else {
          p = p + ((2 * dy) * neg) - (2 * dx);
          y += neg;
        }
      }

    } else // Slope > 1
    {

      // Swap points to go from bottom to top
      // Note: Bottom is at the top of the screen
      if (point1.y > point2.y) {
        Point temp = point1;
        point1 = point2;
        point2 = temp;

        // Opposite values due to swap
        dx *= -1;
        dy *= -1;
      }

      x = point1.x;
      y = point1.y;

      int p = dy - ((2 * dx) * neg);

      while (y <= point2.y) {
        this.setPixel(x, y, color);
        y++;
        if (p < 0) {
          p = p + ((2 * dx) * neg);
        } else {
          p = p + ((2 * dx) * neg) - (2 * dy);
          x += neg;
        }
      }

    }

  }

  public Point line(Point start, double angle, int length, Color color) {

    int x = (int) (Math.round(Math.cos(Math.toRadians(-angle)) * length + start.x));
    int y = (int) (Math.round(Math.sin(Math.toRadians(-angle)) * length + start.y));
    Point end = new Point(x, y);

    this.line(start, end, color);
    return end;

  }

  // Makes a filled quadrilateral
  public void quadrilateral(Point p1, Point p2, Color color) {
    for (int i = p1.x; i < p2.x; i++) {
      for (int j = p1.y; j < p2.y; j++) {
        this.setPixel(i, j, color);
      }
    }
  }

  // Makes a hollow quadrilateral (just the edges)
  public void hQuadrilateral(Point p1, Point p2, Color color) {
    this.line(p1, new Point(p2.x, p1.y), color);
    this.line(new Point(p2.x, p1.y), p2, color);
    this.line(p2, new Point(p1.x, p2.y), color);
    this.line(new Point(p1.x, p2.y), p1, color);
  }

  public void polygon(Point[] vertices, Color color) {
    for (int i = 0; i < vertices.length - 1; i++) {
      this.line(vertices[i], vertices[i + 1], color);
    }
    this.line(vertices[vertices.length - 1], vertices[0], color);
  }

  public void regularGon(Point center, int size, int sides, Color color) {
    double interiorAngle = ((sides - 2) * 180) * 1.0 / sides;
    double currentAngle = 0;
    Point startSpot = center;
    for (int i = 0; i < sides; i++) {
      startSpot = this.line(startSpot, currentAngle, size, color);
      currentAngle = (currentAngle + (180 - interiorAngle)) % 360;
    }

  }

}