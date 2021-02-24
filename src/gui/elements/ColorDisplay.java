package gui.elements;

import gui.MainUI;
import gui.helper.ViewInit;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import logic.ColorPickerModel;

public class ColorDisplay extends VBox implements ViewInit {
    
    private final ColorPickerModel model;
    private final MainUI mainUI;
    
    Rectangle r;
    
    
    public ColorDisplay(ColorPickerModel model, MainUI mainUI) {
        this.model = model;
        this.mainUI = mainUI;
        
        init();
    }
    
    @Override
    public void initializeSelf() {
    
    }
    
    @Override
    public void initializeControls() {
        r = new Rectangle();
    }
    
    @Override
    public void layoutControls() {
        r.setX(50);
        r.setY(50);
        r.setWidth(200);
        r.setHeight(100);
        
        this.getChildren().add(r);
    }
    
    @Override
    public void setupEventHandlers() {
    
    }
    
    @Override
    public void setupValueChangedListeners() {
    
    }
    
    @Override
    public void setupBindings() {
        r.fillProperty().bind(model.colorProperty());
    
    }
}
