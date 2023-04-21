package edu.guilford;

/**
 *
 * @author bousabacw
 */
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    private static SecretKeySpec secretKey;
    private static byte[] key;

    public static void setKey(String myKey) {
        MessageDigest sha = null;
        try {
            //this is converting the name part of the password to a set of bytes 
            key = myKey.getBytes("UTF-8");
            //this creates a hash function
            sha = MessageDigest.getInstance("SHA-1");
            //this is hashing the key--conversion of byte code into another set of characters in a set length 
            key = sha.digest(key);
            //this is taking the first 16 bytes of the hashed key
            key = Arrays.copyOf(key, 16);
            //this is creating a secret key
            secretKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String strToEncrypt, String secret) {
        try {
            //using the setKey method to create a secret key
            setKey(secret);
            //this is creating a cipher object--guide to how to encrypt the data
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            //returning the encrypted string
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(String strToDecrypt, String secret) {
        try {
            //using the setKey method to create a secret key
            setKey(secret);
            //this is creating a cipher object--guide to how to decrypt the data
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            //returning the decrypted string
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}
