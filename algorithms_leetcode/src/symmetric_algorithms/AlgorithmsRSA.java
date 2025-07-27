package symmetric_algorithms;

import java.nio.charset.StandardCharsets;
import java.security.*;

public class AlgorithmsRSA {
    private AlgorithmsRSA() {}
    public static final String RSA = "RSA";
    public static final String SHA256_WITH_RSA = "SHA256withRSA";

    public static KeyPair generateKeyPair() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
            keyPairGenerator.initialize(2048);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String sign(String data, PrivateKey privateKey) {
        try {
            Signature signature = Signature.getInstance(SHA256_WITH_RSA);
            System.out.println("Chữ ký số với: " + signature.getAlgorithm());
            signature.initSign(privateKey);
            signature.update(data.getBytes(StandardCharsets.UTF_8));
            byte[] signatureBytes = signature.sign();
            return Utilities.base64Encoder(signatureBytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean verify(String data, String signature, PublicKey publicKey) {
        try {
            Signature verifier = Signature.getInstance(SHA256_WITH_RSA);
            System.out.println("Chữ ký số với: " + verifier.getAlgorithm());
            verifier.initVerify(publicKey);
            verifier.update(data.getBytes(StandardCharsets.UTF_8));
            byte[] signatureBytes = Utilities.base64Decoder(signature);
            return verifier.verify(signatureBytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            throw new RuntimeException(e);
        }
    }
}
