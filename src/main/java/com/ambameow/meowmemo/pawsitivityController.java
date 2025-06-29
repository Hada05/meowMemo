package com.ambameow.meowmemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class pawsitivityController {

    @FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        Parent mainMenu = FXMLLoader.load(getClass().getResource("/com/ambameow/meowmemo/moodMenu.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.getScene().setRoot(mainMenu);
        stage.show();
    }

    public void goNewMenu(MouseEvent mouseEvent) throws IOException {
        String selectedPawsitivity = ((ImageView) mouseEvent.getSource()).getId();

        if (tempDiaryManagerClass.getTempDiary() == null)
        {
            tempDiaryManagerClass.setTempDiary(new tempDiaryClass());
        }

        tempDiaryManagerClass.getTempDiary().setPawsitivity(selectedPawsitivity);
        System.out.println(tempDiaryManagerClass.getTempDiary().getPawsitivity());


        Parent mainMenu = FXMLLoader.load(getClass().getResource("/com/ambameow/meowmemo/newMenu.fxml"));
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        stage.getScene().setRoot(mainMenu);
        stage.show();
    }
}
