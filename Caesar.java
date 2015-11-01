/**
 * Caesar Cipher:
 * A substitution cipher where a given letter's index (starting at A = 0) is rotated right 13 places
 * and replaced with the letter at that index.
 */
public class Caesar extends Cipher {
	private int shiftAmt; 
	
	/** 
	 * Constructor
	 * @param shiftAmt 
	 */
	public Caesar(int shiftAmt) {
		this.shiftAmt = shiftAmt;
	}
	
	/**
	 * Constructor - default shift of 13
	 */
	public Caesar() {
		new Caesar(13);
	}

	
	/**
	 * Encodes the given data and returns the encoded result  
	 * @param input
	 * @return 
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
			int newIndex = (index + shiftAmt) % modulus;
			result += alphabet[newIndex];
		}
		return result;
	}
}
