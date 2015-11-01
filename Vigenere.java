/**
 * Vigenere Cipher:
 * A polyalphabetic substitution cipher where a key is repeated (or truncated)
 * to match the length of a given message. Therefore each letter of the message
 * has a corresponding letter in the key. The index of each key letter is then 
 * used as the rotation amount for each corresponding letter in the message.
 * 
 * Example (as seen on Wikipedia):
 * Plaintext:	ATTACKATDAWN
 * Key:			LEMONLEMONLE
 * Ciphertext:	LXFOPVEFRNHR
 */
public class Vigenere extends Cipher {
	private String key;

	/**
	 * Constructor
	 * @param key
	 */
	public Vigenere(String key) {
		this.key = key;
	}
	
	/**
	 * Encodes the given input
	 * @param input
	 * @return encoded result
	 */
	public String encode(String input) {
		String newKey = matchKeyToInput(input);
		String result = "";
		
		for(int i = 0; i<input.length(); i++) {
			String curr = String.valueOf(input.charAt(i));
			int index = indexOf(curr);
			if (index == -1) { // curr is a non-alphabetic character
				result += curr ;
				continue;
			}
			String keyCurr = String.valueOf(newKey.charAt(i));
			int rotAmt = indexOf(keyCurr);
			int newIndex = (index + rotAmt) % modulus;
			result += alphabet[newIndex];
		}
		return result;
	}
	
	/**
	 * Morphs the key to match the length of the input
	 * @param input
	 * @return new key
	 */
	private String matchKeyToInput(String input) {
		if(key.length() > input.length()) {
			return key.substring(0, input.length());
		}
		if(key.length() < input.length()) {
			String result = "";
			int wholes = input.length()/key.length();
			int partial = (input.length() % key.length());
			
			for(int i = 0; i<wholes; i++) {
				result += key;
			}			
			result += key.substring(0, partial);
			return result;
			
		}
		return key; // Same length
	}
	
	
}
