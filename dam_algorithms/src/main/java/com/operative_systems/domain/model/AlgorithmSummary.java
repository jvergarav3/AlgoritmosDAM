package com.operative_systems.domain.model;

import com.operative_systems.domain.enums.AlgorithmType;

public class AlgorithmSummary {
    private AlgorithmType algorithm;
    private int pageFaults;
    private int hits;
    private double hitRate;
    private double faultRate;

    public AlgorithmSummary(AlgorithmType algorithm, int pageFaults, int hits, double hitRate, double faultRate) {
        this.algorithm = algorithm;
        this.pageFaults = pageFaults;
        this.hits = hits;
        this.hitRate = hitRate;
        this.faultRate = faultRate;
    }

    public AlgorithmType getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(AlgorithmType algorithm) {
        this.algorithm = algorithm;
    }

    public int getPageFaults() {
        return pageFaults;
    }

    public void setPageFaults(int pageFaults) {
        this.pageFaults = pageFaults;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public double getHitRate() {
        return hitRate;
    }

    public void setHitRate(double hitRate) {
        this.hitRate = hitRate;
    }

    public double getFaultRate() {
        return faultRate;
    }

    public void setFaultRate(double faultRate) {
        this.faultRate = faultRate;
    }
}
