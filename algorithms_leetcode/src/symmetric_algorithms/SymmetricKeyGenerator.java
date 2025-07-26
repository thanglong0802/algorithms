package symmetric_algorithms;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class SymmetricKeyGenerator {
    private SymmetricKeyGenerator() {}

    private static final String SECRET_KEY_DEFAULT_32_BYTE = "11507ec3908d7ecd414960c38095690a";

    /**
     * Key generation:
     * 16 byte (AES-128), 24 byte (AES-192), 32 byte (AES-256)
     */
    public static byte[] generateSymmetricKey(int keyLength) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] secretKey = new byte[keyLength];
        secureRandom.nextBytes(secretKey);
        return secretKey;
    }

    public static byte[] generateSymmetricKey() {
        return SECRET_KEY_DEFAULT_32_BYTE.getBytes(StandardCharsets.UTF_8);
    }

    public static String bytesToHexadecimal(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    /**
     * digit(char ch, int radix):
     * Dùng để chuyển đổi một ký tự (char) thành giá trị số tương ứng trong một cơ số bất kỳ (radix/base), ví dụ: cơ số 2, 10, 16...
     *      ch: ký tự muốn chuyển đổi
     *      radix: cơ số muốn chuyển (thường là 10 cho thập phân, 16 cho hệ hexa)
     * Giải thích câu lệnh: ((Character.digit(hexadecimal.charAt(i), 16) << 4) + Character.digit(hexadecimal.charAt(i + 1), 16))
     *      +) 1 ký tự hexa biểu diễn 4 bit (nửa byte)
     *      +) 1 byte = 8 bit = 2 ký tự hexa
     *      Khi chuyển "A3" (2 ký tự hexa) thành 1 byte:
     *          *) 'A' → 10 (4 bit cao) <=> 1010
     *          *) '3' → 3 (4 bit thấp) <=> 0011
     *          Để ghép lại thành 1 byte (10100011), ta làm:
     *              -) Lấy giá trị của ký tự đầu (4 bit cao), dịch trái 4 bit (1010 → 10100000)
     *              -) Cộng với giá trị ký tự sau (4 bit thấp), không cần dịch: 10100000 + 00000011 = 10100011
     * Tóm lại:
     *      +) Dịch trái 4 bit (<< 4) là để đưa giá trị của ký tự hexa đầu vào vị trí 4 bit cao của byte.
     *      +) Sau đó cộng với 4 bit thấp từ ký tự thứ hai.
     *      +) Như vậy, 2 ký tự hexa → 1 byte.
     */
    public static byte[] hexadecimalToBytes(String hexadecimal) {
        int length = hexadecimal.length();
        byte[] data = new byte[length / 2];
        for (int i = 0; i < length; i+=2) {
            data[i / 2] = (byte) ((Character.digit(hexadecimal.charAt(i), 16) << 4) + Character.digit(hexadecimal.charAt(i + 1), 16));
        }
        return data;
    }
}
