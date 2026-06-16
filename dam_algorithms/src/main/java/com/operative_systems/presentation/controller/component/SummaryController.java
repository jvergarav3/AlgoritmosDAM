package com.operative_systems.presentation.controller.component;

import com.operative_systems.domain.model.AlgorithmSummary;
import com.operative_systems.domain.model.SimulationResult;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

public class SummaryController {

    // ======================
    // LABELS (cards)
    // ======================
    @FXML
    private Label faultsLabel;

    @FXML
    private Label hitsLabel;

    @FXML
    private Label faultRateLabel;

    @FXML
    private Label hitRateLabel;

    // ======================
    // PIE CHART
    // ======================
    @FXML
    private PieChart resultPieChart;

    @FXML
    public void initialize() {

        // Datos temporales
        int faults = 3;
        int hits = 7;

        // Labels
        faultsLabel.setText(String.valueOf(faults));
        hitsLabel.setText(String.valueOf(hits));

        double total = faults + hits;

        faultRateLabel.setText(String.format("%.0f%%", (faults / total) * 100));
        hitRateLabel.setText(String.format("%.0f%%", (hits / total) * 100));

        // PieChart
        resultPieChart.getData().addAll(
                new PieChart.Data("Fallos", faults),
                new PieChart.Data("Aciertos", hits)
        );
    }

    public void update(SimulationResult result) {

        AlgorithmSummary summary =
                result.getSummary();

        faultsLabel.setText(
                String.valueOf(summary.getPageFaults())
        );

        hitsLabel.setText(
                String.valueOf(summary.getHits())
        );

        faultRateLabel.setText(
                String.format("%.2f%%",
                        summary.getFaultRate())
        );

        hitRateLabel.setText(
                String.format("%.2f%%",
                        summary.getHitRate())
        );

        resultPieChart.getData().setAll(
                new PieChart.Data(
                        "Fallos",
                        summary.getPageFaults()
                ),
                new PieChart.Data(
                        "Aciertos",
                        summary.getHits()
                )
        );
    }
}
