package com.operative_systems.presentation.controller.component;

import com.operative_systems.domain.enums.AlgorithmType;
import com.operative_systems.domain.model.SimulationRequest;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConfigurationController {

    @FXML
    private TextField referencesField;

    @FXML
    private TextField frameCountField;

    @FXML
    private ComboBox<AlgorithmType> algorithmComboBox;

    private Consumer<SimulationRequest> onExecute;

    @FXML
    public void initialize() {

        algorithmComboBox.getItems().setAll(
                AlgorithmType.values()
        );

        algorithmComboBox.setValue(
                AlgorithmType.FIFO
        );
    }

    public void setOnExecute(
            Consumer<SimulationRequest> onExecute
    ) {
        this.onExecute = onExecute;
    }

    @FXML
    private void executeSimulation() {

        List<Integer> references =
                Arrays.stream(
                                referencesField.getText().split(",")
                        )
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();

        SimulationRequest request =
                new SimulationRequest(
                        references,
                        Integer.parseInt(frameCountField.getText()),
                        algorithmComboBox.getValue()
                );

        if (onExecute != null) {
            onExecute.accept(request);
        }
    }
}
