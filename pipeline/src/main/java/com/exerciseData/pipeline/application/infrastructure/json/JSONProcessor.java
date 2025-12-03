package com.exerciseData.pipeline.application.infrastructure.json;

import com.exerciseData.pipeline.domain.processor.DataProcessor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

// Minimal JSON handling for demo purposes; in a real app, use a library like Jackson or Gson.
public class JSONProcessor extends DataProcessor {

    private final String inputPath;
    private final String outputPath;
    private List<String> records = new ArrayList<>();

    public JSONProcessor(String inputPath, String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    @Override
    protected void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line.trim());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading JSON file", e);
        }
    }

    @Override
    protected void transform() {
        String timestamp = Instant.now().toString();
        List<String> transformed = new ArrayList<>();
        for (String record : records) {
            if (record.endsWith("}")) {
                // Very naive: inject a timestamp field before the closing brace.
                String withTs = record.substring(0, record.length() - 1)
                        + ", \"timestamp\": \"" + timestamp + "\"}";
                transformed.add(withTs);
            } else {
                transformed.add(record);
            }
        }
        records = transformed;
    }

    @Override
    protected void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            for (String record : records) {
                writer.write(record);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error saving JSON file", e);
        }
    }
}