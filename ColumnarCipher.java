import java.util.*;

public class ColumnarCipher {
    private static Scanner sc;

	public static void main(String[] args) {
        sc = new Scanner(System.in);
        String line = System.getProperty("line.separator");
        sc.useDelimiter(line);
        System.out.println("COLUMNAR TRANSPOSITION CIPHER");
      while(true)
      {
        System.out.print("1. Encrytion \n 2.Decryption \n 3. exit \n");
        int choice = sc.nextInt();
        switch (choice) 
        {
            case 1:
                System.out.print("Enter Plaintext:");
                String text = sc.next();
                System.out.print("Enter Key:");
                String key = sc.next();

                System.out.println(encryptCT(key, text).toUpperCase());
                break;
                
            case 2:
                System.out.print("Enter Ciphertext:");
                text = sc.next();
                System.out.print("Enter Key:");
                key = sc.next();

                System.out.println(decryptCT(key, text));
                break;
                
            case 3:
            	System.exit(0);
            	break;
        }
     }
	}
	
    public static String encryptCT(String key, String text) {
        int[] arrange = arrangeKey(key);

        int lenkey = arrange.length;
        int lentext = text.length();

        int row = (int) Math.ceil((double) lentext / lenkey);

        char[][] grid = new char[row][lenkey];
        int z = 0;
        for (int x = 0; x < row; x++) 
        {
            for (int y = 0; y < lenkey; y++)
            {
                if (lentext == z)
                {
                    grid[x][y] = RandomAlpha();
                    z--;
                } 
                else 
                {
                    grid[x][y] = text.charAt(z);
                }
                z++;
            }
        }
        String enc = "";
        for (int x = 0; x < lenkey; x++) 
        {
            for (int y = 0; y < lenkey; y++) 
            {
                if (x == arrange[y]) 
                {
                    for (int a = 0; a < row; a++) 
                    {
                        enc = enc + grid[a][y];
                    }
                }
            }
        }
        return enc;
    }

    public static String decryptCT(String key, String text) {
        int[] arrange = arrangeKey(key);
        int lenkey = arrange.length;
        int lentext = text.length();

        int row = (int) Math.ceil((double) lentext / lenkey);

        String regex = "(?<=\\G.{" + row + "})";
        String[] get = text.split(regex);

        char[][] grid = new char[row][lenkey];

        for (int x = 0; x < lenkey; x++) 
        {
            for (int y = 0; y < lenkey; y++) 
            {
                if (arrange[x] == y) 
                {
                    for (int z = 0; z < row; z++) 
                    {
                        grid[z][y] = get[arrange[y]].charAt(z);
                    }
                }
            }
        }

        String dec = "";
        for (int x = 0; x < row; x++) 
        {
            for (int y = 0; y < lenkey; y++) 
            {
                dec = dec + grid[x][y];
            }
        }

        return dec;
    }
	
    public static char RandomAlpha() 
    {
        Random r = new Random();
        return (char)(r.nextInt(26) + 'a');
    }

    public static int[] arrangeKey(String key) 
    {
        //arrange position of grid
        String[] keys = key.split("");
        Arrays.sort(keys);
        int[] num = new int[key.length()];
        for (int x = 0; x < keys.length; x++) 
        {
            for (int y = 0; y < key.length(); y++) 
            {
                if (keys[x].equals(key.charAt(y) + "")) 
                {
                    num[y] = x;
                    break;
                }
            }
        }
        return num;
    }

}