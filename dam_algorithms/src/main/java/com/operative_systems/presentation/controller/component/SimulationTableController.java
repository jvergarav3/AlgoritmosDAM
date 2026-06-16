package com.operative_systems.presentation.controller.component;

import com.operative_systems.domain.model.SimulationResult;
import com.operative_systems.domain.model.SimulationStep;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SimulationTableController {

    @FXML
    private TableView<SimulationStep> tableView;

    @FXML
    private TableColumn<SimulationStep, Integer> stepColumn;

    @FXML
    private TableColumn<SimulationStep, Integer> referenceColumn;

    @FXML
    private TableColumn<SimulationStep, String> framesColumn;

    @FXML
    private TableColumn<SimulationStep, Boolean> faultColumn;

    @FXML
    private TableColumn<SimulationStep, String> actionColumn;

    @FXML
    public void initialize() {

        stepColumn.setCellValueFactory(cell ->
                new SimpleIntegerProperty(
                        tableView.getItems().indexOf(cell.getValue()) + 1
                ).asObject()
        );

        referenceColumn.setCellValueFactory(cell ->
                new SimpleIntegerProperty(
                        cell.getValue().getPageReferenced()
                ).asObject()
        );

        framesColumn.setCellValueFactory(cell ->
                new SimpleStringProperty(
                        cell.getValue().getFrames().toString()
                )
        );

        faultColumn.setCellValueFactory(cell ->
                new SimpleBooleanProperty(
                        cell.getValue().isPageFault()
                ).asObject()
        );

        actionColumn.setCellValueFactory(cell ->
                new SimpleStringProperty(
                        cell.getValue().getAction()
                )
        );

        // Permite varias líneas en la columna Acción
        actionColumn.setCellFactory(column -> new TableCell<>() {

            private final Label label = new Label();

            {
                label.setWrapText(true);
                label.setMaxWidth(Double.MAX_VALUE);
            }

            @Override
            protected void updateItem(String item, boolean empty) {

                super.updateItem(item, empty);

                if (empty || item == null) {
                    setGraphic(null);
                } else {

                    label.setText(item);

                    label.setPrefWidth(
                            actionColumn.getWidth() - 15
                    );

                    setGraphic(label);
                }
            }
        });

        tableView.setFixedCellSize(-1);
    }

    public void update(
            SimulationResult result
    ) {

        System.out.println(
                "Steps recibidos: "
                        + result.getSteps().size()
        );

        tableView.setItems(
                FXCollections.observableArrayList(
                        result.getSteps()
                )
        );

        tableView.refresh();
    }
}