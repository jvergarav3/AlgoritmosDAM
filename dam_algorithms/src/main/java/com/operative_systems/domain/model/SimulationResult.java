package com.operative_systems.domain.model;

import com.operative_systems.domain.enums.AlgorithmType;

import java.util.List;

public class SimulationResult {
    private AlgorithmType algorithm;
    private List<SimulationStep> steps;
    private AlgorithmSummary summary;

    public SimulationResult(AlgorithmType algorithm, List<SimulationStep> steps, AlgorithmSummary summary) {
        this.algorithm = algorithm;
        this.steps = steps;
        this.summary = summary;
    }

    public AlgorithmType getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(AlgorithmType algorithm) {
        this.algorithm = algorithm;
    }

    public List<SimulationStep> getSteps() {
        return steps;
    }

    public void setSteps(List<SimulationStep> steps) {
        this.steps = steps;
    }

    public AlgorithmSummary getSummary() {
        return summary;
    }

    public void setSummary(AlgorithmSummary summary) {
        this.summary = summary;
    }
}