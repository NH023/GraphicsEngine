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

  /*DDA Algorithm for Line Drawing
   *Will be changed to Bessenham's Algorithm At A Later Time
   *DDA ALgoritm is trash */
  public void line(Point p1, Point p2, Color color)
  {
    int dx = p2.x - p1.x;
    int dy = p2.y - p1.y;

    int steps = Math.abs(dy);
    
    if(dx > dy){
      steps = Math.abs(dx);
    }

    double xInc = dx*1.0/steps;
    double yInc = dy*1.0/steps;

    double x = p1.x;
    double y = p1.y;

    
    for(int i=0; i < steps; i++)
    {
      this.setPixel((int)Math.round(x),(int)Math.round(y),color);
      x = x + xInc;
      y = y + yInc;
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
    this.line(new Point(p1.x,p1.y),new Point(p2.x,p1.y),color);
    this.line(new Point(p2.x,p1.y),new Point(p2.x,p2.y),color);
    this.line(new Point(p2.x,p2.y),new Point(p1.x,p2.y),color);
    this.line(new Point(p1.x,p2.y),new Point(p1.x,p1.y),color);
  }
}