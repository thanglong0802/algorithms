package symmetric_algorithms;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AlgorithmsAES {
    public static final String AES = "AES";
    public static final String ECB_PADDING_MODE = "AES/ECB/PKCS5Padding";
    public static String encrypt(String plainText, byte[] secretKey) {
        //byte[] secretKeyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, AES);
        try {
            Cipher cipher = Cipher.getInstance(ECB_PADDING_MODE);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            return base64Encoder(encrypted);
        } catch (
            NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e
        ) {
            throw new RuntimeException(e);
        }
    }

    public static String decrypt(String cipherText, byte[] secretKey) {
        //byte[] secretKeyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, AES);
        try {
            Cipher cipher = Cipher.getInstance(ECB_PADDING_MODE);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decoded = base64Decoder(cipherText);
            byte[] decrypted = cipher.doFinal(decoded);
            return new String(decrypted, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Độ dài key dùng cho AES:
     *      16 byte (128 bit)
     *      24 byte (192 bit)
     *      32 byte (256 bit)
     */
    public static void main(String[] args) {
        String plainText = "{name: \"John\", age: 30, city: \"New York\"}";
        byte[] secretKey = SymmetricKeyGenerator.generateSymmetricKey();
        System.out.println("secretKey with string: " + new String(secretKey));
        System.out.println("key length: " + secretKey.length);
        String cipherText = encrypt(plainText, secretKey);
        System.out.println("cipherText: " + cipherText);
        String jsonData = decrypt(cipherText, secretKey);
        System.out.println("json data decrypted: " + jsonData);
    }

    public static String base64Encoder(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static byte[] base64Decoder(String base64) {
        return Base64.getDecoder().decode(base64);
    }
}
