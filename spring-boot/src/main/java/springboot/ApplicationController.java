package springboot;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	@RequestMapping("/hello")
	public String sayHi() {
		String temp = "";
		for (int i = 0; i < applicationService.Fotki.size(); i++) {
			temp += applicationService.Fotki.containsKey(i);
		}
		return temp;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/image")
	public String addImage(HttpServletRequest requestEntity) throws Exception {
		BufferedImage temp = imageProcessorController.setImage(requestEntity.getInputStream());
		String id = Application.createID();
		applicationService.Fotki.put(id, temp);
		return "Dodano zdjecie o ID: " + id;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}/image")
	public String deleteImage(@PathVariable String id) throws Exception {
		applicationService.Fotki.remove(id);
		return "Usunieto zdjecie o ID: " + id;
	}

	@RequestMapping(value = "/{id}/size", produces = MediaType.APPLICATION_JSON_VALUE)
	public String imageSize(@PathVariable String id) {
		return applicationService.getFotki(id);
	}



	@RequestMapping(value = "/{id}/crop", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> getCroppedImage(@PathVariable("id") String id,
			@RequestParam(value = "start") String start, @RequestParam(value = "stop") String stop,
			@RequestParam(value = "width") String width, @RequestParam(value = "height") String height)
			throws IOException {
		byte[] image = applicationService.getCrop(id, start, stop, width, height);
		if (image == null) 
			return new ResponseEntity<byte[]>(image, HttpStatus.NOT_FOUND);
		 else 
			return new ResponseEntity<byte[]>(image, HttpStatus.OK);
	}
}