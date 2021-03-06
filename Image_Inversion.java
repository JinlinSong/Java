/**
 * Image Inversion
 * 
 * Jinlin
 * 12/19/2017 18:17:00 PST
 */
import edu.duke.*;
import java.io.*;

public class Image_Inversion {
    public ImageResource makeInverse(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel pixel: outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            pixel.setRed(255 - inPixel.getRed());
            pixel.setGreen(255 - inPixel.getBlue());
            pixel.setBlue(255 - inPixel.getGreen());
        }
        return outImage;
    }

    public void selectAndConvert () {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            String fname = inImage.getFileName();
            ImageResource gray = makeInverse(inImage);
            String newName = "images/inverted-" + fname;
            gray.setFileName(newName);
            gray.save();
        }
    }
}