package com.operative_systems.domain.model;

import com.operative_systems.domain.enums.AlgorithmType;

import java.util.List;

public class SimulationRequest {

    private final List<Integer> pageReferences;
    private final int frameCount;
    private final AlgorithmType algorithm;

    public SimulationRequest(
            List<Integer> pageReferences,
            int frameCount,
            AlgorithmType algorithm
    ) {
        this.pageReferences = List.copyOf(pageReferences);
        this.frameCount = frameCount;
        this.algorithm = algorithm;
    }

    public List<Integer> getPageReferences() {
        return pageReferences;
    }

    public int getFrameCount() {
        return frameCount;
    }

    public AlgorithmType getAlgorithm() {
        return algorithm;
    }
}