
/*
 * Pictasty
 * 
 * LayerCounter - a Pages for OCG model counter on a PDF file
 *
 * author : Mario de Sa Vera (desavera@gmail.com)
 *
 */

import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LayerCounter {
	
	public static void countOCG(PdfReader reader, String... layers) throws IOException {

		int n = reader.getNumberOfPages();
		for (int i = 1; i <= n; i++)
			System.out.println("OCG PageNum : " + i);
	}

	public static void count(PdfReader reader, String... layers) throws IOException {

		int n = reader.getNumberOfPages();
		for (int i = 1; i <= n; i++)
			System.out.println("OCG PageNum : " + i);
	}
}
