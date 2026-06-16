package com.operative_systems.presentation.controller.page;

import com.operative_systems.application.SimulationService;
import com.operative_systems.domain.model.SimulationRequest;
import com.operative_systems.domain.model.SimulationResult;
import com.operative_systems.presentation.controller.component.ConfigurationController;
import com.operative_systems.presentation.controller.component.SimulationTableController;
import com.operative_systems.presentation.controller.component.SummaryController;
import javafx.fxml.FXML;

public class DashboardController {

    private final SimulationService simulationService =
            new SimulationService();

    @FXML
    private ConfigurationController configurationPanelController;

    @FXML
    private SummaryController summaryPanelController;

    @FXML
    private SimulationTableController simulationTableController;

    @FXML
    public void initialize() {

        configurationPanelController.setOnExecute(
                this::executeSimulation
        );
    }

    private void executeSimulation(
            SimulationRequest request
    ) {

        SimulationResult result =
                simulationService.simulate(request);

        summaryPanelController.update(result);

        simulationTableController.update(result);
    }
}