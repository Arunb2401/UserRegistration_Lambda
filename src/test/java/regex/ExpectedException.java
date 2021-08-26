package regex;

@SuppressWarnings("serial")
public class ExpectedException extends Exception {

	public static ExpectedException none() {
		return null;
	}

	public void expect(Class<InvalidUserException> class1) {		
	}
}
