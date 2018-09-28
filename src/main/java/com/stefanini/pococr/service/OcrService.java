package com.stefanini.pococr.service;

import java.io.File;

import org.springframework.stereotype.Service;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

@Service
public class OcrService {

	public String converterOcr(File imageFile) {
		ITesseract instance = new Tesseract();
		File tessData = LoadLibs.extractTessResources("tessdata");
		instance.setDatapath(tessData.getPath());

		try {
			String resultado = instance.doOCR(imageFile);
			System.out.println(resultado);
			return resultado;
		} catch (TesseractException e) {
			System.err.println(e.getMessage());
		}
		return "Arquivo vazio!";
	}
}