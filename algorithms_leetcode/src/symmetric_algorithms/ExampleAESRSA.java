package symmetric_algorithms;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class ExampleAESRSA {
    private static class BaseReqRes {
        private String data;
        private String signature;

        public BaseReqRes data(String data) {
            this.data = data;
            return this;
        }

        public BaseReqRes signature(String signature) {
            this.signature = signature;
            return this;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        @Override
        public String toString() {
            return "BaseReqRes{" +
                    "data='" + data + '\'' +
                    ", signature='" + signature + '\'' +
                    '}';
        }
    }

    private final PublicKey PUBLIC_KEY;
    private final PrivateKey PRIVATE_KEY;
    private static final byte[] SECRET_KEY = SymmetricKeyGenerator.generateSymmetricKeyDefault32Byte();
    private static final byte[] IV = SymmetricKeyGenerator.generateInitializationVector();

    public ExampleAESRSA() {
        KeyPair KEY_PAIR = AlgorithmsRSA.generateKeyPair();
        this.PUBLIC_KEY = KEY_PAIR.getPublic();
        this.PRIVATE_KEY = KEY_PAIR.getPrivate();
        System.out.println("Algorithms: " + PUBLIC_KEY.getAlgorithm() + ", public key: " + PUBLIC_KEY.getFormat()); // X.509
        System.out.println("Algorithms: " + PRIVATE_KEY.getAlgorithm() + ", public key: " + PRIVATE_KEY.getFormat()); // PKCS#8
    }

    public BaseReqRes sendInfo() {
        String json = Constants.JSON_DATA;

        String base64Json = AlgorithmsAES.encryptWithCBCMode(json, SECRET_KEY, IV);
        String signature = AlgorithmsRSA.sign(base64Json, PRIVATE_KEY);
        return new BaseReqRes()
                .data(base64Json)
                .signature(signature);
    }

    public void receiveInfo(BaseReqRes reqRes) {
        boolean isVerified = AlgorithmsRSA.verify(reqRes.getData(), reqRes.getSignature(), PUBLIC_KEY);
        if (isVerified) {
            System.out.println("Xác thực chữ ký là đúng");
            String base64Json = AlgorithmsAES.decryptWithCBCMode(reqRes.getData(), SECRET_KEY, IV);
            System.out.println("Nhận thông tin: " + base64Json);
        } else {
            System.out.println("Xác thực chữ ký là sai" );
        }
    }

    public static void main(String[] args) {
        ExampleAESRSA exampleAESRSA = new ExampleAESRSA();
        BaseReqRes infoEncrypted = exampleAESRSA.sendInfo();
        System.out.println("infoEncrypted: " + infoEncrypted.toString());
        exampleAESRSA.receiveInfo(infoEncrypted);
    }
}
