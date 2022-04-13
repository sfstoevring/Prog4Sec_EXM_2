import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class FileUtil {

    public static byte[] readAllBytes(String plaintextFileName) {
        byte[] bytesRead = {};
        try {
            bytesRead = Files.readAllBytes(Paths.get(plaintextFileName));
            System.out.println("File read!\n" + "Now encrypting...\n");
        } catch (Exception e) {}
        return bytesRead; // returns {} if file does not exist
    }

    public static byte[] readAllBytes(String transformation, String plaintextFileName) {
        byte[] bytesRead = {};
        String cFile = "";
        String[] parts = transformation.split("/");
        if (parts.length == 3 && parts[0].equals("AES")) {
            cFile = plaintextFileName + "yalla" +  ".aes";
        }
        System.out.println("c-file: " + cFile);
        try {
            bytesRead = Files.readAllBytes(Paths.get(cFile));
        } catch (Exception e) {}

        System.out.println("hello world");
        return bytesRead;
    }

    public static void write(String plaintextFileName, byte[] output) {
        String decryptedFile = plaintextFileName;
        System.out.println(decryptedFile);
        try {
            Files.write(Paths.get(decryptedFile), output);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void write(String transformation, String plaintextFileName, byte[] output) {
        String outFile = "";
        String[] parts = transformation.split("/");
        if (parts.length == 3 && parts[0].equals("AES")) {
            outFile = plaintextFileName + "." + "aes";
            System.out.println("Encrypting file...\n" + outFile);
        } else {  }
        try {
            System.out.println();
            Files.write(Paths.get(outFile), output);
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
}