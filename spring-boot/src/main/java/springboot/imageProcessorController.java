package springboot;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.servlet.ServletInputStream;
import org.springframework.beans.factory.annotation.Autowired;
public class imageProcessorController {
	
	public static BufferedImage image;
	
	public static BufferedImage setImage(ServletInputStream is)throws Exception {
		image = ImageIO.read(is);
		return image;
	}
	
}
