package test.labor;

import java.awt.Dimension;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class Diagramm extends ApplicationFrame {

    /**
     * Neue Instanz
     *
     * @param Name des Frames
     */
    public Diagramm(final String title) {

        super(title);

        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);

    }

    /**
     * Alle Daten
     * 
     * @return gibt alle Daten zurueck
     */
    private CategoryDataset createDataset() {
        
        // Legende
        final String series1 = "Rot";
        final String series2 = "Blau";
        final String series3 = "Grün";

        // Spaltennamen
        final String category1 = "Hund";
        final String category2 = "Maus";
        final String category3 = "Löwe";
        final String category4 = "Tiger";
        final String category5 = "Katze";

        // Erstellt die das Dataset
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        //Alle Daten
        dataset.addValue(1.0, series1, category1);
        dataset.addValue(4.0, series1, category2);
        dataset.addValue(3.0, series1, category3);
        dataset.addValue(5.0, series1, category4);
        dataset.addValue(5.0, series1, category5);

        dataset.addValue(5.0, series2, category1);
        dataset.addValue(7.0, series2, category2);
        dataset.addValue(6.0, series2, category3);
        dataset.addValue(8.0, series2, category4);
        dataset.addValue(4.0, series2, category5);

        dataset.addValue(4.0, series3, category1);
        dataset.addValue(3.0, series3, category2);
        dataset.addValue(2.0, series3, category3);
        dataset.addValue(3.0, series3, category4);
        dataset.addValue(6.0, series3, category5);
        
        //gibt alle Daten im Dataset zurueck
        return dataset;
        
    }
    
    /**
     * Erstellen des Diagrammes
     * 
     * @param Objekt vom Typ Dataset
     * 
     * @return Das Diagramm
     */
    private JFreeChart createChart(final CategoryDataset dataset) {
        
        // Erstellen des Diagramms
        final JFreeChart chart = ChartFactory.createBarChart(
            "Beispiel",      			// Titel
            "Kategorien",               // Legende
            "Werte",                  	// Y-Achse
            dataset,                  	// Daten
            PlotOrientation.VERTICAL, 	// Ausrichtung
            true,                     	// Legende Ja/Nein
            true,                     	// tooltips braucht es einfach
            false                     	// URLs braucht es einfach
        );

        return chart;
        
    }
    
    /**
     * Startet die Applikation
     */
    public static void main(final String[] args) {

        final Diagramm demo = new Diagramm("Bar Chart Demo");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

}