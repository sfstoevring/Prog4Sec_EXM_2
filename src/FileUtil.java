import javax.crypto.spec.IvParameterSpec;
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
            System.out.println("File read!\n" + "Now encrypting...\n");
        } catch (Exception e) {}
        return bytesRead; // returns {} if file does not exist
    }

    public static byte[] readAllBytesDecrypt(String filePath) {
        byte[] bytesRead = {};
        try {
            bytesRead = Files.readAllBytes(Paths.get(filePath));
        } catch (Exception e) {}
        return bytesRead;
    }
    /*
    public static byte[] readAllBytesDecrypt(String transformation, String plaintextFileName, IvParameterSpec iv) {
        byte[] bytesRead = {};
        String cFile = "";
        String[] parts = transformation.split("/");
        String fileName = getFileName(plaintextFileName);
        if (parts.length == 3 && parts[0].equals("AES")) {
            cFile = fileName + ".txt";
        }
        write(cFile, bytesRead);
        try {
            bytesRead = Files.readAllBytes(Paths.get(cFile));
        } catch (Exception e) {}

        System.out.println("hello world");
        return bytesRead;
    }*/


    public static void write(String filePath, byte[] output) {
        String decryptedFile = getFileName(filePath);
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

    public static String getInitialVector(String filePath){

        String[] parts = filePath.split("[\\p{Punct}]");
        /*for (int i = 0; i < parts.length; i++){
            System.out.println(i + ": " + parts[i]);
        }*/
        return parts[parts.length-2];
    }
    public static String getFileName(String filePath){
        String fileAbsolute = filePath.substring(0,filePath.length()-37);
        return fileAbsolute;
    }
}