package program.utils_other;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.UndeclaredThrowableException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;

/**
 * 基于时间的一次性密码算法
 * 算法介绍：https://zh.wikipedia.org/wiki/基于时间的一次性密码算法
 * 代码来自：https://tools.ietf.org/html/rfc6238
 *
 * Created by fanpengju on 2019/10/29 16:04.
 */
public class TOTP {
    private TOTP() {}

    private static byte[] hmac_sha(String crypto, byte[] keyBytes,
                                   byte[] text){
        try {
            Mac hmac;
            hmac = Mac.getInstance(crypto);
            SecretKeySpec macKey =
                    new SecretKeySpec(keyBytes, "RAW");
            hmac.init(macKey);
            return hmac.doFinal(text);
        } catch (GeneralSecurityException gse) {
            throw new UndeclaredThrowableException(gse);
        }
    }

    private static byte[] hexStr2Bytes(String hex){
        // Adding one byte to get the right conversion
        // Values starting with "0" can be converted
        byte[] bArray = new BigInteger("10" + hex,16).toByteArray();

        // Copy all the REAL bytes, not the "first"
        byte[] ret = new byte[bArray.length - 1];
        for (int i = 0; i < ret.length; i++)
            ret[i] = bArray[i+1];
        return ret;
    }

    private static final int[] DIGITS_POWER
            // 0 1  2   3    4     5      6       7        8
            = {1,10,100,1000,10000,100000,1000000,10000000,100000000 };

    public static String generateTOTP(String key,
                                      String time,
                                      int returnDigits){
        return generateTOTP(key, time, returnDigits, "HmacSHA1");
    }

    public static String generateTOTP256(String key,
                                         String time,
                                         int returnDigits){
        return generateTOTP(key, time, returnDigits, "HmacSHA256");
    }

    public static String generateTOTP(String key,
                                      String time,
                                      int returnDigits,
                                      String crypto){
        int codeDigits = returnDigits;
        String result = null;

        // Using the counter
        // First 8 bytes are for the movingFactor
        // Compliant with base RFC 4226 (HOTP)
        while (time.length() < 16 )
            time = "0" + time;

        // Get the HEX in a Byte[]
        byte[] msg = hexStr2Bytes(time);
        byte[] k = hexStr2Bytes(key);
        byte[] hash = hmac_sha(crypto, k, msg);

        // put selected bytes into result int
        int offset = hash[hash.length - 1] & 0xf;

        int binary =
                ((hash[offset] & 0x7f) << 24) |
                        ((hash[offset + 1] & 0xff) << 16) |
                        ((hash[offset + 2] & 0xff) << 8) |
                        (hash[offset + 3] & 0xff);

        int otp = binary % DIGITS_POWER[codeDigits];

        result = Integer.toString(otp);
        while (result.length() < codeDigits) {
            result = "0" + result;
        }
        return result;
    }

    public static String generateTOTP(int length) {
        // Seed for HMAC-SHA512 - 64 bytes
        String seed64 = "31323334353637383930313284643536373839303132333435363738393031323334353637383930313233343536373839303132333435363738393031323334";

        long T = System.currentTimeMillis();
        String steps = Long.toHexString(T).toUpperCase();

        return TOTP.generateTOTP(seed64, steps, length, "HmacSHA512");
    }
    public static void main(String[] args) {

//        for (int i = 0;i<100;i++){
//            System.out.println(generateTOTP(8));
//        }
        String a = "wucunyang";
        System.out.println(a.equals("wucunyang"));
        Boolean ab = true;
        System.out.println(!ab);
    }

}
