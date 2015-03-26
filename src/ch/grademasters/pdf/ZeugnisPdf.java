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

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
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
				String file = "Zeugnisse/" + "Zeugnis" + i + "-"
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
			// Page Adden
			addTitlePage(document);
			// Dokument schliessen
			document.close();

			// Wenn alles gut geht, gibt es Okö aus.
			// System.out.println("Okö");
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

		String logo = "src/images/logo.png";
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
		addEmptyLine(preface, 2);
		preface.add(new Paragraph("Klassen-Informationen:"));
		for (Zeugnis zeugnisGross : zeugnis) {
			preface.add(zeugnisGross.toString());
			break;
		}
		addEmptyLine(preface, 6);
		preface.add(new Paragraph("_____________________________________",
				helvetica3));
		preface.add(new Paragraph("Herzliche Gratulation zu Deinem Zeugnis!"));
		preface.add(new Paragraph("Freundliche Grüsse"));
		preface.add(new Paragraph("Dein GradeMasters Team"));

		document.add(preface);
		// Neue Seite
		document.newPage();
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
