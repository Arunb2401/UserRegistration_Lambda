package regex;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class UserRegistration {
	public static final String EMAILPATTERN = "([0-9A-Za-z])+([-+._][0-9A-Za-z]+)*"+ "@([0-9A-Za-z])+[.]([a-zA-Z])+([.][A-Za-z]+)*";
	private static final String NAME_PATTERN = "^[A-Z]{1}[a-z]+$";
	private static final String MOBILE_PATTERN = "^[6-9]+[0-9]{9}$";
	private static final String PASSWORD_PATTERN = "^[A-Z][a-z]+[# @ $ &][0-9]+$";

	public static void main(String[] args) {

		UserRegistration userRegistration = new UserRegistration();
		userRegistration.namepatternTest();
		userRegistration.mobpatternTest();
		userRegistration.emailpatternTest();
		userRegistration.passpatternTest();
	}

	private void mobpatternTest() {
		String sampleName1 = "9606557704";
		String sampleName2 = "6954326987";

		ArrayList<String> nameList = new ArrayList<String>();
		nameList.add(sampleName1);
		nameList.add(sampleName2);
		for (String name : nameList) {
			if (Pattern.matches(MOBILE_PATTERN, name)) {
				System.out.println(name + " - valid ");
			} else {
				System.out.println(name + " - Invalid ");
			}
		}
	}
	private void namepatternTest() {
		String sampleName1 = "Arun";
		String sampleName2 = "Arunb";

		ArrayList<String> nameList = new ArrayList<String>();
		nameList.add(sampleName1);
		nameList.add(sampleName2);
		for (String name : nameList) {
			if (Pattern.matches(NAME_PATTERN, name)) {
				System.out.println(name + " - valid ");
			} else {
				System.out.println(name + " - Invalid ");
			}
		}
	}


	private void emailpatternTest() {
		String sampleEmail1 = "abc@yahoo.com";
		String sampleEmail2 = "abc-100@yahoo.com";
		
		ArrayList<String> emailIdList = new ArrayList<String>();
		emailIdList.add(sampleEmail1);
		emailIdList.add(sampleEmail2);

		for (String emailId : emailIdList) {
			if (Pattern.matches(EMAILPATTERN, emailId)) {
				System.out.println(emailId + " - valid ");
			} else {
				System.out.println(emailId + " - Invalid ");
			}
			
		}
	}
private void passpatternTest() {
	String samplePassword1 = "Arunb@1234";
	String samplePassword2 = "Arunb&1";
	
	ArrayList<String> emailIdList = new ArrayList<String>();
	emailIdList.add(samplePassword1);
	emailIdList.add(samplePassword2);

	for (String emailId : emailIdList) {
		if (Pattern.matches(PASSWORD_PATTERN, emailId)) {
			System.out.println(emailId + " - valid ");
		} else {
			System.out.println(emailId + " - Invalid ");
		}
		
	}
}
}
