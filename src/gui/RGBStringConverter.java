package gui;

import javafx.util.converter.NumberStringConverter;

public class RGBStringConverter extends NumberStringConverter {
    
    @Override
    public String toString(Number number) {
        return String.valueOf((int)(number.doubleValue() * 255));
    }
    
    @Override
    public Number fromString(String string) {
        double value = Double.parseDouble(string) / 255;
        return value > 1 ? 1 : value;
    }
    
}
