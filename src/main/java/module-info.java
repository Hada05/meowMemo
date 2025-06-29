module com.ambameow.meowmemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires com.fasterxml.jackson.databind;


    opens com.ambameow.meowmemo to javafx.fxml;
    exports com.ambameow.meowmemo;
}