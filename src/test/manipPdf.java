package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BadPdfFormatException;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfReader;

/*import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BadPdfFormatException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;*/

public class manipPdf {
	
	public static void main(String[] args) {
	
		/* chapter02/HelloWorldCopy.java */
		PdfReader reader = null;
		try {
			reader = new PdfReader("/home/beng/Azureus Downloads/iText In Action - Creating And Manipulating PDF.pdf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document document = new Document(reader.getPageSizeWithRotation(1));
		PdfCopy copy = null;
		try {
			copy = new PdfCopy(document,
			new FileOutputStream("/home/beng/Azureus Downloads/HelloWorldPdfCopy123.pdf"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.open();
		System.out.println("Tampered? " + reader.isTampered());
		try {
			
			copy.addPage(copy.getImportedPage(reader, 1));
			copy.addPage(copy.getImportedPage(reader, 5));
			copy.addPage(copy.getImportedPage(reader, 7));
			copy.addPage(copy.getImportedPage(reader, 24));
		System.out.println("Tampered? " + reader.isTampered());
		} catch (BadPdfFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.close();

	}
	
	public void generate_html(){
		
		
	}

}
