import java.util.*;

public class CeaserCipher {
	private static Scanner sc;

	public static void main(String args[]) {

	System.out.print("CEASER CIPHER \n");	
	while(true) {
		sc = new Scanner(System.in);
		System.out.println("Enter your Choice: \n 1.Encryption \n 2.Decryption \n 3.Exit \n");
		int choice=sc.nextInt();
	
		switch(choice)
		{
			case 1: System.out.println(" Input the plaintext message : ");
        			String plaintext = sc.next();
        			System.out.println(" Enter the key: ");
        			int key = sc.nextInt();
        			String ciphertext = "";
        			char alphabet;
        			for(int i=0; i < plaintext.length();i++) 
        			{
        			
        			alphabet = plaintext.charAt(i);
        			if(alphabet >= 'a' && alphabet <= 'z') 
        			{
        				
        				alphabet = (char) (alphabet + key);
        					if(alphabet > 'z')
        					{ 
        					alphabet = (char) (alphabet+'a'-'z'-1);
        					}
        					ciphertext = ciphertext + alphabet;
        			}
        			else if(alphabet >= 'A' && alphabet <= 'Z') 
        			{
        				
        				alphabet = (char) (alphabet + key);    
        				if(alphabet > 'Z') 
        				{
        					alphabet = (char) (alphabet+'A'-'Z'-1);
        				}
        				ciphertext = ciphertext + alphabet;
        			}
        			else 
        			{
        				ciphertext = ciphertext + alphabet;   
        			}
        		}
        		System.out.println(" ciphertext : " + ciphertext);
        		break;
			
		
			case 2:	System.out.println(" Input the ciphertext message :");
        			String ciphertext1 = sc.next();
        			System.out.println(" Enter key : ");
        			int key1 = sc.nextInt();
        			String decryptMessage = "";
        			for(int i=0; i < ciphertext1.length();i++) 
        			{
        			char alphabet1 = ciphertext1.charAt(i);
        				if(alphabet1 >= 'a' && alphabet1 <= 'z')
        				{
        				
        					alphabet1 = (char) (alphabet1 - key1);
        					if(alphabet1 < 'a') 
        					{ 
        						alphabet1 = (char) (alphabet1-'a'+'z'+1);
        					}
        					decryptMessage = decryptMessage + alphabet1;
        				}    
        			
        				else if(alphabet1 >= 'A' && alphabet1 <= 'Z')
        				{
        					alphabet1 = (char) (alphabet1 - key1);
        					if (alphabet1 < 'A') 
        					{
        						alphabet1 = (char) (alphabet1-'A'+'Z'+1);
        					}
        					decryptMessage = decryptMessage + alphabet1;            
        				}
        				else 
        				{
        					decryptMessage = decryptMessage + alphabet1;            
        				} 
        			}
        			System.out.println(" decrypt message : " + decryptMessage);
        			break;
        		
			case 3:System.exit(0);
				break;
		}
		
	}	
}

}