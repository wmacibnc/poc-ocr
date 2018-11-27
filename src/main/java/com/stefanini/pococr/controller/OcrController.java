package com.stefanini.pococr.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.pococr.service.OcrService;

@RestController
@RequestMapping("ocr")
public class OcrController {

	@Autowired
	OcrService ocrService;

	// Passar por parametro o arquivo - definir o objeto com autor, data...
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Object hello() {
		File imageFile = new File("test.png");
		return ocrService.converterOcr(imageFile);
	}
}