package symmetric_algorithms;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AlgorithmsAES {
    public static final String AES = "AES";
    public static final String ECB_PADDING_MODE = "AES/ECB/PKCS5Padding";
    public static final String CBC_PADDING_MODE = "AES/CBC/PKCS5Padding";

    public static String encryptWithECBMode(String plainText, byte[] secretKey) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, AES);
        try {
            Cipher cipher = Cipher.getInstance(ECB_PADDING_MODE);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            return Utilities.base64Encoder(encrypted);
        } catch (
            NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e
        ) {
            throw new RuntimeException(e);
        }
    }

    public static String decryptWithECBMode(String cipherText, byte[] secretKey) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, AES);
        try {
            Cipher cipher = Cipher.getInstance(ECB_PADDING_MODE);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decoded = Utilities.base64Decoder(cipherText);
            byte[] decrypted = cipher.doFinal(decoded);
            return new String(decrypted, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String encryptWithCBCMode(String plainText, byte[] secretKey, byte[] initVector) {
        IvParameterSpec iv = new IvParameterSpec(initVector);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, AES);
        try {
            Cipher cipher = Cipher.getInstance(CBC_PADDING_MODE);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);
            byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            return Utilities.base64Encoder(encrypted);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String decryptWithCBCMode(String cipherText, byte[] secretKey, byte[] initVector) {
        IvParameterSpec iv = new IvParameterSpec(initVector);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, AES);
        try {
            Cipher cipher = Cipher.getInstance(CBC_PADDING_MODE);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, iv);
            byte[] decodedCipherText = Utilities.base64Decoder(cipherText);
            byte[] decrypted = cipher.doFinal(decodedCipherText);
            return new String(decrypted, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
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
        exampleAESWithECB(plainText);
        System.out.println("-----------------------------------------------------------------------------");
        exampleAESWithCBC(plainText);
    }

    private static void exampleAESWithCBC(String plainText) {
        byte[] secretKey = SymmetricKeyGenerator.generateSymmetricKeyDefault32Byte();
        byte[] iv = SymmetricKeyGenerator.generateInitializationVector();
        System.out.println("secretKey with string: " + new String(secretKey));
        System.out.println("key length: " + secretKey.length);
        System.out.println("init vector with string: " + new String(iv));
        System.out.println("init vector length: " + iv.length);
        String cipherText = encryptWithCBCMode(plainText, secretKey, iv);
        System.out.println("cipherText: " + cipherText);
        String jsonData = decryptWithCBCMode(cipherText, secretKey, iv);
        System.out.println("json data decrypted: " + jsonData);
    }

    private static void exampleAESWithECB(String plainText) {
        byte[] secretKey = SymmetricKeyGenerator.generateSymmetricKeyDefault32Byte();
        System.out.println("secretKey with string: " + new String(secretKey));
        System.out.println("key length: " + secretKey.length);
        String cipherText = encryptWithECBMode(plainText, secretKey);
        System.out.println("cipherText: " + cipherText);
        String jsonData = decryptWithECBMode(cipherText, secretKey);
        System.out.println("json data decrypted: " + jsonData);
    }
}
