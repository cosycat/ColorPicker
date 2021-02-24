package gui.helper;

import javafx.scene.paint.Color;
import logic.ColorNamePair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColorCollection {
    
    public static final List<ColorCollection> COLOR_COLLECTION_LIST = new ArrayList<ColorCollection>(Arrays.asList(
            new ColorCollection("Rainbow",
                    new ColorNamePair("Black", Color.BLACK),
                    new ColorNamePair("Brown", Color.BROWN),
                    new ColorNamePair("Red", Color.RED),
                    new ColorNamePair("Orange", Color.ORANGE),
                    new ColorNamePair("Yellow", Color.YELLOW),
                    new ColorNamePair("Green", Color.GREEN),
                    new ColorNamePair("Blue", Color.BLUE),
                    new ColorNamePair("Purple", Color.PURPLE)),
            new ColorCollection("Trans",
                    new ColorNamePair("Bright Blue", Color.LIGHTSKYBLUE),
                    new ColorNamePair("Pink", Color.PINK),
                    new ColorNamePair("White", Color.WHITE),
                    new ColorNamePair("Pink", Color.PINK),
                    new ColorNamePair("Bright Blue", Color.LIGHTSKYBLUE)),
            new ColorCollection("Bi",
                    new ColorNamePair("Pink", Color.PINK),
                    new ColorNamePair("Purple", Color.PURPLE),
                    new ColorNamePair("Blue", Color.BLUE))
    ));
    
    
    private final List<ColorNamePair> colors = new ArrayList<>();
    private final String name;
    
    public ColorCollection(String name, ColorNamePair... colorNamePairs) {
        this.name = name;
        colors.addAll(Arrays.asList(colorNamePairs));
    }
    
    public List<ColorNamePair> getColors() {
        return colors;
    }
    
    public String getName() {
        return name;
    }
    
    public static List<ColorCollection> getColorCollectionList() {
        return COLOR_COLLECTION_LIST;
    }
}
