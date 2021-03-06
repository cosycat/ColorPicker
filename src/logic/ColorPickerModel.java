package logic;

import gui.ColorPickerApp;
import gui.MainUI;
import javafx.beans.property.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.*;

public class ColorPickerModel {
    
    private final DoubleProperty r = new SimpleDoubleProperty();
    private final DoubleProperty g = new SimpleDoubleProperty();
    private final DoubleProperty b = new SimpleDoubleProperty();
    
    private final ObjectProperty<Color> color = new SimpleObjectProperty<>();
    
    private final List<ColorNamePair> specialColors = new ArrayList<>();
    
    private final StringProperty applicationTitle = new SimpleStringProperty("Color Picker");
    
    private MainUI mainUI;
    
    public ColorPickerModel() {
        specialColors.addAll(Arrays.asList(
                new ColorNamePair("Black", Color.BLACK),
                new ColorNamePair("Brown", Color.BROWN),
                new ColorNamePair("Red", Color.RED),
                new ColorNamePair("Orange", Color.ORANGE),
                new ColorNamePair("Yellow", Color.YELLOW),
                new ColorNamePair("Green", Color.GREEN),
                new ColorNamePair("Blue", Color.BLUE),
                new ColorNamePair("Purple", Color.PURPLE))
        );
        
        
        setupListeners();
        
        
        color.set(Color.AQUA);
    }
    
    private void setupListeners() {
        color.addListener((observable, oldValue, newValue) -> {
            r.set(observable.getValue().getRed());
            g.set(observable.getValue().getGreen());
            b.set(observable.getValue().getBlue());
        });
        
        r.addListener((observable, oldValue, newValue) -> {
            Color oldColor = this.color.get();
            this.color.set(Color.color(observable.getValue().doubleValue(), oldColor.getGreen(), oldColor.getBlue()));
        });
    
        g.addListener((observable, oldValue, newValue) -> {
            Color oldColor = this.color.get();
            this.color.set(Color.color(oldColor.getRed(), observable.getValue().doubleValue(), oldColor.getBlue()));
        });
    
        b.addListener((observable, oldValue, newValue) -> {
            Color oldColor = this.color.get();
            this.color.set(Color.color(oldColor.getRed(), oldColor.getGreen(), observable.getValue().doubleValue()));
        });
    }
    
    public void addUI(MainUI mainUI) {
        this.mainUI = mainUI;
    }
    
    
    public void darkenColor() {
        color.set(color.get().darker());
    }
    
    public void brightenColor() {
        color.set(color.get().brighter());
    }
    
    /////////////////////////
    // Getters and Setters //
    /////////////////////////
    
    
    public double getR() {
        return r.get();
    }
    
    public DoubleProperty rProperty() {
        return r;
    }
    
    public void setR(double r) {
        this.r.set(r);
    }
    
    public double getG() {
        return g.get();
    }
    
    public DoubleProperty gProperty() {
        return g;
    }
    
    public void setG(double g) {
        this.g.set(g);
    }
    
    public double getB() {
        return b.get();
    }
    
    public DoubleProperty bProperty() {
        return b;
    }
    
    public void setB(double b) {
        this.b.set(b);
    }
    
    public Color getColor() {
        return color.get();
    }
    
    public ObjectProperty<Color> colorProperty() {
        return color;
    }
    
    public void setColor(Color color) {
        this.color.set(color);
    }
    
    public String getApplicationTitle() {
        return applicationTitle.get();
    }
    
    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }
    
    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle.set(applicationTitle);
    }
    
    public List<ColorNamePair> getSpecialColors() {
        return specialColors;
    }
}
