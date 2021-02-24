package logic;

import javafx.scene.paint.Color;
import org.json.simple.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class SaveLoadSystem {
    
    static String FILE_NAME = "SavedColors.json";
    
    static List<ColorNamePair> savedColors = new ArrayList<>();
    
    static List<EventListener> listeners = new ArrayList<>();
    
    public static void saveNewColor(ColorNamePair colorNamePair) {
        saveNewColor(colorNamePair.getColor(), colorNamePair.getName());
    }
    
    public static void saveNewColor(Color color, String name) {
        savedColors.add(new ColorNamePair(name, color));
        listeners.forEach(Object::notify);
        
        JSONObject saveObject = new JSONObject();
        savedColors.forEach(colorNamePair -> {
        
        });
        

    }
    
    public static List<ColorNamePair> loadAllColors() {
        return new ArrayList<>();
    }
    
    

}
