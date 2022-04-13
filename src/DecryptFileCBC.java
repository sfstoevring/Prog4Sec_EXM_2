    import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.util.encoders.Hex;

import java.io.File;

public class DecryptFileCBC {
    public static void main(String[] args) {
        decrypt();
    }

    static String dir = "C:\\Users\\sfsto\\Documents\\testDir\\CBC\\";
    static String workingFile = "encryptThis";
    static String iv = "9f741fdb5d8845bdb48a94394e84f8a3";
    static String plaintextFileName = dir + workingFile + "." + "txt",
            testFile = dir + workingFile + "." + "txt";
    static byte[] keyBytes = Hex.decode("000102030405060708090a0b0c0d0e0f");


    private static void decrypt() {
        try{
            // ny iv reader her!!!
            //String ivString = FileUtil.getIV("AES/CBC/PKCS5Padding", plaintextFileName);
            //IvParameterSpec iv = new IvParameterSpec(Hex.decode(ivString));
            //byte[] input = FileUtil.readAllBytes("AES/CBC/PKCS5Padding", plaintextFileName +
            //        "." + ivString);

            // decrypting
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC");
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            //byte[] output = cipher.doFinal(input);

            // writing
           // FileUtil.write(testFile, output);
            System.out.println(testFile);

        }
        catch (Exception e){e.printStackTrace();}
    }
}
