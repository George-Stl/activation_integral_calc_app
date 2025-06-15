package com.activation.integral.app.UI.controller;

import com.activation.integral.app.UI.model.Unit;
import com.activation.integral.app.service.ElementFactory;
import com.activation.integral.app.service.IntegralCalculation;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

public class ActIntController {
    private ElementFactory elementFactory;
    private IntegralCalculation integralCalculation;

    @Autowired
    public ActIntController(ElementFactory elementFactory, IntegralCalculation integralCalculation) {
        this.elementFactory = elementFactory;
        this.integralCalculation = integralCalculation;
    }

    @FXML private ToggleGroup elementGroup;
    @FXML private RadioButton aluminiumRadioButt;
    @FXML private RadioButton indiumRadioButt;
    @FXML private RadioButton fluoroRadioButt;

    @FXML private TextField radiusField;
    @FXML private ComboBox<Unit> radiusUnitCombo;

    @FXML private TextField thicknessField;
    @FXML private ComboBox<Unit> thicknessUnitCombo;

    @FXML private TextField timeField;

    @FXML private Button loadFileButton;
    @FXML private Label filePathLabel;

    @FXML private Button calculateButton;
    @FXML private TextArea resultArea;

    private File selectedFile;

    @FXML
    public void initialize() {
        radiusUnitCombo.getItems().setAll(Unit.values());
        radiusUnitCombo.getSelectionModel().select(Unit.MM);

        thicknessUnitCombo.getItems().setAll(Unit.values());
        thicknessUnitCombo.getSelectionModel().select(Unit.MM);

        loadFileButton.setOnAction(event -> loadExcelFile());

        calculateButton.setOnAction(event -> calculate());
    }

    private void loadExcelFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите файл спектра");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Excel Files", "*.xlsx"));
        selectedFile = fileChooser.showOpenDialog(loadFileButton.getScene().getWindow());

        if (selectedFile != null) {
            filePathLabel.setText(selectedFile.getName());
        }
    }

    private void calculate() {

    }
}
