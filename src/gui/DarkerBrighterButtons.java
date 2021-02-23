package gui;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import logic.ColorPickerModel;

public class DarkerBrighterButtons extends VBox implements ViewInit {
    
    private final ColorPickerModel model;
    
    private Button darkerButton;
    private Button brighterButton;
    
    public DarkerBrighterButtons(ColorPickerModel model) {
        this.model = model;
        init();
    }
    
    @Override
    public void initializeSelf() {
    
    }
    
    @Override
    public void initializeControls() {
        darkerButton = new Button("Darker");
        brighterButton = new Button("Brighter");
    }
    
    @Override
    public void layoutControls() {
        this.getChildren().addAll(darkerButton, brighterButton);
    }
    
    @Override
    public void setupEventHandlers() {
        darkerButton.setOnAction(event -> model.darkenColor());
        brighterButton.setOnAction(event -> model.brightenColor());
    }
    
    @Override
    public void setupValueChangedListeners() {
        model.colorProperty().addListener((observable, oldValue, newValue) -> {
            brighterButton.setDisable(newValue.getBrightness() >= 1);
            darkerButton.setDisable(newValue.getBrightness() <= 0);
        });
    }
    
    @Override
    public void setupBindings() {
    
    }
}
