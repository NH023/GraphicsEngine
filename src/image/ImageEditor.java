package image;

import java.io.File;
import javax.imageio.ImageIO;

import structures.Pixel;

public class ImageEditor extends ImageGenerator {
    


    public ImageEditor(String filename) {
        super(filename);
    }

    public void load(String file){
        try {
            this.bufferedimage = ImageIO.read(new File(file));
            refresh_image_array();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void greyscale(){
        for(int i=0; i<getHeight(); i++){
            for(int j=0; j<getWidth(); j++){
                Pixel current_pixel = this.image[i][j];
                int grey_value = (current_pixel.getRed() + current_pixel.getBlue() + current_pixel.getGreen())/3;
                this.image[i][j] = new Pixel(grey_value,grey_value,grey_value);
            }
        }
    }

    public void invert_colors(){
        for(int i=0; i<getHeight(); i++){
            for(int j=0; j<getWidth(); j++){
                Pixel current_pixel = this.image[i][j];
                int new_red = 255-current_pixel.getRed();
                int new_green = 255-current_pixel.getGreen();
                int new_blue = 255-current_pixel.getBlue();
                this.image[i][j] = new Pixel(new_red,new_green,new_blue);
            }
        } 
    }

}
