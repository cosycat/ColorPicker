package gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.ColorPickerModel;

public class ColorPickerApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        ColorPickerModel model = new ColorPickerModel();
        
        Parent rootPanel = new MainUI(model, this);
        Scene mainScene = new Scene(rootPanel);
    
        primaryStage.titleProperty().bind(model.applicationTitleProperty());
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
    
    @Override
    public void stop() throws Exception {
        Platform.exit();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
