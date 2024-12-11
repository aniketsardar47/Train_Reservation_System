import java.util.*;
import java.util.regex.*;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;

import java.nio.charset.StandardCharsets;
import java.sql.*;


public class Information{

        //connection 
    protected String url = "jdbc:mysql://localhost:3306/train_reservation_system";
    protected String usernamedba = "-";
    protected String passworddba = "-";

    //encryptions
    String secretKey = "SecretEncryption"; 


     Reservation2 r1;

    public Information(String username, String email, String contactno, String password, String repassword){


        if(username==null || email==null || contactno==null || password==null || repassword==null){
            

                if(username==null)
                        JOptionPane.showMessageDialog(new JFrame(), "Username is Missing");

                        
                if(email==null)
                        JOptionPane.showMessageDialog(new JFrame(), "email is Missing");


                if(contactno==null)
                        JOptionPane.showMessageDialog(new JFrame(), "contact number is Missing");

                if(password==null)
                        JOptionPane.showMessageDialog(new JFrame(), "Password is Missing");

               
                if(repassword==null)
                        JOptionPane.showMessageDialog(new JFrame(), "Re-entered Password is Missing");

        }
        else if(!password.equals(repassword)){

            JOptionPane.showMessageDialog(new JFrame(), "Passwords Does Not Match!!");
        }
        else if(!isPasswordValid(password)){
                JOptionPane.showMessageDialog(new JFrame(),"Password Does Not Contain it's Requirements...\n"+"One or more Capital letter \n"+"One or more Single letter  \n"+"One or more Special Characters \n" +"One or more Capital letter number ");

        }
        else if(!isValidEmail(email)){
                JOptionPane.showMessageDialog(new JFrame(), "Email Does Not Valid");
        }
        else {
                String originalText = password;
                try{
                

                

                // Encrypt the text
                String encryptedText = encrypt(originalText, secretKey);
                System.out.println("Encrypted Text: " + encryptedText);

                // Decrypt the text
                String decryptedText = decrypt(encryptedText, secretKey);
                System.out.println("Decrypted Text: " + decryptedText);
                
		
                        Connection con = DriverManager.getConnection(url, usernamedba, passworddba);
                        System.out.println("Connection Established");
                      
                        String query = "INSERT INTO login(username,passwords,email,contactno) VALUES (?,?,?,?);";
                        PreparedStatement preparedStatement = con.prepareStatement(query);
            
                        // Set the values
                        preparedStatement.setString(1, username);
                        preparedStatement.setString(2, encryptedText);
                        preparedStatement.setString(3, email);
                        preparedStatement.setString(4, contactno);
    
                        int rowsAffected = preparedStatement.executeUpdate();
                        System.out.println("Rows affected: " + rowsAffected);
                        if(rowsAffected==1){
                          
                            r1 = new Reservation2();

                        }

                          con.close();
                 }
                 catch(Exception same){
                        String str = "Something went wrong check your data\n"+same.getMessage();
                          JOptionPane.showMessageDialog(new JFrame(),str);
                        }
        }

   
    }

    public Information(String username, String password){
        System.out.println("UserName: "+username+" Password"+password);
        if(username == null || password == null){
                if(username == null && password!= null){
                          JOptionPane.showMessageDialog(new JFrame(),"UserName is Missing!!");
                }
                else if(password == null && username!= null){
                        JOptionPane.showMessageDialog(new JFrame(),"Password is Missing!!");
                }
                else{
                        JOptionPane.showMessageDialog(new JFrame(),"Password and Username is Missing!!");
                }
                
        }
        else {
                try {
                        Connection connection = DriverManager.getConnection(url, usernamedba, passworddba);
                        String query = "SELECT passwords from login WHERE username= ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1, username);
        
                        ResultSet resultSet = preparedStatement.executeQuery();
        
                        if (resultSet.next()) {
                            String retrievedEncryptedPassword = resultSet.getString("passwords");
                            String enteredPassword = password;
                        
                            System.out.println("Retrieved Encrypted Password: " + retrievedEncryptedPassword);
                        
                            // Decrypt the retrieved encrypted password
                           String decryptedpass = decrypt(retrievedEncryptedPassword,secretKey);
                            System.out.println("Decrypted Password: " + decryptedpass);
                        
                            // Check if the entered password matches the stored password
                            if (enteredPassword.equals(decryptedpass)) {
                                 JOptionPane.showMessageDialog(new JFrame(),"Password matched.");
                                r1 = new Reservation2(); 
                            } else {
                               JOptionPane.showMessageDialog(new JFrame(),"Password did not match.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(new JFrame(),"Data Not Found!!","Check Information",JOptionPane.QUESTION_MESSAGE);
                        }
                        
        
                        resultSet.close();
                        preparedStatement.close();
                        connection.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(new JFrame(),"Error: "+ex.getMessage());
                        System.out.println(ex.getMessage());
                    }
        }

    }


    public static boolean isValidEmail(String email) {
        String EMAIL_REGEX ="^[A-Za-z0-9+_.-]+@(.+)com";

        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public static boolean isPasswordValid(String password) {
        // Define regular expressions for each requirement
        String uppercase = ".*[A-Z].*";
        String lowercase = ".*[a-z].*";
        String digit = ".*\\d.*";
        String specialChar = ".*[@#$%^&+=].*"; // You can customize the special characters as needed
        
        // Check if the password meets all requirements
        return password.matches(uppercase) &&
               password.matches(lowercase) &&
               password.matches(digit) &&
               password.matches(specialChar);
    }

    public static String encrypt(String plainText, String secretKey) throws Exception {
    SecretKey key = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]); // You should use a random IV
    cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);

    byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
    return Base64.getEncoder().encodeToString(encryptedBytes);
}

public static String decrypt(String encryptedText, String secretKey) throws Exception {
    SecretKey key = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[16]); // Use the same IV as used for encryption
    cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);

    byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
    byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
    return new String(decryptedBytes, StandardCharsets.UTF_8);
}
    
}