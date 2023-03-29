class Main {
  public static void main(String[] args) {

    GraphicsCreator gen = new GraphicsCreator(100, 100, "output/image.png");

    gen.cover(Pixel.WHITE);
    Point[] vertices = {new Point(20,20),new Point(99,50),new Point(80,60),new Point(0,60)};
    gen.polygon(vertices,Pixel.BLACK);

    gen.fill(new Point(0,0),Pixel.GREEN);
    gen.fill(new Point(0,99),Pixel.BLUE);
    gen.fill(new Point(50,50),Pixel.RED);
    //gen.fill(new Point(0,99),Pixel.RED);

    // gen.hQuadrilateral(new Point(10,10), new Point(90,90), Pixel.WHITE);

    //gen.fill(new Point(50, 50), Pixel.YELLOW);
    gen.saveImage(true);

    System.out.println("Eureka!");
  }
}