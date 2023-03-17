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

  //Currently only for slopes < 1
  public void line(Point point1, Point point2, Color color)
  {

    if(point1.x > point2.x){
      //swap
      Point temp = point1;
      point1 = point2;
      point2 = temp;
    }

    int x = point1.x;
    int y = point1.y;

    int dx = point2.x - point1.x;
    int dy = point2.y - point1.y;

    int p = (2*dy) - dx;

    while(x < point2.x)
    {
      this.setPixel(x,y,color);
      x++;
      if(p<0)
      {
        p = p + (2*dy);
      } else
      {
        p = p + (2*dy) - (2*dx);
        y++;
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
    this.line(new Point(p1.x,p1.y),new Point(p2.x,p1.y),color);
    this.line(new Point(p2.x,p1.y),new Point(p2.x,p2.y),color);
    this.line(new Point(p2.x,p2.y),new Point(p1.x,p2.y),color);
    this.line(new Point(p1.x,p2.y),new Point(p1.x,p1.y),color);
  }
}