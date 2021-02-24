package gui;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.shape.Rectangle;
import logic.ColorPickerModel;

import java.util.ArrayList;
import java.util.List;

public class CustomMenuBar extends MenuBar implements ViewInit {
    
    private ColorPickerModel model;
    private ColorPickerApp app;
    
    private Menu fileMenu;
    private Menu colorSelect;
    
    private MenuItem quitItem;
    
    private Menu rainbowColorSelection;
    private List<MenuItem> colorSelectionsList = new ArrayList<>();
    
    public CustomMenuBar(ColorPickerModel model, ColorPickerApp app) {
        this.model = model;
        this.app = app;
        init();
    }
    
    @Override
    public void initializeSelf() {
    
    }
    
    @Override
    public void initializeControls() {
        fileMenu = new Menu("File");
        
        quitItem = new MenuItem("Quit");
        quitItem.setAccelerator(new KeyCodeCombination(KeyCode.Q));
        
        colorSelect = new Menu("Select Color");
        
        rainbowColorSelection = new Menu("Rainbow Flag");
        
        model.getSpecialColors().forEach(colorNamePair -> {
            MenuItem item = new MenuItem(colorNamePair.getName(), new Rectangle(10,10,colorNamePair.getColor()));
            item.setOnAction((event) -> model.setColor(colorNamePair.getColor()));
            rainbowColorSelection.getItems().add(item);
            colorSelectionsList.add(item);
        });
    }
    
    @Override
    public void layoutControls() {
        fileMenu.getItems().add(quitItem);
        this.getMenus().add(fileMenu);
        colorSelect.getItems().add(rainbowColorSelection);
        this.getMenus().add(colorSelect);
    }
    
    @Override
    public void setupEventHandlers() {
        quitItem.setOnAction(event -> {
            try {
                app.stop();
                System.out.println("Tried to stop app");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    
    @Override
    public void setupValueChangedListeners() {
    
    }
    
    @Override
    public void setupBindings() {
    
    }
}
