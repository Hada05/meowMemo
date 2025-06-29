package com.ambameow.meowmemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class moodController {
    @FXML
    private VBox moodVBox;
    public void goBack(ActionEvent actionEvent) throws IOException {
        Parent mainMenu = FXMLLoader.load(getClass().getResource("/com/ambameow/meowmemo/mainMenu.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.getScene().setRoot(mainMenu);
        stage.show();
    }

    public void goPawsitivity(MouseEvent mouseEvent) throws IOException {
        String selectedMood = ((VBox) mouseEvent.getSource()).getId();

        if (tempDiaryManagerClass.getTempDiary() == null)
        {
            tempDiaryManagerClass.setTempDiary(new tempDiaryClass());
        }

        tempDiaryManagerClass.getTempDiary().setMood(selectedMood);
        System.out.println(tempDiaryManagerClass.getTempDiary().getMood());

        Parent mainMenu = FXMLLoader.load(getClass().getResource("/com/ambameow/meowmemo/pawsitivityMenu.fxml"));
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.getScene().setRoot(mainMenu);
        stage.show();
    }
}
