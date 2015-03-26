package ch.grademasters.diagramm;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import ch.grademasters.controller.GMController;
import ch.grademasters.model.Fach;

public class CreateDiagramm extends JFrame {
	private static final long serialVersionUID = 1L;

	/**
	 * Neue Instanz
	 *
	 * @param Name
	 *            des Frames
	 */
	public CreateDiagramm(final String title){

		super(title);

		final CategoryDataset dataset = createDataset();
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(750, 440));
		setContentPane(chartPanel);
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
	}

	/**
	 * Alle Daten
	 * 
	 * @return gibt alle Daten zurueck
	 */
	private CategoryDataset createDataset() {
		ArrayList<Fach> faecher = GMController.getInstance().getNotenUndFach();

		// Legende
		final String series = "Rot";

		// Spaltennamen Array
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (Fach fach : faecher) {

			// Alle Daten
			dataset.addValue(fach.berechneZeugnisNote(), series, fach.getFach());

		}
		return dataset;

	}

	/**
	 * Erstellen des Diagrammes
	 * @param Objekt
	 *            vom Typ Dataset  
	 * @return Das Diagramm
	 */
	private JFreeChart createChart(final CategoryDataset dataset) {

			// Erstellen des Diagramms
		final JFreeChart chart = ChartFactory.createBarChart(
				"Diagramm aller Fächer", // Titel
				"Fächer", // Legende
				"Noten", // Y-Achse
				dataset, // Daten
				PlotOrientation.VERTICAL, // Ausrichtung
				false, // Legende Ja/Nein
				true, // tooltips braucht es einfach
				false // URLs braucht es einfach
		);

		return chart;

	}

}
