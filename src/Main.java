/*
 * Site to Build and Test the Modules
 */

import structures.Point;
import structures.Pixel;

import image.GraphicsCreator;

class Main {
  public static void main(String[] args) {

    /*GraphicsCreator gen = new GraphicsCreator(100, 100, "output/image.png");

    gen.cover(Pixel.colorOf("white"));
    Point[] vertices = {new Point(20,20),new Point(99,50),new Point(80,60),new Point(0,60)};
    gen.polygon(vertices,Pixel.colorOf("black"));

    gen.fill(new Point(0,0),Pixel.colorOf("green"));
    gen.fill(new Point(0,99),Pixel.colorOf("blue"));
    gen.fill(new Point(50,50),Pixel.colorOf("red"));

    // gen.hQuadrilateral(new Point(10,10), new Point(90,90), Pixel.WHITE);

    //gen.fill(new Point(50, 50), Pixel.YELLOW);
    gen.saveImage(true);*/

    GraphicsCreator gen = new GraphicsCreator(101,51,"output/test.png");

    //gen.cover(Pixel.colorOf("red"));
    gen.fill(new Point(0,0), Pixel.colorOf("red"));
    gen.line(new Point(0,50), new Point(100,50), Pixel.colorOf("blue"));
    gen.fill(new Point(0,0), Pixel.colorOf("white"));
    gen.setPixel(1,0,Pixel.colorOf("black"));
    gen.saveImage(true);

    System.out.println("Eureka!");
  }
}