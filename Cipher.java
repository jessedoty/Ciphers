/**
 * Parent of other cipher classes.
 * Provides base alphabet and search function
 */
public class Cipher {
	protected String alphabet[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z" };
	protected int modulus = alphabet.length;
	
	/**
	 * Finds index of char given in the alphabet array
	 * @param var
	 * @return index of given letter, -1 if not found
	 */
	public int indexOf(String var) {
		for(int i = 0; i<alphabet.length; i++) {
			if(var.equalsIgnoreCase(alphabet[i])) {
				return i;
			}
		}
		return -1;
	}
}
