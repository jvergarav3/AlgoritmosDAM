package com.operative_systems.domain.algorithm;

import com.operative_systems.domain.enums.AlgorithmType;
import com.operative_systems.domain.model.AlgorithmSummary;
import com.operative_systems.domain.model.SimulationResult;
import com.operative_systems.domain.model.SimulationStep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Algoritmo LRU (Least Recently Used).
 * Reemplaza la pagina que fue usada hace mas tiempo.
 */
public class LRUAlgorithm implements PageReplacementAlgorithm {

    @Override
    public SimulationResult execute(List<Integer> pageReferences, int frameCount) {
        int[] frames = new int[frameCount];
        Arrays.fill(frames, -1);

        // Registra en que paso se uso cada pagina por ultima vez
        Map<Integer, Integer> lastUsed = new HashMap<>();
        List<SimulationStep> steps = new ArrayList<>();
        int hits = 0;
        int pageFaults = 0;

        for (int stepIndex = 0; stepIndex < pageReferences.size(); stepIndex++) {
            int page = pageReferences.get(stepIndex);

            if (findFrameIndex(frames, page) >= 0) {
                hits++;
                lastUsed.put(page, stepIndex);
                steps.add(new SimulationStep(
                        page,
                        copyFrames(frames),
                        false,
                        "Página ya presente en memoria"
                ));
                continue;
            }

            pageFaults++;
            String action;

            int emptyIndex = findEmptyFrame(frames);
            if (emptyIndex >= 0) {
                frames[emptyIndex] = page;
                lastUsed.put(page, stepIndex);
                action = "Página cargada en marco vacío";
            } else {
                // Elegir la pagina con el uso mas antiguo
                int evictedPage = findLeastRecentlyUsed(frames, lastUsed);
                int evictIndex = findFrameIndex(frames, evictedPage);
                frames[evictIndex] = page;
                lastUsed.remove(evictedPage);
                lastUsed.put(page, stepIndex);
                action = "Se reemplaza la página " + evictedPage + " por la página " + page;
            }

            steps.add(new SimulationStep(page, copyFrames(frames), true, action));
        }

        int total = pageReferences.size();
        AlgorithmSummary summary = new AlgorithmSummary(
                AlgorithmType.LRU,
                pageFaults,
                hits,
                (hits * 100.0) / total,
                (pageFaults * 100.0) / total
        );

        return new SimulationResult(AlgorithmType.LRU, steps, summary);
    }

    private int findLeastRecentlyUsed(int[] frames, Map<Integer, Integer> lastUsed) {
        int lruPage = frames[0];
        int oldestUse = lastUsed.get(lruPage);

        for (int frame : frames) {
            int useTime = lastUsed.get(frame);
            if (useTime < oldestUse) {
                oldestUse = useTime;
                lruPage = frame;
            }
        }

        return lruPage;
    }

    private int findFrameIndex(int[] frames, int page) {
        for (int i = 0; i < frames.length; i++) {
            if (frames[i] == page) {
                return i;
            }
        }
        return -1;
    }

    private int findEmptyFrame(int[] frames) {
        for (int i = 0; i < frames.length; i++) {
            if (frames[i] == -1) {
                return i;
            }
        }
        return -1;
    }

    private List<Integer> copyFrames(int[] frames) {
        List<Integer> copy = new ArrayList<>(frames.length);
        for (int frame : frames) {
            copy.add(frame);
        }
        return copy;
    }
}
