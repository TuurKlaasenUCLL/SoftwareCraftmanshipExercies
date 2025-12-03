package com.exerciseData.pipeline.application.infrastructure.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.exerciseData.pipeline.domain.processor.DataProcessor;

public class CSVProcessor extends DataProcessor {

    private final String inputPath;
    private final String outputPath;
    private StringBuilder data = new StringBuilder();

    public CSVProcessor(String inputPath, String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    @Override
    protected void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading CSV file", e);
        }
    }

    @Override
    protected void transform() {
        String[] lines = data.toString().split(System.lineSeparator());
        StringBuilder transformed = new StringBuilder();
        for (String line : lines) {
            transformed.append(line.toUpperCase()).append(System.lineSeparator());
        }
        data = transformed;
    }

    @Override
    protected void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write(data.toString());
        } catch (IOException e) {
            throw new RuntimeException("Error saving CSV file", e);
        }
    }
}