import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class FileUtil {

    public static byte[] readAllBytesEncrypt(String filePath) {
        byte[] bytesRead = {};
        try {
            bytesRead = Files.readAllBytes(Paths.get(filePath));
        } catch (Exception e) {}
        return bytesRead; // returns {} if file does not exist
    }

    public static byte[] readAllBytesDecrypt(String transformation, String plaintextFileName) {
        byte[] bytesRead = {};
        String cFile = "";
        String[] parts = transformation.split("/");

        if (parts.length == 3 && parts[0].equals("AES")) {
            cFile = plaintextFileName;
        }
        try {
            bytesRead = Files.readAllBytes(Paths.get(cFile));
        } catch (Exception e) {
        }
        return bytesRead;
    }


    public static void write(String filePath, byte[] output) {
        String decryptedFile = getFileName(filePath) + "_decrypted." + getFileType(filePath);
        try {
            Files.write(Paths.get(decryptedFile), output);
            System.out.println("Decrypted file is located at: " + decryptedFile);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void write(String transformation, String plaintextFileName, byte[] output, String ivString) {
        String outFile = "";
        String[] parts = transformation.split("/");
        if (parts.length == 3 && parts[0].equals("AES")) {
            outFile = plaintextFileName + "." + ivString + "." + "aes"; //adds iv to filename
            System.out.println("Encrypted file is located at:\n" + outFile);
        } else {  }
        try {
            Files.write(Paths.get(outFile), output);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static byte[] generateInitialVector() throws NoSuchAlgorithmException, NoSuchProviderException {
            SecureRandom secureRandom = SecureRandom.getInstance("DEFAULT", "BC");
            byte[] iv = new byte[16];
            secureRandom.nextBytes(iv);
            return iv;
    }

    public static String getInitialVector(String filePath){
        String[] parts = filePath.split("[\\p{Punct}]");
        return parts[parts.length-2];
    }
    public static String getFileName(String filePath){
        String fileAbsolute = filePath.substring(0,filePath.length()-41);
        return fileAbsolute;
    }

    public static String getFileType(String filePath){
        String[] parts = filePath.split("[\\p{Punct}]");
        return parts[parts.length-3];
    }
}