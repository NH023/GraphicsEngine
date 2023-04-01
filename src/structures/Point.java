package structures;

public class Point
{

  public int x;
  public int y;
  
  public Point(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  public Point copy()
  {
    return new Point(this.x,this.y);
  }

  public Point add(Point other)
  {
    return new Point(this.x + other.x, this.y + other.y);
  }

  public Point add(int x, int y)
  {
    this.x += x;
    this.y += y;
    return this;
  }

  public Point sub(Point other)
  {
    return new Point(this.x - other.x, this.y - other.y);
  }

  public Point sub(int x, int y)
  {
    this.x -= x;
    this.y -= y;
    return this;
  }

  public Point mult(Point other)
  {
    return new Point(this.x * other.x, this.y * other.y);
  }

  public Point mult(int x, int y)
  {
    this.x *= x;
    this.y *= y;
    return this;
  }

  public Point div(Point other)
  {
    return new Point(this.x / other.x, this.y / other.y);
  }

  public Point div(int x, int y)
  {
    this.x /= x;
    this.y /= y;
    return this;
  }

  public boolean equals(Point other)
  {
    return this.x == other.x && this.y == other.y;
  }

  public String toString()
  {
    return "(" + this.x + "," + this.y + ")";
  }
  
}