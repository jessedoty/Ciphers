/**
 * Caesar Cipher:
 * A substitution cipher where a given letter's index (starting at A = 0) is rotated right x places
 * and replaced with the letter at that index.
 *  
 * Example with a rotation of 23 (as seen on Wikipedia):
 * Plaintext:    ABCDEFGHIJKLMNOPQRSTUVWXYZ
 * Ciphertext: 	 XYZABCDEFGHIJKLMNOPQRSTUVW
 */
public class Caesar extends Cipher {
	private int rotAmt; 
	
	/** 
	 * Constructor
	 * @param shiftAmt 
	 */
	public Caesar(int rotAmt) {
		this.rotAmt = rotAmt;
	}
	
	/**
	 * Constructor - default shift of 13
	 */
	public Caesar() {
		new Caesar(13);
	}

	
	/**
	 * Encodes the given input
	 * @param input
	 * @return encoded result
	 */
	public String encode(String input) {
		String result = "";
		for(int i = 0; i<input.length(); i++) {
			String curr = String.valueOf(input.charAt(i));
			int index = indexOf(curr);
			if (index == -1) { // curr is a non-alphabetic character
				result += curr ;
				continue;
			}
			int newIndex = (index + rotAmt) % modulus;
			result += alphabet[newIndex];
		}
		return result;
	}
}
