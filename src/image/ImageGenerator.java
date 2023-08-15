package image;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.WritableRaster;

import structures.Pixel;
import structures.Point;

public class ImageGenerator {

  protected String filename;
  protected BufferedImage bufferedimage;
  protected Pixel[][] image;
  protected Graphics2D graphics;


  // Basic constructor for the image generation
  public ImageGenerator(int width, int height, String filename) {

    // Creating the buffered image and pixel array
    this.bufferedimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    this.image = new Pixel[bufferedimage.getHeight()][bufferedimage.getWidth()];

    // Fills image with white pixels
    for(int i=0; i<image.length; i++){
      for(int j=0; j<image[0].length; j++){
        image[i][j] = new Pixel(255,255,255);
      }
    }

    this.filename = filename;
    this.graphics = bufferedimage.createGraphics();
    this.graphics.dispose();

  }


  // Saves an image to a new file (or existing)
  public void saveImage(boolean force) {
    // Catch any errors that happen when creating the image
    try {

      File output = new File(filename);

      // If force is set to true, then if a
      // file exists with the same name, it is overwritten
      // otherwise, an error is thrown
      System.out.println(output.getParentFile().getCanonicalPath());
      File existanceChecking = output.getParentFile();

      // Force editing checker while also checking if the directory exists in the first place
      if (output.exists() && !force)
        throw new Exception("Cannot Create New Image, (Path Taken)");
      else if(!existanceChecking.isDirectory())
        throw new Exception("Path Does Not Exist, (" + existanceChecking.getAbsolutePath() + ").");
      else 
        output.createNewFile();

      // Write the image pixels to bufferedimage
      for(int i=0; i<this.getHeight(); i++){
        for(int j=0; j<this.getWidth(); j++){
          bufferedimage.setRGB(j,i,image[i][j].getRGB());
        }
      }
      ImageIO.write(bufferedimage, "png", output);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  // Setting a pixel value using x and y integers
  public void setPixel(int x, int y, Pixel color) {


    // Handling Transparency
    if (color.getAlpha() < 255) {

      Pixel before = image[y][x];
      color = color.correction(before);

    }

    this.image[y][x] = color;

  }


  // Setting a pixel value using Point class
  public void setPixel(Point p, Pixel color) {


    // Handling Transparency
    if (color.getAlpha() < 255) {

      Pixel before = image[p.y][p.x];
      color = color.correction(before);

    }

    this.image[p.y][p.x] = color;

  }



  // Getting a certain pixel from the pixel array using x and y integers
  public Pixel getPixel(int x, int y) {
    Pixel color = this.image[y][x];
    return color;
  }


  // Getting a certain pixel from the pixel array using the Point class
  public Pixel getPixel(Point p) {
    Pixel color = this.image[p.y][p.x];
    return color;
  }


  public String getFileName() {
    return this.filename;
  }


  public void setFileName(String newFileName) {
    this.filename = newFileName;
  }


  public int getHeight() {
    return this.image.length;
  }


  public int getWidth() {
    return this.image[0].length;
  }

  
}