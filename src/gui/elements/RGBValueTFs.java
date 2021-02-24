package gui.elements;

import gui.helper.RGBStringConverter;
import gui.helper.ViewInit;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import logic.ColorPickerModel;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RGBValueTFs extends VBox implements ViewInit {
    
    private TextField rField;
    private TextField gField;
    private TextField bField;
    
    private final List<TextField> allTextFields = new LinkedList<>();
    
    private final ColorPickerModel model;
    private final int numberSystemBase;
    private final boolean editable;
    
    
    public RGBValueTFs(ColorPickerModel model, int numberSystemBase, boolean editable) {
        this.model = model;
        this.numberSystemBase = numberSystemBase;
        this.editable = editable;
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
    
        allTextFields.addAll(Arrays.asList(rField, gField, bField));
        
        allTextFields.forEach(textField -> textField.setEditable(editable));
        
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
        if (editable) {
            allTextFields.forEach(textField -> {
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue.isEmpty()) {
                        return; // it's ok if the user wants to just empty the text field. don't write anything else in there.
                    }
                    try {
                        if (Integer.parseInt(newValue, numberSystemBase) > 255)
                            textField.textProperty().setValue(Integer.toString(255, numberSystemBase));
                        if (Integer.parseInt(newValue, numberSystemBase) < 0)
                            textField.textProperty().setValue("0");
                    } catch (NumberFormatException e) {
                        System.out.println("Entered the invalid value " + newValue + " but the number system has base " + numberSystemBase);
                        textField.textProperty().setValue("0");
                        // TODO: maybe inform user somehow, play a sound or sth.
                    }
                });
            });
        }
    }
    
    @Override
    public void setupBindings() {
        rField.textProperty().bindBidirectional(model.rProperty(), new RGBStringConverter(numberSystemBase));
        gField.textProperty().bindBidirectional(model.gProperty(), new RGBStringConverter(numberSystemBase));
        bField.textProperty().bindBidirectional(model.bProperty(), new RGBStringConverter(numberSystemBase));
    }
}

