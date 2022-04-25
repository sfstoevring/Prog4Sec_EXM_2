import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.File;

class SelectFileEncryptButton extends Button {
    SelectFileEncryptButton(String dir) {
        setText("Encrypt");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(dir));
        PopUpHandler popUpHandler = new PopUpHandler();

        setOnAction(e -> {
            File file = fileChooser.showOpenDialog(new Stage());
            String pw = popUpHandler.getPassword("Type password to encrypt");
            String fileName = file.getAbsolutePath();

            encryptor.encrypt(fileName, pw);
            });

    }

        EncryptFileCBC encryptor = new EncryptFileCBC();
}
