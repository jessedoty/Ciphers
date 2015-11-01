import java.util.Scanner;

/**
 * Driver for cipher classes
 */
public class CipherDriver {
	public static void main(String args[]) {
		Cipher cipher = build(args);
		run(cipher);
	}
	
	/**
	 * Handles argument checks and builds cipher object
	 * @param args
	 * @return cipher object
	 */
	public static Cipher build(String args[]) {
		if(args.length < 1 || args.length > 2) {
			printUsage();
		}
		
		Cipher cipher = null;
		if(args[0].equals("-c")) {
			if(args[1] != null) {
				cipher = new Caesar(Integer.parseInt(args[1]));
			}
			else {
				cipher = new Caesar();
			}
		}
		else if(args[0].equals("-v")) {
			cipher = new Vigenere(args[1]);
		}
		else{
			printUsage();
		}
		return cipher;
	}
	
	/**
	 * Encodes given input until the user wants to quit
	 * @param c
	 */
	public static void run(Cipher c) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("Enter text to be encoded (q! to quit): ");
			String plainText = scan.nextLine();
			
			if(plainText.equalsIgnoreCase("q!")) {
				scan.close();
				System.exit(1);
			}
			
			String cipherText = c.encode(plainText);
			System.out.println(cipherText);
		}
	}
	
	/**
	 * Usage instructions
	 */
	public static void printUsage() {
		System.out.println("Usage: ");
		System.out.println("$java CipherDriver [-c|-v] <shift amount | key>");
		System.out.println("-c : use caesar cipher. a shift amount is optional with this cipher (13 by default)");
		System.out.println("-v : use vigenere cipher. a key is needed with this cipher");
		System.exit(1);
	}
}
