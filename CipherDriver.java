import java.util.Scanner;

/**
 * Driver for cipher classes
 */
public class CipherDriver {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Caesar c = new Caesar();
		while(true) {
			System.out.println("Enter text to be encoded/decoded (q! to quit): ");
			String plainText = scan.nextLine();
			
			if(plainText.equalsIgnoreCase("q!")) {
				scan.close();
				System.exit(1);
			}
			
			String cipherText = c.encode(plainText);
			System.out.println(cipherText);
		}
	}
}
