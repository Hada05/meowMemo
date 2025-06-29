package com.ambameow.meowmemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class mainMenuController {

    public void goMood(ActionEvent actionEvent) throws IOException {
        Parent moodMenu = FXMLLoader.load(getClass().getResource("/com/ambameow/meowmemo/moodMenu.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.getScene().setRoot(moodMenu);
        stage.show();
    }
    public void goList(ActionEvent actionEvent) throws IOException {
        Parent moodMenu = FXMLLoader.load(getClass().getResource("/com/ambameow/meowmemo/listMenu.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.getScene().setRoot(moodMenu);
        stage.show();
    }
    public void goExit(ActionEvent actionEvent) throws IOException{
        Parent popupRoot = FXMLLoader.load(getClass().getResource("/com/ambameow/meowmemo/exitPopup.fxml"));
        Stage popupStage = new Stage();
        Scene popupScene = new Scene(popupRoot);
        popupScene.setFill(Color.TRANSPARENT);
        popupStage.setScene(popupScene);
        popupStage.initStyle(StageStyle.TRANSPARENT);
        popupStage.show();
    }

}
