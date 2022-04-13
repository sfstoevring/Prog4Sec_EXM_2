import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

class FileSelectButton extends Button {
    FileSelectButton(String dir) {
        setText("Press");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(dir));
        setOnAction(e -> {
            File file = fileChooser.showOpenDialog(new Stage());
            String fileName = file.getAbsolutePath();
            encryptor.encrypt(fileName);
            System.out.println(fileName);
        });
    }

    EncryptFileCBC encryptor = new EncryptFileCBC();
    DecryptFileCBC decrypt = new DecryptFileCBC();
}
