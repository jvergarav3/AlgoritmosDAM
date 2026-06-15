package com.operative_systems.domain.algorithm;

import com.operative_systems.domain.enums.AlgorithmType;
import com.operative_systems.domain.model.AlgorithmSummary;
import com.operative_systems.domain.model.SimulationResult;
import com.operative_systems.domain.model.SimulationStep;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Algoritmo FIFO (First In, First Out).
 * Reemplaza la pagina que lleva mas tiempo en memoria.
 */
public class FIFOAlgorithm implements PageReplacementAlgorithm {

    @Override
    public SimulationResult execute(List<Integer> pageReferences, int frameCount) {
        // -1 indica marco vacio
        int[] frames = new int[frameCount];
        Arrays.fill(frames, -1);

        // Cola con el orden de llegada de las paginas a memoria
        Deque<Integer> loadOrder = new ArrayDeque<>();
        List<SimulationStep> steps = new ArrayList<>();
        int hits = 0;
        int pageFaults = 0;

        for (int page : pageReferences) {
            // Acierto: la pagina ya esta cargada
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

            // Fallo de pagina
            pageFaults++;
            String action;

            int emptyIndex = findEmptyFrame(frames);
            if (emptyIndex >= 0) {
                // Hay marco libre: cargar directamente
                frames[emptyIndex] = page;
                loadOrder.addLast(page);
                action = "Página cargada en marco vacío";
            } else {
                // Memoria llena: reemplazar la pagina mas antigua (FIFO)
                int evictedPage = loadOrder.pollFirst();
                int evictIndex = findFrameIndex(frames, evictedPage);
                frames[evictIndex] = page;
                loadOrder.addLast(page);
                action = "Se reemplaza la página " + evictedPage + " por la página " + page;
            }

            steps.add(new SimulationStep(page, copyFrames(frames), true, action));
        }

        int total = pageReferences.size();
        AlgorithmSummary summary = new AlgorithmSummary(
                AlgorithmType.FIFO,
                pageFaults,
                hits,
                (hits * 100.0) / total,
                (pageFaults * 100.0) / total
        );

        return new SimulationResult(AlgorithmType.FIFO, steps, summary);
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

    /** Copia el estado actual de los marcos para registrar el paso. */
    private List<Integer> copyFrames(int[] frames) {
        List<Integer> copy = new ArrayList<>(frames.length);
        for (int frame : frames) {
            copy.add(frame);
        }
        return copy;
    }
}
