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
	// SChriftart mit ihren verschiedenen Attributen: Schritart, Groesse und
	// Style
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
	// Variable Int fuer klassen_ID
	private static int klasse_ID;

	// Getter und Setter fuer klasse_ID
	private static int getKlasse_ID() {
		return klasse_ID;
	}

	private void setKlasse_ID(int klasse_ID) {
		ZeugnisPdf.klasse_ID = klasse_ID;
	}

	/**
	 * @descrption Erstellt das Zeugnis
	 * @param klasse_ID
	 */
	public ZeugnisPdf(int klasse_ID) {
		this.setKlasse_ID(klasse_ID);

		try {
			// boolean fuer die Variable exist
			boolean exist = true;
			// Neues Dokument anlegen
			Document document = new Document();
			// Neuer Output Stream
			// Macht solange exist == true ist
			while (exist == true) {
				// Output Ordner + file Name
				String file = "Zeugnisse/" + "Zeugnis" + i + "-"
						+ aktuellesDatum.format(zeitStempel) + ".pdf";
				// Wenn das File schon existiert, dann benenne es um, indem der
				// Zaehler um 1 erhoeht wird
				if (new File(file).exists()) {
					// Zaehler erhoehen
					i = i + 1;
				}
				// Sonst
				else {
					// Schreibe ein neues File
					PdfWriter.getInstance(document, new FileOutputStream(file));
					// exist auf false setzen, dass keine Unendlich Schlaufe
					// produziert wird
					exist = false;
				}

			}
			document.open();
			// Meta Tags adden
			addMetaData(document);
			// Page Adden
			addContentPage(document);
			// Dokument schliessen
			document.close();

			// Wenn alles gut geht, gibt es Okö aus.
			// System.out.println("Okö");
			i = i + 1;
		}
		// Exception behandeln
		catch (FileNotFoundException | DocumentException e) {
			// Wenn das File oder der Ordner nicht gefunden werden konnte, dann
			// gibt es folgenden Text aus:
			System.err
					.println("Kein Zugriff auf den Ordner"
							+ "Grademasters/Zeugnisse/"
							+ "\n"
							+ "Bitte überprüfen Sie den Pfad, ob der Ordner vorhanden ist!"
							+ "\n");
			System.out
					.println("Wenn das Problem weiter besteht, Melden Sie sich bitte beim Entwickler."
							+ "\n\n" + "**Error-Meldung:**" + "\n");
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

	/**
	 * @description Erstellt die Meta-Tags fuer das PDF File
	 * @param document
	 */
	private static void addMetaData(Document document) {
		document.addTitle("Zegnis Nr." + i);
		document.addSubject("Created with iText by GradeMasters");
		document.addKeywords("GradeMasters, Zeugnis, Schule, Note, Fach, Cooles Programm, Quizmasters.ch");
		document.addAuthor("GradeMasters");
		document.addCreator("GradeMasters");
	}

	/**
	 * @description erstellt das ganze File
	 * @param document
	 * @throws DocumentException
	 */
	private static void addContentPage(Document document)
			throws DocumentException {
		// Neuer Paragraph erstellen, welcher das ganze PDF ist
		Paragraph ganzesPdfFile = new Paragraph();

		// Pfad des Logos
		String logo = "src/images/logo.png";
		Image image = null;
		// Versuchen das Logo zu laden
		try {
			image = Image.getInstance(logo);
		}
		// Exception behandeln
		catch (MalformedURLException e) {
			System.err.println("Das Logo konnte nicht geladen werden!");
			System.out.println("\n\nFehler-Meldung:\n");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.err.println("Das Logo konnte nicht geladen werden!");
			System.out.println("\n\nFehler-Meldung:\n");
			e.printStackTrace();
		}
		// Bildposition setzen
		image.setAbsolutePosition(465f, 720f);
		// Bild skalieren auf gewuenschte Groesse (90x90)
		image.scaleAbsolute(90, 90);

		// Zeugnis Liste
		ArrayList<Zeugnis> zeugnis = GMController.getInstance().getZeugnis(
				getKlasse_ID());

		/* Layout */
		// Leere Zeile(n) Anzahl(1) hinzufuegen
		addEmptyLine(ganzesPdfFile, 1);
		// Titel von dem PDF hinzufuegen
		ganzesPdfFile.add(new Paragraph("Zeugnis Nr. " + i, helvetica1));
		// Bild dem PDF hinzufuegen (Logo Gm)
		ganzesPdfFile.add(image);
		// Leere Zeile(n) Anzahl(2) hinzufuegen
		addEmptyLine(ganzesPdfFile, 2);
		// Ueberschrift fuer den Inhalt an das PDF adden
		ganzesPdfFile.add(new Paragraph("Zeugnis erstellt von: "
				+ System.getProperty("user.name") + ", "
				+ aktuellesDatum.format(zeitStempel) + " - "
				+ aktuelleZeit.format(zeitStempel), helvetica2));
		// Leere Zeile(n) Anzahl(1) hinzufuegen
		addEmptyLine(ganzesPdfFile, 1);
		// Hinweis hinzufuegen
		ganzesPdfFile
				.add(new Paragraph(
						"Dein erstelltes Zeugnis ist nicht dein Endzeugnis. Hier fliessen keine Mündlichen Noten, etc. mit ein!",
						helvetica3));
		// Trennlinie hinzufuegen
		ganzesPdfFile
				.add(new Paragraph(
						"_____________________________________________________________________________"));
		// Leere Zeile(n) Anzahl(2) hinzufuegen
		addEmptyLine(ganzesPdfFile, 2);
		// TExt hinzufuegen
		ganzesPdfFile.add(new Paragraph("Klassen-Informationen:"));
		// Zeugnis Informationen herauslesen
		for (Zeugnis zeugnisGross : zeugnis) {
			ganzesPdfFile.add(zeugnisGross.toString());
			break;
		}
		// Leere Zeile(n) Anzahl(3) hinzufuegen
		addEmptyLine(ganzesPdfFile, 3);
		// Trennlinie hinzufuegen
		ganzesPdfFile.add(new Paragraph(
				"_____________________________________", helvetica3));
		// Text hinzufuegen
		ganzesPdfFile.add(new Paragraph(
				"Herzliche Gratulation zu Deinem Zeugnis!"));
		// Gruss Zeile hinzufuegen
		ganzesPdfFile.add(new Paragraph("Freundliche Grüsse"));
		ganzesPdfFile.add(new Paragraph("Dein GradeMasters Team"));
		// ganzes PDF an dem Dokument hinzufuegen
		document.add(ganzesPdfFile);
		// Neue Seite erstellen
		document.newPage();
	}

	/**
	 * @description Leere Linie hinzufuegen
	 * @param paragraph
	 * @param number
	 */
	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}
