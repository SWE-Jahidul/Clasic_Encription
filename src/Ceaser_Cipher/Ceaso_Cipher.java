
package Ceaser_Cipher;

import java.util.Scanner;


class ceaso_ciper_encryption_and_decrypetion{
    
    void encrytion()
    {
   
      Scanner input = new Scanner(System.in);
      System.out.print("Type your message ::");
      String message = input.nextLine().toUpperCase();
      System.out.print("Set Encoding Key :: ");
      int key = input.nextInt() % 26;
      for (int i = 0; i < message.length(); i++) {
         char c = message.charAt(i);
         if (c <= 64 || c >= 91) {
           c+=0;
          }
         else {
            c += key;
            if (c >= 91) {
               c -= 26;
            }
         }
          System.out.print(c );
      }
        System.out.println("\n");
      }
        void Decrypetion()
    {
      Scanner input = new Scanner(System.in);
      System.out.print("Type your message ::");
      String message = input.nextLine().toUpperCase();
      System.out.print("Set Encoding Key :: ");
      int key = input.nextInt() % 26;
      for (int i = 0; i < message.length(); i++) {
         char c = message.charAt(i);
         if (c <= 64 || c >= 91) {
           c-=0;
          }
         else {
            c -= key;
            if (c >= 91) {
               c -= 26;
            }
         }
          System.out.print(c );
      }
        System.out.println("\n");
}
}
public class Ceaso_Cipher {
    
    public static void main(String[] args) {
     ceaso_ciper_encryption_and_decrypetion cce = new ceaso_ciper_encryption_and_decrypetion();
     cce.encrytion();
     cce.Decrypetion();
   }
   }

