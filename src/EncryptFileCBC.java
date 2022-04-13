import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.util.encoders.Hex;
import javax.crypto.spec.IvParameterSpec;


public class EncryptFileCBC {

    static byte[] keyBytes = Hex.decode("000102030405060708090a0b0c0d0e0f");

    public static void encrypt(String filePath) {
        try{

            // reading
            byte[] input = FileUtil.readAllBytes(filePath);
            byte[] iv = FileUtil.generateInitialVector();
            // encrypting
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding", "BC");
            SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
            IvParameterSpec ivParams = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, key, ivParams);
            byte[] output = cipher.doFinal(input);

            // writing
            FileUtil.write("AES/CBC/PKCS5Padding", filePath, output, Hex.toHexString(iv));
        }
        catch (Exception e){e.printStackTrace();}
    }

}
