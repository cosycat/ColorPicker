package gui;

import gui.elements.*;
import gui.helper.ViewInit;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import logic.ColorPickerModel;

public class MainUI extends BorderPane implements ViewInit {
    
    private CustomMenuBar menuBar;
    
    private GridPane centerGridPane;
    
    private RGBSliders rgbSliders;
    private RGBValueTFs rgbValues;
    private RGBValueTFs hexValues;
    private RGBValueTFs binaryValues;
    
    private ColorDisplay colorDisplay;
    private NamedColorsSelection colorPicker;
    private DarkerBrighterButtons darkerBrighterButtons;
    
    private final ColorPickerModel model;
    private ColorPickerApp app;
    
    public MainUI(ColorPickerModel model, ColorPickerApp app) {
        this.model = model;
        this.app = app;
        init();
        model.addUI(this);
    }
    
    @Override
    public void initializeSelf() {
    
    }
    
    @Override
    public void initializeControls() {
        centerGridPane = new GridPane();
        
        menuBar = new CustomMenuBar(model, app);
        
        rgbSliders = new RGBSliders(model);
        rgbValues = new RGBValueTFs(model, 10, true);
        hexValues = new RGBValueTFs(model, 16, true);
        binaryValues = new RGBValueTFs(model, 2, true);
        
        
        colorDisplay = new ColorDisplay(model, this);
        colorPicker = new NamedColorsSelection(model);
        darkerBrighterButtons = new DarkerBrighterButtons(model);
        
    }
    
    @Override
    public void layoutControls() {
        this.setTop(menuBar);
        
        centerGridPane.addRow(1, rgbSliders, rgbValues, hexValues, binaryValues);
        centerGridPane.addRow(2, colorDisplay, colorPicker, darkerBrighterButtons);
        
        this.setCenter(centerGridPane);
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
