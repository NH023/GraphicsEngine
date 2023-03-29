import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.WritableRaster;

public class ImageGenerator {

  protected String filename;
  protected BufferedImage image;
  protected Graphics2D graphics;

  public ImageGenerator(int width, int height, String filename) {
    this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    this.filename = filename;
    this.graphics = image.createGraphics();
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
      if (output.exists() && !force) {
        throw new Exception("Cannot Create New Image, (File Name Taken)");
      } else {
        output.createNewFile();
      }

      // Write the image to the File
      ImageIO.write(image, "png", output);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Getter and Setter Methods

  // setPixel when passing a Color object
  public void setPixel(int x, int y, Color color) {
    int c = color.getRGB();

    // Handling Transparency
    if (color.getAlpha() < 255) {

      Pixel p = new Pixel(color);
      Pixel before = new Pixel(image.getRGB(x, y));
      c = p.correction(before).getRGB();

    }

    this.image.setRGB(x, y, c);

  }

  public void setPixel(Point p, Color color) {

    int c = color.getRGB();

    // Handling Transparency
    if (color.getAlpha() < 255) {

      Pixel pix = new Pixel(color);
      Pixel before = new Pixel(image.getRGB(p.x, p.y));
      c = pix.correction(before).getRGB();

    }

    this.image.setRGB(p.x, p.y, c);

  }

  public Pixel getPixel(int x, int y) {
    int colorInt = this.image.getRGB(x, y);
    return new Pixel(colorInt, true);
  }

  public Pixel getPixel(Point p) {
    int colorInt = this.image.getRGB(p.x, p.y);
    return new Pixel(colorInt, true);
  }

  public String getFileName() {
    return this.filename;
  }

  public void setFileName(String newFileName) {
    this.filename = newFileName;
  }

  public int getHeight() {
    return this.image.getHeight();
  }

  public int getWidth() {
    return this.image.getWidth();
  }

}