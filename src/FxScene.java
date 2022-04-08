import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class FxScene extends Application{
    public void start(Stage stage) throws Exception {
        stage.setTitle("File Encrypter");

        //Dirctory in project for Crytography
        String dir = "Files4Project";

        //Heading
        Label label = new Label("Cryptography");
        label.setUnderline(true);

        //Radiobuttons
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton radioButton = new RadioButton("Encrypt");
        RadioButton radioButton1 = new RadioButton("Decrypt");
        radioButton.setToggleGroup(toggleGroup);
        radioButton.setSelected(true);
        radioButton1.setToggleGroup(toggleGroup);

        //button
        FileSelectButton button = new FileSelectButton(dir);

        //Boxes
        HBox hBox = new HBox(radioButton,radioButton1);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        hBox.setSpacing(25);

        VBox vBox = new VBox(label, hBox,button);
        vBox.setAlignment(Pos.BASELINE_CENTER);
        vBox.setSpacing(50);

        //Scene and start
        Scene scene = new Scene(vBox, 500, 400);
        scene.getStylesheets().add("file:style.css");
        stage.setScene(scene);
        stage.show();
    }

}
