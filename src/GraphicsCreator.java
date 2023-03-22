import java.awt.Color;

public class GraphicsCreator extends ImageGenerator
{

  public GraphicsCreator(int width, int height, String filename)
  {
    super(width,height,filename);  
  }

  public void fill(Color color) 
  {
    for(int i=0; i < this.getWidth(); i++){
      for(int j=0; j < this.getHeight(); j++){
        this.setPixel(i,j,color);
      }
    }
  }

  // Bresenham's Algorithm for Line Drawing
  public void line(Point point1, Point point2, Color color)
  {

    int x,y,dx,dy,neg;

    dx = point2.x-point1.x;
    dy = point2.y-point1.y;

    neg = (dy<0 ^ dx<0) ? -1 : 1;


    
    if(dy == 0) // Horizontal Line
    {

      if(point1.x > point2.x)
      {
        Point temp = point1;
        point1 = point2;
        point2 = temp;
      }

      x = point1.x;

      while(x <= point2.x)
      {
        this.setPixel(x, point1.y, color);
        x++;
      }
    } else if(dx == 0) // Vertical Line
    {

      if(point1.y > point2.y)
      {
        Point temp = point1;
        point1 = point2;
        point2 = temp;
      }


      y = point1.y;
      while(y <= point2.y)
      {
        this.setPixel(point1.x, y, color);
        y++;
      }
    } else if(Math.abs(dx) >= Math.abs(dy)) // Slope < 1
    {

      if(point1.x > point2.x)
      {
        Point temp = point1;
        point1 = point2;
        point2 = temp;

        // Opposite values due to swap
        dx *= -1;
        dy *= -1;
      }

      x = point1.x;
      y = point1.y;

      int p = ((2*dy) * neg) - dx;

      while(x <= point2.x)
      {
        this.setPixel(x,y,color);
        x++;
        if(p<0) {
          p = p + ((2*dy) * neg);
        } else {
          p = p + ((2*dy) * neg) - (2*dx);
          y += neg;
        }
      }

    } else // Slope > 1
    {
      if(point1.y > point2.y)
      {
        Point temp = point1;
        point1 = point2;
        point2 = temp;
        dx *= -1;
        dy *= -1;
      }

      x = point1.x;
      y = point1.y;

      int p = dy - ((2*dx) * neg);

      while(y <= point2.y)
      {
        this.setPixel(x,y,color);
        y++;
        if(p<0)
        {
          p = p + ((2*dx) * neg);
        } else {
          p = p + ((2*dx) * neg) - (2*dy) ;
          x += neg;
        }
      }

    }

  }
  
  public void square(Point p1, Point p2, Color color)
  {
    for(int i=p1.x; i<p2.x; i++){
      for(int j=p1.y; j<p2.y; j++){
        this.setPixel(i,j,color);
      }
    }
  }

  public void hSquare(Point p1, Point p2, Color color)
  {
    this.line(p1, new Point(p2.x,p1.y), color);
    this.line(new Point(p2.x,p1.y), p2, color);
    this.line(p2, new Point(p1.x,p2.y), color);
    this.line(new Point(p1.x,p2.y), p1, color);
  }

  public void polygon(Point[] vertices, Color color)
  {
    for(int i = 0; i < vertices.length-1; i++)
    {
      this.line(vertices[i],vertices[i+1],color);
    }
    this.line(vertices[vertices.length-1],vertices[0],color);
  }
  
}