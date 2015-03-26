package ch.grademasters.pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import ch.grademasters.controller.GMController;
import ch.grademasters.model.Zeugnis;
import ch.grademasters.view.GradeMastersView;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ZeugnisPdf {
	/* Schriften erstellen */
	private static Font helvetica1 = new Font(Font.FontFamily.HELVETICA, 22,
			Font.BOLD);
	private static Font helvetica2 = new Font(Font.FontFamily.HELVETICA, 16,
			Font.BOLD);
	private static Font helvetica3 = new Font(Font.FontFamily.HELVETICA, 11,
			Font.BOLD, BaseColor.RED);

	// ZeitStempel hinzufuegen
	static Date zeitStempel = new Date();
	// Zaehler
	private static int i = 1;
	// Aktuelles Datum
	static SimpleDateFormat aktuellesDatum = new SimpleDateFormat("dd.MM.yyyy");
	// Aktuelle Zeit
	static SimpleDateFormat aktuelleZeit = new SimpleDateFormat("HH:mm:ss");

	private static int klasse_ID;

	// Output Ordner

	private static int getKlasse_ID() {
		return klasse_ID;
	}

	private void setKlasse_ID(int klasse_ID) {
		ZeugnisPdf.klasse_ID = klasse_ID;
	}

	public ZeugnisPdf(int klasse_ID) {
		this.setKlasse_ID(klasse_ID);

		try {
			boolean exist = true;
			// Neues Dokument anlegen
			Document document = new Document();
			// Neuer Output Stream
			// Macht solange exist == true ist
			while (exist == true) {
				// Output Ordner + file Name
				String file = "D:/Users/zmartl/Desktop/" + "Zeugnis" + i + "-"
						+ aktuellesDatum.format(zeitStempel) + ".pdf";
				// Wenn das File schon existiert, dann benenne es um
				if (new File(file).exists()) {
					// Zaehler erhoehen
					i = i + 1;
				}
				// Sonst
				else {
					// Schreibe ein neues File
					PdfWriter.getInstance(document, new FileOutputStream(file));
					// exist auf false setzen, dass keine Unendlich SChlaufe
					// produziert wird
					exist = false;
				}

			}
			document.open();
			// Meta Tags adden
			addMetaData(document);
			// Titel adden
			addTitlePage(document);
			// Content adden
			addContent(document);
			// Dokument schliessen
			document.close();

			// Wenn alles gut geht, gibt es Okö aus.
			//System.out.println("Okö");
			i = i + 1;
			// Exception behandeln
		}
		catch (FileNotFoundException | DocumentException e) {
			System.err.println("Kein Zugriff auf den Ordner." + "\n"
					+ "Bitte überprüfen Sie den Pfad!" + "\n");
			System.out
					.println("Wenn das Problem weiter besteht, Melden Sie sich bitte beim Entwickler."
							+ "\n" + "Error-Meldung:" + "\n");
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @description Stellt das PDF zusammen
	 * @param args
	 */
	// public static void main(String[] args) {
	//
	//
	// }

	private static void addMetaData(Document document) {
		document.addTitle("Zegnis Nr." + i);
		document.addSubject("Created with iText by GradeMasters");
		document.addKeywords("GradeMasters, Zeugnis, Schule, Note, Fach, Cooles Programm");
		document.addAuthor("GradeMasters");
		document.addCreator("GradeMasters");
	}

	private static void addTitlePage(Document document)
			throws DocumentException {
		Paragraph preface = new Paragraph();

		String logo = "T:/_Team/zmartl/workspace/Backup/1312 - 20032015/Grademasters/src/images/logo.png";
		Image image = null;
		try {
			image = Image.getInstance((logo));
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		image.setAbsolutePosition(465f, 720f);
		image.scaleAbsolute(90, 90);

		ArrayList<Zeugnis> zeugnis = GMController.getInstance().getZeugnis(
				getKlasse_ID());

		/* Layout */
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("Zeugnis Nr. " + i, helvetica1));
		preface.add(image);
		addEmptyLine(preface, 2);
		preface.add(new Paragraph("Zeugnis erstellt von: "
				+ System.getProperty("user.name") + ", "
				+ aktuellesDatum.format(zeitStempel) + " - "
				+ aktuelleZeit.format(zeitStempel), helvetica2));
		addEmptyLine(preface, 1);
		preface.add(new Paragraph(
				"Dein erstelltes Zeugnis ist nicht dein Endzeugnis. Hier fliessen keine Mündlichen Noten, etc. mit ein!",
				helvetica3));
		preface.add(new Paragraph(
				"_____________________________________________________________________________"));
		addEmptyLine(preface, 3);
		preface.add(new Paragraph("Klassen-Informationen:"));
		addEmptyLine(preface, 1);
//		preface.add(new Paragraph("Klasse: \t \t"));
//		preface.add(new Paragraph("Test:"));
		for (Zeugnis zeugnisGross : zeugnis) {
			preface.add(zeugnisGross.toString());
			break;
		}

		document.add(preface);
		// Neue Seite
		document.newPage();
	}

	private static void addContent(Document document) throws DocumentException {
		Anchor anchor = new Anchor("First Chapter");
		Chapter catPart = new Chapter(new Paragraph(anchor), 1);
		Paragraph subPara = new Paragraph("Subcategory 1");
		Section subCatPart = catPart.addSection(subPara);
		subCatPart.add(new Paragraph("Hello"));

		subPara = new Paragraph("Subcategory 2");
		subCatPart = catPart.addSection(subPara);
		subCatPart.add(new Paragraph("Paragraph 1"));
		subCatPart.add(new Paragraph("Paragraph 2"));
		subCatPart.add(new Paragraph("Paragraph 3"));

		// add a list
		createList(subCatPart);
		Paragraph paragraph = new Paragraph();
		addEmptyLine(paragraph, 5);
		subCatPart.add(paragraph);

		// add a table
		createTable(subCatPart);

		// now add all this to the document
		document.add(catPart);

		// Next section
		anchor = new Anchor("Second Chapter");
		anchor.setName("Second Chapter");

		// Second parameter is the number of the chapter
		catPart = new Chapter(new Paragraph(anchor), 1);

		subPara = new Paragraph("Subcategory");
		subCatPart = catPart.addSection(subPara);
		subCatPart.add(new Paragraph("This is a very important message"));

		// now add all this to the document
		document.add(catPart);

	}

	private static void createTable(Section subCatPart)
			throws BadElementException {
		PdfPTable table = new PdfPTable(3);

		// t.setBorderColor(BaseColor.GRAY);
		// t.setPadding(4);
		// t.setSpacing(4);
		// t.setBorderWidth(1);

		PdfPCell c1 = new PdfPCell(new Phrase("Table Header 1"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Table Header 2"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Table Header 3"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(c1);
		table.setHeaderRows(1);

		table.addCell("1.0");
		table.addCell("1.1");
		table.addCell("1.2");
		table.addCell("2.1");
		table.addCell("2.2");
		table.addCell("2.3");

		subCatPart.add(table);

	}

	private static void createList(Section subCatPart) {
		List list = new List(true, false, 10);
		list.add(new ListItem("First point"));
		list.add(new ListItem("Second point"));
		list.add(new ListItem("Third point"));
		subCatPart.add(list);
	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	public static Icon loadIcon(String iconName) {
		final URL resource = GradeMastersView.class.getResource("/images/"
				+ iconName);

		if (resource == null) {
			System.err.println("Error in " + GradeMastersView.class.getName()
					+ ": Icon /images/" + iconName + " could not be loaded.");
			return new ImageIcon();
		}
		return new ImageIcon(resource);
	}

}
