package com.operative_systems.domain.model;

import java.util.List;

public class SimulationStep {
    private int pageReferenced;
    private List<Integer> frames;
    private boolean pageFault;
    private String action;

    public SimulationStep(int pageReferenced, List<Integer> frames, boolean pageFault, String action) {
        this.pageReferenced = pageReferenced;
        this.frames = frames;
        this.pageFault = pageFault;
        this.action = action;
    }

    public int getPageReferenced() {
        return pageReferenced;
    }

    public void setPageReferenced(int pageReferenced) {
        this.pageReferenced = pageReferenced;
    }

    public List<Integer> getFrames() {
        return frames;
    }

    public void setFrames(List<Integer> frames) {
        this.frames = frames;
    }

    public boolean isPageFault() {
        return pageFault;
    }

    public void setPageFault(boolean pageFault) {
        this.pageFault = pageFault;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}