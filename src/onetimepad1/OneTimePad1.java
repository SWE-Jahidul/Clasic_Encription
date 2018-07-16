package onetimepad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static onetimepad1.Encreption_And_Decreption.Decryption;
import static onetimepad1.Encreption_And_Decreption.encrition;

     abstract class Encreption_And_Decreption{
     public static final String str ="abcdefghijklmnopqrstuvwxyz_";
     
     public static String encrition(String plaint , int key)
     {
         plaint =plaint.toLowerCase();
         String ciper_text="";
         for(int i=0;i<plaint.length();i++)
         {
             int charposstion = str.indexOf(plaint.charAt(i));
             int keyvalue=(charposstion + key)%26;
             char repplace_value=str.charAt(keyvalue);
             ciper_text=ciper_text+repplace_value;
         }
          return ciper_text;
        }
     public static String Decryption(String cipher ,int key)
     {
         cipher = cipher.toLowerCase();
         String plaint_text = "";
         for(int i=0;i<cipher.length();i++)
         {
             int charposstion = str.indexOf(cipher.charAt(i));
             int keyvalue=(charposstion - key)%26;
            
             if(keyvalue<0){
                 keyvalue = str.length()+keyvalue;
             }
              char repplace_value=str.charAt(keyvalue);
             plaint_text=plaint_text+repplace_value;
         }
          return plaint_text;
        }
     }
public class OneTimePad1 {

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Your Plain Text :");
        String  meassege= br.readLine();
        System.out.println("Your Encrription Meassege Or Chiper Text is :" + encrition(meassege, 3) );
        System.out.println("Your Decryption Meassege Or Chiper Text is :" + Decryption(encrition(meassege, 3) ,3));


    }
    
}
