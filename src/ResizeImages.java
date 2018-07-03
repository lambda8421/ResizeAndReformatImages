import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class ResizeImages {
    public static void resizeImages(int scaledWidth, int scaledHeight) {
        try {
            String inputImagePath = "resource/1c2f19c60f349dc392533521bc385e65c8567ae0.jpeg";
            String outputImagePath = "resource/xxx.jpeg";
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

    public static void resizeImages(double percent){

        String inputImagePath = "resource/1c2f19c60f349dc392533521bc385e65c8567ae0.jpeg";
        String outputImagePath = "resource/xxx.jpeg";

        try {
            File inputFile = new File(inputImagePath);
            BufferedImage inputImage = ImageIO.read(inputFile);
            int scaledWidth = (int) (inputImage.getWidth() * percent);
            int scaledHeight = (int) (inputImage.getHeight() * percent);
            resizeImages(scaledWidth, scaledHeight);
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

    }
}
