package gui.elements;

import gui.helper.ViewInit;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import logic.ColorPickerModel;

public class RGBSliders extends VBox implements ViewInit {
    
    Slider rSlider;
    Slider gSlider;
    Slider bSlider;
    private ColorPickerModel model;
    
    public RGBSliders(ColorPickerModel model) {
        this.model = model;
        init();
    }
    
    @Override
    public void initializeSelf() {
    
    }
    
    @Override
    public void initializeControls() {
        rSlider = new Slider(0, 1, 0);
        gSlider = new Slider(0, 1, 0);
        bSlider = new Slider(0, 1, 0);
        
        
    }
    
    @Override
    public void layoutControls() {
        this.getChildren().addAll(rSlider, gSlider, bSlider);
    }
    
    @Override
    public void setupEventHandlers() {
    
    }
    
    @Override
    public void setupValueChangedListeners() {
    
    }
    
    @Override
    public void setupBindings() {
        rSlider.valueProperty().bindBidirectional(model.rProperty());
        gSlider.valueProperty().bindBidirectional(model.gProperty());
        bSlider.valueProperty().bindBidirectional(model.bProperty());
    }
}
