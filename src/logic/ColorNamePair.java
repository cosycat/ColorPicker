package logic;

import javafx.scene.paint.Color;

public class ColorNamePair {
    private final String name;
    private final Color color;
    
    public ColorNamePair(String name, Color color) {
        this.name = name;
        this.color = color;
    }
    
    public String getName() {
        return name;
    }
    
    public Color getColor() {
        return color;
    }
}
