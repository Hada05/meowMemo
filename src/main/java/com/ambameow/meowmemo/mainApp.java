package com.ambameow.meowmemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class mainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Test loading fonts and print their internal names
        Font poppinsRegular = Font.loadFont(getClass().getResourceAsStream("/com/ambameow/meowmemo/fonts/Poppins/Poppins-Regular.ttf"), 12);
        Font poppinsBold = Font.loadFont(getClass().getResourceAsStream("/com/ambameow/meowmemo/fonts/Poppins/Poppins-Bold.ttf"), 12);
        Font grandstanderBold = Font.loadFont(getClass().getResourceAsStream("/com/ambameow/meowmemo/fonts/Grandstander/static/Grandstander-Bold.ttf"), 12);
        Font grandstanderRegular = Font.loadFont(getClass().getResourceAsStream("/com/ambameow/meowmemo/fonts/Grandstander/static/Grandstander-Regular.ttf"), 12);

        try {
            // Load diaries when the app starts from the JSON file
            diaryManagerClass.loadDiaries(); // Load from the JSON file instead of XML
        } catch (IOException e) {
            e.printStackTrace();
            // Handle any error loading JSON here, e.g., the file might not exist yet.
        }

        // Load FXML for the main menu
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/ambameow/meowmemo/mainMenu.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        // Link CSS file
        scene.getStylesheets().add(getClass().getResource("/com/ambameow/meowmemo/styles.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
