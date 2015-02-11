package com.colourful.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/image")
public class ImageController {

	private static final String IMG_BASE_PATH = "C:\\Users\\WangQi\\git\\colourful\\colourful\\src\\main\\webapp\\resources\\images\\";
	private static final String NO_IMAGE = "noImage.jpg";

	@RequestMapping(value = "/imageDisplay/{imgFile:.*}", method = RequestMethod.GET)
	public void showImage(@PathVariable String imgFile, HttpServletResponse response, HttpServletRequest request) {

		show(imgFile, response, request);
	}

	@RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
	public void showNoImage(HttpServletResponse response, HttpServletRequest request) {

		show(NO_IMAGE, response, request);

	}

	private void show(String imgFile, HttpServletResponse response, HttpServletRequest request) {
		if (StringUtils.isEmpty(imgFile)) {
			imgFile = IMG_BASE_PATH.concat(NO_IMAGE);
		}

		imgFile = imgFile.replace("_", "\\");

		File file = new File(IMG_BASE_PATH.concat(imgFile));
		if (!file.exists()) {
			file = new File(IMG_BASE_PATH.concat(NO_IMAGE));
		}

		byte[] img;
		try {
			img = FileUtils.readFileToByteArray(file);

			response.setContentType("image/jpeg;image/jpg;image/png;image/gif");
			response.getOutputStream().write(img);

			response.getOutputStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}