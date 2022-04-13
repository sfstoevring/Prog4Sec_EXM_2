import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

class SelectFileEncryptButton extends Button {
    SelectFileEncryptButton(String dir) {
        setText("Encrypt");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(dir));

        setOnAction(e -> {
            File file = fileChooser.showOpenDialog(new Stage());

            String fileName = file.getAbsolutePath();

            encryptor.encrypt(fileName);

        });
    }

    EncryptFileCBC encryptor = new EncryptFileCBC();
}
