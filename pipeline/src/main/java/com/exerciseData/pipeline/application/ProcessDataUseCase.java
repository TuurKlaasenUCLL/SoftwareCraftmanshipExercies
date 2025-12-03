package com.exerciseData.pipeline.application;

import com.exerciseData.pipeline.domain.processor.DataProcessor;

public class ProcessDataUseCase {

    public void run(DataProcessor processor) {
        processor.process();
    }
}