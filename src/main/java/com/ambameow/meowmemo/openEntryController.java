package com.ambameow.meowmemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class openEntryController {
    @FXML
    private TextField textJudul;
    @FXML
    private TextArea textIsi;
    @FXML
    public ImageView moodImage;
    @FXML
    public ImageView pawsitivityImage;
    private diaryClass currentEntry;

    private int entryId;

    public void openEntry(diaryClass diary, int entryId) {
        currentEntry = diary;
        this.entryId = entryId;
        textJudul.setText(currentEntry.getTitle());
        textIsi.setText(currentEntry.getContent());
        pawsitivityImage.setImage(new Image(String.valueOf(getClass().getResource("/com/ambameow/meowmemo/image/pawsitivity/"+currentEntry.getPawsitivity()+".png"))));
        moodImage.setImage(new Image(String.valueOf(getClass().getResource("/com/ambameow/meowmemo/image/mood/"+currentEntry.getMood()+".png"))));
    }



    public void goSave(ActionEvent actionEvent) throws IOException {
        currentEntry.setTitle(textJudul.getText());
        currentEntry.setContent(textIsi.getText());

        diaryManagerClass.addDiary(currentEntry);
        diaryManagerClass.getDiaryList().remove(entryId);

        // Save the diaries as JSON
        try {
            diaryManagerClass.saveDiaries(); // Save to JSON
        } catch (IOException e) {
            e.printStackTrace();
            // Handle save failure
        }

        Parent mainMenu = FXMLLoader.load(getClass().getResource("/com/ambameow/meowmemo/listMenu.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.getScene().setRoot(mainMenu);
        stage.show();
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        Parent mainMenu = FXMLLoader.load(getClass().getResource("/com/ambameow/meowmemo/listMenu.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.getScene().setRoot(mainMenu);
        stage.show();
    }
}
