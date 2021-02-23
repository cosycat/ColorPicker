package gui;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import logic.ColorPickerModel;

public class CustomMenuBar extends MenuBar implements ViewInit {
    
    private ColorPickerModel model;
    private ColorPickerApp app;
    
    private Menu fileMenu;
    private Menu colorSelect;
    
    private MenuItem quitItem;
    
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
        colorSelect = new Menu("Select Color");
        
        quitItem = new MenuItem("Quit");
        quitItem.setAccelerator(new KeyCodeCombination(KeyCode.Q));
    }
    
    @Override
    public void layoutControls() {
        fileMenu.getItems().add(quitItem);
        this.getMenus().add(fileMenu);
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
