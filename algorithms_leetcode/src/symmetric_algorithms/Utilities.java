package symmetric_algorithms;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Utilities {
    private Utilities() {}

    public static String base64Encoder(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static byte[] base64Decoder(String base64) {
        return Base64.getDecoder().decode(base64);
    }

    // Hiển thị theo dạng PEM chuẩn
    public static String getPublicKeyPEM(PublicKey publicKey) {
        String pubEncoded = base64Encoder(publicKey.getEncoded());
        String headerPEM = "-----BEGIN PUBLIC KEY-----\\n";
        String footerPEM = "\\n-----END PUBLIC KEY-----";
        return String.format("%s%s%s", headerPEM, pubEncoded, footerPEM);
    }

    // Hiển thị theo dạng PEM chuẩn
    public static String getPrivateKeyPEM(PrivateKey privateKey) {
        String priEncoded = base64Encoder(privateKey.getEncoded());
        String headerPEM = "-----BEGIN PRIVATE KEY-----\\n";
        String footerPEM = "\\n-----END PRIVATE KEY-----";
        return String.format("%s%s%s", headerPEM, priEncoded, footerPEM);
    }

    public static String convertPublicKeyPEMToBase64(String publicKeyPEM) {
        return publicKeyPEM
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s+", "");
    }

    public static String convertPrivateKeyPEMToBase64(String privateKeyPEM) {
        return privateKeyPEM
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s+", "");
    }

    public static PublicKey getPublicKeyFromPEM(String publicKeyPEM) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String base64 = convertPublicKeyPEMToBase64(publicKeyPEM);
        byte[] bytes = base64Decoder(base64);
        X509EncodedKeySpec x509 = new X509EncodedKeySpec(bytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(x509);
    }

    public static PrivateKey getPrivateKeyFromPEM(String privateKeyPEM) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String base64 = convertPrivateKeyPEMToBase64(privateKeyPEM);
        byte[] bytes = base64Decoder(base64);
        PKCS8EncodedKeySpec pkcs8 = new PKCS8EncodedKeySpec(bytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(pkcs8);
    }
}
