import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

class SelectFileDecryptButton extends Button {
    SelectFileDecryptButton(String dir) {
        setText("Decrypt");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(dir));

        setOnAction(e -> {
            File file = fileChooser.showOpenDialog(new Stage());

            String fileName = file.getAbsolutePath();

                decryptor.decrypt(fileName);

        });
    }
    DecryptFileCBC decryptor = new DecryptFileCBC();
}
