import java.util.*;

public class VernamCipher{
	
	private static Scanner in;
    public static void main(String[] args){
    	
      in = new Scanner(System.in);
      System.out.println("Enter the Plaintext:");
      String text=in.nextLine();
      String key = RandomAlpha(text.length());
      
      String enc = OTPEncryption(text,key);
      System.out.println("The Given Plaintext is : "+text);
      System.out.println("Encrypted Text is: "+enc);
      System.out.println("Decrypted Text is: "+OTPDecryption(enc,key));
   }
   
   public static String RandomAlpha(int len){
      Random r = new Random();
      String key = "";
      for(int x=0;x<len;x++)
         key = key + (char) (r.nextInt(26) + 'A');
      return key;
   }
   
   public static String OTPEncryption(String text,String key){
      String alphaU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      String alphaL = "abcdefghijklmnopqrstuvwxyz";
      
      int len = text.length();
      
      String sb = "";
      for(int x=0;x<len;x++){
         char get = text.charAt(x);
         char keyget = key.charAt(x);
         if(Character.isUpperCase(get)){
            int index = alphaU.indexOf(get);
            int keydex = alphaU.indexOf(Character.toUpperCase(keyget));
            
            int total = (index + keydex) % 26;
            
            sb = sb+ alphaU.charAt(total);
         }
         else if(Character.isLowerCase(get)){
            int index = alphaL.indexOf(get);
            int keydex = alphaU.indexOf(Character.toLowerCase(keyget));
            
            int total = (index + keydex) % 26;
            
            sb = sb+ alphaL.charAt(total);
         }
         else{
            sb = sb + get;
         }
      }
      
      return sb;
   }
   public static String OTPDecryption(String text,String key){
      String alphaU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      String alphaL = "abcdefghijklmnopqrstuvwxyz";
      
      int len = text.length();
      
      String sb = "";
      for(int x=0;x<len;x++){
         char get = text.charAt(x);
         char keyget = key.charAt(x);
         if(Character.isUpperCase(get)){
            int index = alphaU.indexOf(get);
            int keydex = alphaU.indexOf(Character.toUpperCase(keyget));

            int total = (index - keydex) % 26;
            total = (total<0)? total + 26 : total;
            
            sb = sb+ alphaU.charAt(total);
         }
         else if(Character.isLowerCase(get)){
            int index = alphaL.indexOf(get);
            int keydex = alphaU.indexOf(Character.toLowerCase(keyget));
            
            int total = (index - keydex) % 26;
            total = (total<0)? total + 26 : total;
            
            sb = sb+ alphaL.charAt(total);
         }
         else{
            sb = sb + get;
         }
      }
      
      return sb;
   }
   
}