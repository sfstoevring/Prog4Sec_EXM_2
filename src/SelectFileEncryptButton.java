import javafx.scene.control.Button;
import javafx.stage.FileChooser;
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
