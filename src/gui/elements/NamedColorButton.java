package gui.elements;

import gui.helper.ViewInit;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import logic.ColorNamePair;
import logic.ColorPickerModel;

public class NamedColorButton extends HBox implements ViewInit {
    
    private final ColorPickerModel model;
    private final ColorNamePair colorNamePair;
    private final ToggleGroup group;
    
    private RadioButton radioButton;
    
    
    public NamedColorButton(ColorPickerModel model, ColorNamePair colorNamePair, ToggleGroup group) {
        this.model = model;
        this.colorNamePair = colorNamePair;
        this.group = group;
        init();
    }
    
    @Override
    public void initializeSelf() {
    
    }
    
    @Override
    public void initializeControls() {
        radioButton = new RadioButton(colorNamePair.getName());
        radioButton.setToggleGroup(group);
        this.getChildren().add(radioButton);
    }
    
    @Override
    public void layoutControls() {
    
    }
    
    @Override
    public void setupEventHandlers() {
        radioButton.setOnAction(event -> {
            model.setColor(colorNamePair.getColor());
        });
    }
    
    @Override
    public void setupValueChangedListeners() {
        model.colorProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(colorNamePair.getColor())) {
                radioButton.fire();
            } else {
                radioButton.selectedProperty().set(false);
            }
        });
    }
    
    @Override
    public void setupBindings() {
    
    }
}
