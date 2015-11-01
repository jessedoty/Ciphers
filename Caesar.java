/**
 * Caesar Cipher:
 * A substitution cipher where a given letter's index (starting at A = 0) is rotated right 13 places
 * and replaced with the letter at that index.
 */
public class Caesar extends Cipher {
	private final int ROT13; // Rotate 13 
	
	/** Constructor */
	public Caesar() {
		ROT13 = 13;
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
			int newIndex = (index + ROT13) % modulus;
			result += alphabet[newIndex];
		}
		return result;
	}
}
