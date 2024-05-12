package co.com.sofka.servicefunctions;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ServiceFunctions {

    public static String generateMD5Hash(long timeStamp, String publicKey, String privateKey) {
        try {
            String input = timeStamp + privateKey + publicKey;
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] bytesOfInput = input.getBytes();

            byte[] hashBytes = md.digest(bytesOfInput);

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
