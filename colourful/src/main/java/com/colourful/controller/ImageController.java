package com.colourful.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/image")
public class ImageController {

	private static final String IMG_BASE_PATH = "C:\\Users\\WangQi\\git\\mxtty\\colourful\\colourful\\src\\main\\webapp\\resources\\images\\";

	@RequestMapping(value = "/imageDisplay/{imagePath}", method = RequestMethod.GET)
	public void showImage(@PathVariable("imagePath") String imagePath,
			HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		System.out.println("IMG_PATH:" + imagePath);
		byte[] img = FileUtils.readFileToByteArray(new File(IMG_BASE_PATH
				+ imagePath));

		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(img);

		response.getOutputStream().close();
	}
}