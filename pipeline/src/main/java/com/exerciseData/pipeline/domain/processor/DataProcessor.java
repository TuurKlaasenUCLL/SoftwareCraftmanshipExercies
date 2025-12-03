package com.exerciseData.pipeline.domain.processor;

public abstract class DataProcessor {

    public final void process() {
        load();
        if (validateData()) {
            transform();
            save();
        } else {
            System.err.println("Data validation failed. Processing aborted.");
        }
    }

    protected abstract void load();

    protected abstract void transform();

    protected abstract void save();

    protected boolean validateData() {
        return true;
    }
}
