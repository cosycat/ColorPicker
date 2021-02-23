package gui;

import javafx.util.converter.NumberStringConverter;

public class RGBStringConverter extends NumberStringConverter {
    
    private int numberSystem;
    
    public RGBStringConverter(int numberSystem) {
        this.numberSystem = numberSystem;
    }
    
    @Override
    public String toString(Number number) {
        return Integer.toString((int)(number.doubleValue() * 255), numberSystem).toUpperCase();
    }
    
    @Override
    public Number fromString(String string) {
        if (string.isEmpty()) {
            return 0; // if the user wants to delete the content to write sth new in there, treat empty as 0.
        }
        double value = Integer.parseInt(string, numberSystem) / 255.0;
        return value > 1 ? 1 : (value < 0 ? 0 : value);
    }
    
}
