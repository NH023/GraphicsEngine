import java.awt.Color;

class Main {
  public static void main(String[] args) {

    
    GraphicsCreator gen = new GraphicsCreator(50,50,"../src/output/image.png");
    
    gen.fill(Color.GRAY);
    gen.setPixel(1,2,Color.white);
    gen.square(new Point(5,2),new Point(10,5),Color.red);
    
    gen.saveImage(true);
    

  }
}