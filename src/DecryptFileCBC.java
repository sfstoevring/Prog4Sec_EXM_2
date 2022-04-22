    import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.util.encoders.Hex;

import java.io.File;

public class DecryptFileCBC {

    static byte[] keyBytes = Hex.decode("000102030405060708090a0b0c0d0e0f");


    public static void decrypt(String filePath, String pw) {
        try{

            String ivString = FileUtil.getInitialVector(filePath);
            System.out.println("ivstring: " + ivString);
            IvParameterSpec iv = new IvParameterSpec(Hex.decode(ivString));
            byte[] input = FileUtil.readAllBytesDecrypt(filePath);

            // decrypting
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC");
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
            cipher.init(Cipher.DECRYPT_MODE, key, iv);
            byte[] output = cipher.doFinal(input);

            // writing
            FileUtil.write(filePath, output);

        }
        catch (Exception e){e.printStackTrace();}
    }
}
