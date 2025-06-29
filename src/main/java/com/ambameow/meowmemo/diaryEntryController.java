package com.ambameow.meowmemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class diaryEntryController {

    @FXML
    private ImageView moodImageView;
    @FXML
    private Text titleLabel;
    @FXML
    private VBox parentContainer;

    @FXML
    private MenuItem deleteButton;
    private listMenuController parentController;

    private int entryId;
    // Set data for a single diary entry
    public void setDiaryData(diaryClass diary) {
        // Mood Image
        String mood = diary.getMood();
        Image moodImage = new Image(String.valueOf(getClass().getResource("/com/ambameow/meowmemo/image/mood/" + mood + ".png")));
        moodImageView.setImage(moodImage);

        // Title Label
        titleLabel.setText(diary.getTitle());
    }

    public void setEntryId(int entryId, VBox parentContainer) {
        this.entryId = entryId;
        this.parentContainer = parentContainer;
    }

    public void openDiary() throws IOException {
        // Load the entry detail scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ambameow/meowmemo/openEntry.fxml"));
        Parent entryDetailRoot = loader.load();

        // Pass the selected diary entry data to the entryDetailController
        openEntryController controller = loader.getController();
        controller.openEntry(diaryManagerClass.getDiaryList().get(entryId), entryId);

        // Open a new stage or replace the current scene
        Stage stage = (Stage) parentContainer.getScene().getWindow();
        stage.getScene().setRoot(entryDetailRoot);
        stage.show();
    }


    public void deleteDiary(ActionEvent actionEvent) throws IOException {
        // Remove from backend (diary list)
        diaryManagerClass.getDiaryList().remove(entryId);
        diaryManagerClass.saveDiaries(); // Save updated list

        // Remove from UI
        parentContainer.getChildren().remove(deleteButton.getParentPopup());
        parentController.refreshList();
    }

    public void setParentController(listMenuController controller) {
        this.parentController = controller;
    }


}
