package gui.elements;

import gui.ColorPickerApp;
import gui.helper.ColorCollection;
import gui.helper.ViewInit;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.shape.Rectangle;
import logic.ColorPickerModel;
import logic.SaveLoadSystem;

public class CustomMenuBar extends MenuBar implements ViewInit {
    
    private final ColorPickerModel model;
    private final ColorPickerApp app;
    
    private Menu fileMenu;
    private MenuItem quitItem;
    
    private Menu flagCollectionMenu;
    
    public CustomMenuBar(ColorPickerModel model, ColorPickerApp app) {
        this.model = model;
        this.app = app;
        init();
    }
    
    @Override
    public void initializeSelf() {
        SaveLoadSystem.loadAllColors().forEach(colorNamePair -> {
            MenuItem menuItem = new MenuItem(colorNamePair.getName(), new Rectangle(10, 10, colorNamePair.getColor()));
            menuItem.setOnAction((event) -> model.setColor(colorNamePair.getColor()));
        });
    }
    
    @Override
    public void initializeControls() {
        fileMenu = new Menu("File");
        
        quitItem = new MenuItem("Quit");
        quitItem.setAccelerator(new KeyCodeCombination(KeyCode.Q));
        
        flagCollectionMenu = new Menu("Flags");
        
        ColorCollection.getColorCollectionList().forEach(colorCollection -> {
            Menu flagMenu = new Menu(colorCollection.getName());
            colorCollection.getColors().forEach(colorNamePair -> {
                MenuItem colorMenuItem = new MenuItem(colorNamePair.getName(), new Rectangle(10,10,colorNamePair.getColor()));
                colorMenuItem.setOnAction((event) -> model.setColor(colorNamePair.getColor()));
                flagMenu.getItems().add(colorMenuItem);
            });
            flagCollectionMenu.getItems().add(flagMenu);
        });
    }
    
    @Override
    public void layoutControls() {
        fileMenu.getItems().add(quitItem);
        this.getMenus().add(fileMenu);

        this.getMenus().add(flagCollectionMenu);
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
