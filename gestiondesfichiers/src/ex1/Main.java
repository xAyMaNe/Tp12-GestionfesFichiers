package ex1;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            // Exercice 1
            System.out.println("=== EXERCICE 1: LECTURE ===");
            Textraider.readLines("input.txt");
            
            // Exercice 2
            System.out.println("\n=== EXERCICE 2: COPIE ===");
            TextWriter.copyWithSummary("input.txt", "output.txt");
            
            // Exercice 3: CSV
            System.out.println("\n=== EXERCICE 3: CSV PARSING ===");
            List<Record> allRecords = CsvParser.readCsv("data.csv");
            System.out.println("Total records: " + allRecords.size());
            
            List<Record> passedRecords = allRecords.stream()
                .filter(r -> r.score >= 50)
                .collect(Collectors.toList());
            CsvParser.writeCsv(passedRecords, "passed.csv");
            
            // Exercice 4: Sérialisation
            System.out.println("\n=== EXERCICE 4: SÉRIALISATION ===");
            ObjectSerializer.serialize(passedRecords, "records.ser");
            System.out.println("records.ser créé");
            
            List<Record> deserialized = ObjectSerializer.deserialize("records.ser");
            System.out.println("Désérialisé: " + deserialized.size() + " records");
            System.out.println("Premier record: " + deserialized.get(0));
            
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }
}
