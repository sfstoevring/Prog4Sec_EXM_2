import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

class SelectFileDecryptButton extends Button {
    SelectFileDecryptButton(String dir) {
        setText("Decrypt");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(dir));
        PopUpHandler popUpHandler = new PopUpHandler();

        setOnAction(e -> {
            File file = fileChooser.showOpenDialog(new Stage());
            String pw = popUpHandler.getPassword("Type password to decrypt");
            String fileName = file.getAbsolutePath();

            decryptor.decrypt(fileName, pw);

        });
    }
    DecryptFileCBC decryptor = new DecryptFileCBC();
}
