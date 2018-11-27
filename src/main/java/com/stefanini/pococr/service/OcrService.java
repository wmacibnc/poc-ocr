package com.stefanini.pococr.service;

import java.io.File;

import org.springframework.stereotype.Service;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

@Service
public class OcrService {

	public String converterOcr(File imageFile) {
		ITesseract instance = new Tesseract();
		String dir = "/usr/share/tesseract-ocr/4.00/tessdata";
		instance.setDatapath(dir);
        instance.setTessVariable("LC_NUMERIC", "C");
        instance.setLanguage("por");


		try {
			String resultado = instance.doOCR(imageFile);
			System.out.println(resultado);
			resultado = resultado.replaceAll("\n", "</br>");
			String[] teste = resultado.split("</br>");

			StringBuilder resultadoFormatado = new StringBuilder();

			resultadoFormatado.append("<h3>" + teste[0] + "</h3>");
			Boolean first = true;
			for (String r : teste) {
				if (first) {
					first = false;
				} else {
					resultadoFormatado.append("</br>");
					resultadoFormatado.append(r);
				}
			}
			return resultadoFormatado.toString();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return "Arquivo vazio!";
	}
}