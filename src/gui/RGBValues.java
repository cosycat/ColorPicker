package gui;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import logic.ColorPickerModel;

public class RGBValues extends VBox implements ViewInit {
    
    private TextField rField;
    private TextField gField;
    private TextField bField;
    
    private ColorPickerModel model;
    
    
    public RGBValues(ColorPickerModel model) {
        this.model = model;
        init();
    }
    
    @Override
    public void initializeSelf() {
    
    }
    
    @Override
    public void initializeControls() {
        rField = new TextField();
        gField = new TextField();
        bField = new TextField();
    }
    
    @Override
    public void layoutControls() {
        this.getChildren().addAll(rField, gField, bField);
    }
    
    @Override
    public void setupEventHandlers() {
    
    }
    
    @Override
    public void setupValueChangedListeners() {
        rField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (Integer.parseInt(newValue) > 255)
                rField.textProperty().setValue("255");
            if (Integer.parseInt(newValue) < 0)
                rField.textProperty().setValue("0");
        });
        gField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (Integer.parseInt(newValue) > 255)
                gField.textProperty().setValue("255");
            if (Integer.parseInt(newValue) < 0)
                gField.textProperty().setValue("0");
        });
        bField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (Integer.parseInt(newValue) > 255)
                bField.textProperty().setValue("255");
            if (Integer.parseInt(newValue) < 0)
                bField.textProperty().setValue("0");
        });
    }
    
    @Override
    public void setupBindings() {
        rField.textProperty().bindBidirectional(model.rProperty(), new RGBStringConverter());
        gField.textProperty().bindBidirectional(model.gProperty(), new RGBStringConverter());
        bField.textProperty().bindBidirectional(model.bProperty(), new RGBStringConverter());
    }
}

