import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class ReformatImages {

    public static void reformatImages(){
        File image = new File("resource/0e6267741b99b782dd8398350dc8cc7cfa56efc3_50w7r5r.png");
        File outputImage = new File("tes1t.jpg");

        try (InputStream is = new FileInputStream(image)){
            BufferedImage bufferedImage = ImageIO.read(is);
            try (OutputStream os = new FileOutputStream(outputImage)) {
                ImageIO.write(bufferedImage, "jpg", os);
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(outputImage.toString());
    }
}
