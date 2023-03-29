import java.awt.Color;

public class Pixel extends Color
{

  public Pixel(int r, int g, int b){
    super(r,g,b);
  }
  
  public Pixel(int r, int g, int b, int a){
    super(r,g,b,a);
  }

  public Pixel(int rgb){
    super(rgb);
  }

  public Pixel(int r, int g, int b, float a) {
    super(r,g,b,(a*255));
  }

  public Pixel(Color c){
    super(c.getRed(),c.getGreen(),c.getBlue(),c.getAlpha());
  }

  public Pixel(int rgb, boolean alpha) {
    super(rgb,alpha);
  }
  
  //Made For Transparency
  public Pixel correction(Pixel other)
  {
    // Gets the new transparent values based on a percentage
    // The percentage is described by the normalized value
    // from the Alpha of this. pixel
    double percentage = this.getAlpha()*1.0/255; //Between 0-1
    int r = (int)((this.getRed() * percentage) + (other.getRed() * (1-percentage)));
    int g = (int)((this.getGreen() * percentage) + (other.getGreen() * (1-percentage)));
    int b = (int)((this.getBlue() * percentage) + (other.getBlue() * (1-percentage)));
    return new Pixel(r,g,b);
  }

  public boolean equals(Pixel other)
  {
    boolean red = this.getRed() == other.getRed();
    boolean green = this.getGreen() == other.getGreen();
    boolean blue = this.getBlue() == other.getBlue();
    boolean alpha = this.getAlpha() == other.getAlpha();
    return (red && green && blue && alpha);
  }

  public boolean equals(Color other)
  {
    boolean red = this.getRed() == other.getRed();
    boolean green = this.getGreen() == other.getGreen();
    boolean blue = this.getBlue() == other.getBlue();
    boolean alpha = this.getAlpha() == other.getAlpha();
    return (red && green && blue && alpha);
  }

  @Override
  public String toString()
  {
    return "(" + this.getRed() + "," + this.getGreen() + "," + this.getBlue() + "," + this.getAlpha() + ")";
  }
  
}