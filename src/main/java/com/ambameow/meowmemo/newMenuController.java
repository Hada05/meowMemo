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
import java.time.LocalDate;

public class newMenuController {
    @FXML private ImageView moodImage;
    @FXML private ImageView pawsitivityImage;
    @FXML private TextField textJudul;
    @FXML private TextArea textIsi;

    public void initialize() {
        String mood = tempDiaryManagerClass.getTempDiary().getMood();
        String pawsitivity = tempDiaryManagerClass.getTempDiary().getPawsitivity();
        pawsitivityImage.setImage(new Image(String.valueOf(getClass().getResource("/com/ambameow/meowmemo/image/pawsitivity/"+pawsitivity+".png"))));
        moodImage.setImage(new Image(String.valueOf(getClass().getResource("/com/ambameow/meowmemo/image/mood/"+mood+".png"))));
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        Parent mainMenu = FXMLLoader.load(getClass().getResource("/com/ambameow/meowmemo/pawsitivityMenu.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.getScene().setRoot(mainMenu);
        stage.show();
    }

    public void goSave(ActionEvent actionEvent) throws IOException {
        String judul = textJudul.getText();
        String isi = textIsi.getText();
        LocalDate date = LocalDate.now();

        if (judul.length() == 0 || isi.length() == 0) {
            System.out.println("Judul dan/atau isi tidak boleh kosong >:(");
            return;
        }

        tempDiaryManagerClass.getTempDiary().setTitle(judul);
        tempDiaryManagerClass.getTempDiary().setContent(isi);
        diaryClass newDiary = new diaryClass(judul, isi, tempDiaryManagerClass.getTempDiary().getMood(), tempDiaryManagerClass.getTempDiary().getPawsitivity());
        diaryManagerClass.addDiary(newDiary);

        // Save the diaries as JSON
        try {
            diaryManagerClass.saveDiaries(); // Save to JSON
        } catch (IOException e) {
            e.printStackTrace();
            // Handle save failure
        }
        tempDiaryManagerClass.resetTempDiary();

        Parent mainMenu = FXMLLoader.load(getClass().getResource("/com/ambameow/meowmemo/mainMenu.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.getScene().setRoot(mainMenu);
        stage.show();
    }
}
