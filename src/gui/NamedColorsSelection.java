package gui;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import logic.ColorPickerModel;

import java.util.ArrayList;
import java.util.List;

public class NamedColorsSelection extends VBox implements ViewInit {
    
    List<NamedColorButton> buttonList = new ArrayList<>();
    ToggleGroup buttonGroup = new ToggleGroup();
    private ColorPickerModel model;
    
    public NamedColorsSelection(ColorPickerModel model) {
        this.model = model;
        init();
    }
    
    @Override
    public void initializeSelf() {
    
    }
    
    @Override
    public void initializeControls() {
        for (var colorNameP : model.getSpecialColors()) {
            NamedColorButton namedColorButton = new NamedColorButton(model, colorNameP, buttonGroup);
            buttonList.add(namedColorButton);
            this.getChildren().add(namedColorButton);
        }
    }
    
    @Override
    public void layoutControls() {
    
    }
    
    @Override
    public void setupEventHandlers() {
    
    }
    
    @Override
    public void setupValueChangedListeners() {
    
    }
    
    @Override
    public void setupBindings() {
    
    }
}
