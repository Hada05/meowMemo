package com.ambameow.meowmemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;


public class listMenuController {

    @FXML
    private VBox vboxDiaryEntries; // VBox to display diary entries

    // Method to load diaries from the diaryManager and display them
    public void initialize() throws IOException {
        diaryManagerClass.loadDiaries();

        for (diaryClass diary : diaryManagerClass.getDiaryList()){
            addDiaryEntry(diary);
        }
    }

    // Method to add a single diary entry to the VBox
    public void addDiaryEntry(diaryClass diary) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ambameow/meowmemo/diaryEntry.fxml"));
        HBox hBoxEntry = loader.load();

        diaryEntryController controller = loader.getController();
        controller.setEntryId(diaryManagerClass.getDiaryList().indexOf(diary), vboxDiaryEntries);
        controller.setParentController(this); // 'this' refers to listMenuController

        controller.setDiaryData(diary);

        vboxDiaryEntries.getChildren().add(hBoxEntry);
    }
    public void goBack(ActionEvent actionEvent) throws IOException {
        Parent mainMenu = FXMLLoader.load(getClass().getResource("/com/ambameow/meowmemo/mainMenu.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.getScene().setRoot(mainMenu);
        stage.show();
    }
    public void refreshList() throws IOException {
        vboxDiaryEntries.getChildren().clear(); // Clear existing entries
        initialize(); // Reload entries from the diaryManagerClass
    }

}
