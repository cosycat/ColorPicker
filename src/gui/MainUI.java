package gui;

import javafx.scene.layout.GridPane;
import logic.ColorPickerModel;

public class MainUI extends GridPane implements ViewInit {
    
    private RGBSliders rgbSliders;
    private RGBValueTFs rgbValues;
    private RGBValueTFs hexValues;
    private ColorDisplay colorDisplay;
    private NamedColorsSelection colorPicker;
    private DarkerBrighterButtons darkerBrighterButtons;
    
    private final ColorPickerModel model;
    
    public MainUI(ColorPickerModel model) {
        this.model = model;
        init();
        model.addUI(this);
    }
    
    @Override
    public void initializeSelf() {
    
    }
    
    @Override
    public void initializeControls() {
        rgbSliders = new RGBSliders(model);
        rgbValues = new RGBValueTFs(model, 10, true);
        hexValues = new RGBValueTFs(model, 16, true);
        colorDisplay = new ColorDisplay(model, this);
        colorPicker = new NamedColorsSelection(model);
        darkerBrighterButtons = new DarkerBrighterButtons(model);
        
    }
    
    @Override
    public void layoutControls() {
        this.addRow(1, rgbSliders, rgbValues, hexValues);
        this.addRow(2, colorDisplay, colorPicker, darkerBrighterButtons);
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
