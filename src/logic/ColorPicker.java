package logic;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.awt.Color;
import java.util.*;

public class ColorPicker {

    private final ObjectProperty<Color> currentColor = new SimpleObjectProperty<>();
    
    private final Map<String, Color> specialColors = new HashMap<>();
    
    public ColorPicker() {
        specialColors.put("Black", Color.black);
        specialColors.put("Brown", new Color(102, 51, 0));
        specialColors.put("Red", Color.red);
        specialColors.put("Orange", Color.orange);
        specialColors.put("Yellow", Color.yellow);
        specialColors.put("Green", Color.green);
        specialColors.put("Blue", Color.blue);
        specialColors.put("Purple", new Color(102, 0, 153));
    }
    
    /////////////////////////
    // Getters and Setters //
    /////////////////////////
    
    
    public Color getCurrentColor() {
        return currentColor.get();
    }
    
    public ObjectProperty<Color> currentColorProperty() {
        return currentColor;
    }
    
    public void setCurrentColor(Color currentColor) {
        this.currentColor.set(currentColor);
    }
}
