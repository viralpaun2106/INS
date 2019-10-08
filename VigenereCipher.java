import java.util.*;
public class VigenereCipher
{

	private static Scanner in;

	public static void main(String[] args) 
	{
		in = new Scanner(System.in);
		String p="",c="",k="",l="abcdefghijklmnopqrstuvwxyz";
		
			System.out.print("Enter the plain text");
			p=in.nextLine();
			
			System.out.print("Enter the key");
			k=in.nextLine();
			int ky=k.length();
			int pln=p.length();
		String 	y =k;
		int m = pln%ky;
		
			for( int i=1; i<pln/ky ; i++)
			{
				k=k+y;
				
			}
		k=k+k.substring(0,m);	
			
		for (int j=0; j<pln; j++ ){
			c= c + l.charAt((l.indexOf(k.charAt(j)) + l.indexOf(p.charAt(j)))%26);
		}
		c=c.toUpperCase();
		System.out.println("Ciphertext " + c);
		
		c = c.toLowerCase();
		
		String pl = "";
		
		for (int r=0; r<pln; r++ ){
			pl=pl + l.charAt(((l.indexOf(c.charAt(r)) - l.indexOf(k.charAt(r))) +26 )%26);
		}	
		
		System.out.println("Deciphertext: "+p);
			
		

	}

}