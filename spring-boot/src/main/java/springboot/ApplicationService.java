package springboot;

import com.sun.prism.paint.Color;

import javax.imageio.ImageIO;
import javax.servlet.ServletInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

	public static Map<String, BufferedImage> Fotki = new HashMap<>();

	public Map<String, BufferedImage> getAll() {
		return Fotki;
	}

	
	public String getFotki(String id) {
		JSONObject json = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			jsonArray.put("Rozmiar: "+ Fotki.get(id).getWidth() +"x"+Fotki.get(id).getHeight());
			try {
				json.put("Rozmiar zdjecia", jsonArray);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return json.toString();
	}


	public static byte[] getCrop(String id, String start, String stop, String width, String height) throws IOException {
		BufferedImage source = Fotki.get(id);
		if (source == null) {
			return null;
		}

		Rectangle rect = new Rectangle(Integer.parseInt(width), Integer.parseInt(height));
		BufferedImage destination = source.getSubimage(Integer.parseInt(start), Integer.parseInt(stop), rect.width,
				rect.height);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(destination, "png", baos);
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();
		return imageInByte;
	}
}
