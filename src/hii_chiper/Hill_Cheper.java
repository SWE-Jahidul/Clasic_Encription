/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hii_chiper;
import java.util.Scanner;
public class Hill_Cheper {
private static Scanner in;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
            in =new Scanner(System.in);
            System.out.println("1.Encryption\n2.Decryption\n");
              System.out.println("Enter your choice :");
            int choice =in.nextInt() ;
          
            in.nextLine();
            
            
    switch (choice) {
        case 1:
            System.out.println("--Encryption--");
            chiperencryption();
            break;
        case 2:
            System.out.println("--Decryption--");
            chiperdycription();
            break;
        default:
            System.out.println("Invalid choice");
            break;
    }
    }
    private static void chiperencryption()
    {
        System.out.println("Enter your Measssege :");
        String msg =in.nextLine();
        msg=msg.replaceAll("\\a", "");
        msg=msg.toUpperCase();
     
        //if irreglar length ,then perform padding
        
        int lencheak=0;
        if(msg.length() % 2 !=0)
        {
            msg +="0";
            lencheak =1;
        }
        //message to matrices
        int [] [] msg2d = new int[2][msg.length()];
        int itr1 =0;
        int itr2 =0;
        for(int i=0;i<msg.length();i++)
        {
            if(i%2 == 0)
            {
                msg2d[0][itr1]=((int)msg.charAt(i)-65);
                itr1++;
            }
           else
            {
               msg2d[1][itr2]=((int)msg.charAt(i)-65);
               itr2++;
               
            }
        }
        //testing 2D matrix
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < msg.length()/2; j++) {
//                System.out.print((char)(msg2d[i][j]+65)+" ");
//                
//         
//            }
//            System.out.println("");
//        }
        

//impliment butt here is an bug occure
        System.out.println("Enter yout 4 letter key String");
        
        String key =in.nextLine();
        key =key.replaceAll("\\s", "");
        key =key.toUpperCase();
        
        //key to 2x2 matrix 
        int [][] key2d = new  int[2][2];
        int itr3 =0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                
              key2d[i][j]=(int)key.charAt(itr3)-65;
              itr3++;
            }
            
        }
        int deter =key2d[0][0]*key2d[1][1] -key2d[0][1]*key2d[1][0];
   
            deter = modulofunction(deter ,2);
            
            int mulinverse =-1;
            for (int i = 0; i < 26; i++) {
            int tempinv =deter*i;
            if(modulofunction(tempinv,26)==1){
                mulinverse=i;
                break;
            }
            else{
            }
                
        }
        
        if(mulinverse == -1){
                 System.out.println("Envaild key ");  
                 System.exit(deter);
                }
         String encrypttext="";
          int irtcount= msg.length()/2;  
          if(lencheak  ==0)
          {
              for (int i = 0; i < irtcount; i++) {
                  int temp1=msg2d[0][i]*key2d[0][0]+msg2d[1][i]*key2d[0][1];
                  encrypttext += (char)((temp1 %  26)+65);
                  int temp2=msg2d[0][i]*key2d[1][0]+msg2d[1][i]*key2d[1][1];
                  encrypttext += (char)((temp1 %  26)+65);
              }
          }
          else
          {
           for (int i = 0; i < irtcount-1; i++) {
                  int temp1=msg2d[0][i]*key2d[0][0]+msg2d[1][i]*key2d[0][1];
                  encrypttext += (char)((temp1 %  26)+65);
                  int temp2=msg2d[0][i]*key2d[1][0]+msg2d[1][i]*key2d[1][1];
                  encrypttext += (char)((temp1 %  26)+65);
              }
   
          }
          
          
          
          System.err.println("Encrypted text " +encrypttext);
          
         
    }
  
    
    private static void chiperdycription()
    {
        
    }
//    modulos function
    
    public static int modulofunction(int a ,int b)
    {
        int result=a%b;
        if(result<0){
            result +=b;
        }
        return result;
    }
    
}
