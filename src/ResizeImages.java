import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class ResizeImages {
    public static void resizeImages(String inputImagePath, String outputImagePath){
        resizeImages(inputImagePath, outputImagePath,840,400);
    }

    public static void resizeImages(String inputImagePath, String outputImagePath,int scaledWidth, int scaledHeight) {
        try {
            File inputFile = new File(inputImagePath);
            BufferedImage inputImage = ImageIO.read(inputFile);

            // creates output image
            BufferedImage outputImage = new BufferedImage(scaledWidth,
                    scaledHeight, inputImage.getType());

            // scales the input image to the output image
            Graphics2D g2d = outputImage.createGraphics();
            g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
            g2d.dispose();

            // extracts extension of output file
            String formatName = outputImagePath.substring(outputImagePath
                    .lastIndexOf(".") + 1);

            // writes to output file
            ImageIO.write(outputImage, formatName, new File(outputImagePath));
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    public static void resizeImages(String inputImagePath, String outputImagePath, double percent){
        try {
            File inputFile = new File(inputImagePath);
            BufferedImage inputImage = ImageIO.read(inputFile);
            int scaledWidth = (int) (inputImage.getWidth() * percent);
            int scaledHeight = (int) (inputImage.getHeight() * percent);
            resizeImages(inputImagePath, outputImagePath, scaledWidth, scaledHeight);
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

    }
}
