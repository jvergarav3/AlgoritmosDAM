package com.operative_systems.domain.algorithm;

import com.operative_systems.domain.model.SimulationResult;

import java.util.List;

public interface PageReplacementAlgorithm {
    SimulationResult execute(List<Integer> pageReferences, int frameCount);
}
