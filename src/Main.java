class Main {
  public static void main(String[] args) {

    
    GraphicsCreator gen = new GraphicsCreator(50,50,"output/image.png");
    
    gen.fill(Pixel.WHITE);
    
    gen.hSquare(new Point(5,5),new Point(35,35),new Pixel(215,215,0));
    
    gen.line(new Point(5,5),new Point(10,10),new Pixel(225,225,0));
    gen.line(new Point(40,10),new Point(35,5),new Pixel(225,225,0));
    gen.line(new Point(10,40),new Point(5,35),new Pixel(225,225,0));
    gen.line(new Point(40,40),new Point(35,35),new Pixel(225,225,0));

    gen.hSquare(new Point(10,10),new Point(40,40),Pixel.YELLOW);


    gen.saveImage(true);
  }
}