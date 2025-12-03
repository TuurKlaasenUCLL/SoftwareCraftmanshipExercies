package com.exerciseData.pipeline.application.interfaceAdapters.cli;

import com.exerciseData.pipeline.application.ProcessDataUseCase;
import com.exerciseData.pipeline.application.infrastructure.csv.CSVProcessor;
import com.exerciseData.pipeline.application.infrastructure.json.JSONProcessor;

public class DataPipelineCliController {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Usage: <csv|json> <inputPath> <outputPath>");
            System.exit(1);
        }

        String type = args[0];
        String inputPath = args[1];
        String outputPath = args[2];

        ProcessDataUseCase useCase = new ProcessDataUseCase();

        switch (type.toLowerCase()) {
            case "csv" -> useCase.run(new CSVProcessor(inputPath, outputPath));
            case "json" -> useCase.run(new JSONProcessor(inputPath, outputPath));
            default -> {
                System.err.println("Unknown type: " + type + " (expected csv or json)");
                System.exit(1);
            }
        }
    }
}
