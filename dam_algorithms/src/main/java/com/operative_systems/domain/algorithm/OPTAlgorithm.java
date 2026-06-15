package com.operative_systems.domain.algorithm;

import com.operative_systems.domain.enums.AlgorithmType;
import com.operative_systems.domain.model.AlgorithmSummary;
import com.operative_systems.domain.model.SimulationResult;
import com.operative_systems.domain.model.SimulationStep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Algoritmo OPT (Optimal / Belady).
 * Reemplaza la pagina que tardara mas en volver a usarse en el futuro.
 */
public class OPTAlgorithm implements PageReplacementAlgorithm {

    @Override
    public SimulationResult execute(List<Integer> pageReferences, int frameCount) {
        int[] frames = new int[frameCount];
        Arrays.fill(frames, -1);

        List<SimulationStep> steps = new ArrayList<>();
        int hits = 0;
        int pageFaults = 0;

        for (int stepIndex = 0; stepIndex < pageReferences.size(); stepIndex++) {
            int page = pageReferences.get(stepIndex);

            if (findFrameIndex(frames, page) >= 0) {
                hits++;
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
                action = "Página cargada en marco vacío";
            } else {
                // Elegir la victima segun su proximo uso futuro
                int evictedPage = findOptimalVictim(frames, pageReferences, stepIndex);
                int evictIndex = findFrameIndex(frames, evictedPage);
                frames[evictIndex] = page;
                action = "Se reemplaza la página " + evictedPage + " por la página " + page;
            }

            steps.add(new SimulationStep(page, copyFrames(frames), true, action));
        }

        int total = pageReferences.size();
        AlgorithmSummary summary = new AlgorithmSummary(
                AlgorithmType.OPT,
                pageFaults,
                hits,
                (hits * 100.0) / total,
                (pageFaults * 100.0) / total
        );

        return new SimulationResult(AlgorithmType.OPT, steps, summary);
    }

    /**
     * Busca la pagina en memoria cuya proxima referencia este mas lejana.
     * Si no vuelve a usarse, se considera la mejor candidata a reemplazo.
     */
    private int findOptimalVictim(int[] frames, List<Integer> pageReferences, int currentIndex) {
        int victimPage = frames[0];
        int farthestNextUse = findNextUse(pageReferences, currentIndex, victimPage);

        for (int i = 1; i < frames.length; i++) {
            int nextUse = findNextUse(pageReferences, currentIndex, frames[i]);
            if (nextUse > farthestNextUse) {
                farthestNextUse = nextUse;
                victimPage = frames[i];
            }
        }

        return victimPage;
    }

    /** Devuelve el indice de la proxima referencia futura, o MAX_VALUE si no existe. */
    private int findNextUse(List<Integer> pageReferences, int currentIndex, int page) {
        for (int i = currentIndex + 1; i < pageReferences.size(); i++) {
            if (pageReferences.get(i) == page) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
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
