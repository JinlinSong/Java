
/**
 * convert color images to gray-scale images
 * 
 * Jinlin
 * 12/19/2017 18:17:00 PST
 */

import edu.duke.*;
import java.io.*;

public class Batch_Grayscale {
    public ImageResource makeGray(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel pixel: outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }
        return outImage;
    }

    public void selectAndConvert () {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            String fname = inImage.getFileName();
            ImageResource gray = makeGray(inImage);
            String newName = "images/gray_" + fname;
            gray.setFileName(newName);
            gray.save();
        }
    }
}