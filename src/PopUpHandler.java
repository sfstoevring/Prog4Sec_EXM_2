import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.css.converter.LadderConverter;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;


public class PopUpHandler {

    static String pw;

    public static String getPassword(String msg){
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Type your password");
        stage.setMinWidth(250);
        Label label = new Label();
        label.setText(msg);

        PasswordField passwordInput = new PasswordField();

        passwordInput.getText();
        passwordInput.textProperty().addListener((observable, oldValue, newValue) -> {
            pw = newValue;
        });

        Button confirmButton = new Button("Confirm");
        confirmButton.setOnAction(e-> {
            if (!pw.isEmpty()){
            stage.close();
            } else {
               label.setText("Please enter password");
            }
        });

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(label, passwordInput, confirmButton);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.showAndWait();


        return pw;
    }



}
