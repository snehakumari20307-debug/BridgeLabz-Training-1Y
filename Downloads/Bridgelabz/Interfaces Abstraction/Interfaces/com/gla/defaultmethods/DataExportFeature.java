package com.gla.defaultmethods;
interface DataExporter {
    void exportToCSV();
    void exportToPDF();

    // Default method to export JSON
    default void exportToJSON() {
        System.out.println("Exporting data in JSON format (default implementation).");
    }
}

// Report class
class SalesReport implements DataExporter {
    @Override
    public void exportToCSV() {
        System.out.println("Exporting SalesReport to CSV");
    }

    @Override
    public void exportToPDF() {
        System.out.println("Exporting SalesReport to PDF");
    }
}

// Demo
public class DataExportFeature {
    public static void main(String[] args) {
        DataExporter report = new SalesReport();

        report.exportToCSV();
        report.exportToPDF();
        report.exportToJSON(); // default method
    }
}

