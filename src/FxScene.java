import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;



public class FxScene extends Application{
    public void start(Stage stage) throws Exception {
        Label label = new Label("label her");
        HBox hBox = new HBox(label);

        Scene scene = new Scene(hBox,600, 400);

        stage.setScene(scene);
        stage.show();
    }
}
