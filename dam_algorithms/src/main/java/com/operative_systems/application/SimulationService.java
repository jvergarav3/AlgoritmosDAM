package com.operative_systems.application;

import com.operative_systems.domain.algorithm.*;
import com.operative_systems.domain.enums.AlgorithmType;
import com.operative_systems.domain.model.*;

import java.util.Map;

public class SimulationService {

    private final Map<AlgorithmType, PageReplacementAlgorithm> algorithms;

    public SimulationService() {
        this.algorithms = Map.of(
                AlgorithmType.FIFO, new FIFOAlgorithm(),
                AlgorithmType.LRU, new LRUAlgorithm(),
                AlgorithmType.OPT, new OPTAlgorithm()
        );
    }

    public SimulationResult simulate(SimulationRequest request) {

        PageReplacementAlgorithm algorithm =
                algorithms.get(request.getAlgorithm());

        if (algorithm == null) {
            throw new IllegalArgumentException(
                    "Unsupported algorithm: " + request.getAlgorithm()
            );
        }

        return algorithm.execute(
                request.getPageReferences(),
                request.getFrameCount()
        );
    }
}