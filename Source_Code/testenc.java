import java.security.*;

import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;


public class testenc {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String str = sc.nextLine();

        // Generate an RSA key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Key size (in bits)
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Get the public key
        PublicKey publicKey = keyPair.getPublic();

        // Convert the public key to Base64
        String publicKeyBase64 = Base64.getEncoder().encodeToString(publicKey.getEncoded());

        // Print the Base64-encoded public key
        System.out.println("Public Key (Base64):\n" + publicKeyBase64);

        String publicKeyStr = publicKeyBase64;
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyStr);
        //publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(publicKeyBytes));

        String encryptedText = encrypt(str,publicKey);
        String decryptedText = decrypt(encryptedText, publicKey);
        System.out.println("Decrypted Text:\n" + decryptedText);

        System.out.println("Encrypted is: "+encryptedText);
        
        //System.out.println(decryptkey(str));
    }



        public static String encrypt(String plaintext, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }


    public static String decrypt(String encryptedText, PublicKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
   
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }

    /*public static String encryptkey(String s1) {
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<s1.length();i++){
        char c=s1.charAt(i);
        if(i%2==0){
        if(c==122)
        {
            c=(char) (c-25);
                
        }
        else{
        c=(char) (c+1);}
        sb.append(c);}
        else
        sb.append(c);}
        return sb.toString();
        }

        public static String decryptkey(String s1) {
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<s1.length();i++){
            char c=s1.charAt(i);
            if(i%2==0){
            if(c==122)
            c=(char) (c-25);
            else{
            c=(char) (c-1);}
            sb.append(c);}
            else
            sb.append(c);}
            return sb.toString();
        }*/

    
}
