package com.operative_systems.domain.model;

import com.operative_systems.domain.enums.AlgorithmType;

import java.util.List;

public class SimulationRequest {
    private List<Integer> pageReferences;
    private int frameCount;
    private AlgorithmType algorithm;

    public SimulationRequest(List<Integer> pageReferences, int frameCount, AlgorithmType algorithm) {
        this.pageReferences = pageReferences;
        this.frameCount = frameCount;
        this.algorithm = algorithm;
    }

    public List<Integer> getPageReferences() {
        return pageReferences;
    }

    public void setPageReferences(List<Integer> pageReferences) {
        this.pageReferences = pageReferences;
    }

    public int getFrameCount() {
        return frameCount;
    }

    public void setFrameCount(int frameCount) {
        this.frameCount = frameCount;
    }

    public AlgorithmType getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(AlgorithmType algorithm) {
        this.algorithm = algorithm;
    }
}
