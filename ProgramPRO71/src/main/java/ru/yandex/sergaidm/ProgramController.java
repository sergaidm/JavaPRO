package ru.yandex.sergaidm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;
import java.util.List;

@Controller
@EnableWebMvc
public class ProgramController {

	@Autowired
	private PhotoRepository photoRepository;

	@GetMapping("/")
	public String openHomePage() {
		return "index";
	}

	@PostMapping("/add_photos")
	public String addPhotos(@RequestParam("images") List<MultipartFile> files, Model model) {			
		try {
			for (MultipartFile file : files) {
				photoRepository.save(new Photo(file.getBytes()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Iterable<Photo> photos = photoRepository.findAll();
		model.addAttribute("photos", photos);
		return "photo_database";
	}

	@GetMapping({"/photo_database", "/delete_photos", "/add_photos"})
	@PostMapping("/photo_database")
	public String photoPage(Model model) {
		Iterable<Photo> photos = photoRepository.findAll();
		model.addAttribute("photos", photos);
		return "photo_database";
	}

	@PostMapping("/delete_photos")
	public String deletePhotos(Model model, @RequestParam("checkbox") List<Integer> id) {
		for (Integer number : id) {
			photoRepository.deleteById(number);
		}
		Iterable<Photo> photos = photoRepository.findAll();
		model.addAttribute("photos", photos);
		return "photo_database";
	}

	@GetMapping("/view_photo/{photo_id}")
	public ResponseEntity<byte[]> viewPhoto(@PathVariable("photo_id") Integer id) {
		byte[] data = photoRepository.findById(id).get().getData();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<byte[]>(data, headers, HttpStatus.OK);
	}

}
