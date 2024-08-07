package largedatafileprocessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessing {

    public static void main(String[] args) {
        String inputFile = "src/largedatafileprocessing/transactions";
        String outputFile = "src/largedatafileprocessing/filtered_transactions";
        double thresholdAmount = 1000.0;

        try {
            processTransactions(inputFile, outputFile, thresholdAmount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processTransactions(String inputFile, String outputFile, double thresholdAmount) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length != 4) {
                    System.err.println("Skipping invalid record: " + line);
                    continue;
                }

                String transactionId = fields[0];
                String customerId = fields[1];
                double transactionAmount;
                try {
                    transactionAmount = Double.parseDouble(fields[2]);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid transaction amount in record: " + line);
                    continue;
                }
                String date = fields[3];

                if (transactionAmount > thresholdAmount) {
                    writer.write(transactionId + "," + customerId + "," + transactionAmount + "," + date);
                    writer.newLine();
                }
            }
        }
    }
}