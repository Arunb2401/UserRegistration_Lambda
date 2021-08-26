package regex;

import java.util.regex.Pattern;

public class  UserValidator {
    private final String FIRST_NAME_PATTERN = "^[A-Z]{1}[a-z]{2,}$";
    private final String LAST_NAME_PATTERN = "^[A-Z]{1}[a-z]{2,}$";
    private final String PHONE_PATTERN = "^[1-9][0-9]+[ ]{0,1}+[1-9][0-9]{9}$";
    private final String PASSWORD_PATTERN = "(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%!]{1}).{8,}";
    private final String EMAIL_PATTERN = "^[a-zA-Z0-9\\\\-\\\\+\\\\.]+.([a-zA-Z0-9])*@([a-z0-9]+.[a-z]{2,}.([a-z]{2,})?)$";

    public boolean validateFirstName(String firstname, String firstName) throws InvalidUserException {
        try {
            Pattern pattern = Pattern.compile(FIRST_NAME_PATTERN);
            return pattern.matcher(firstName).matches();
        } catch (NullPointerException e) {
            throw new InvalidUserException("Please enter valid input");
        }
    }

    public boolean validateLastName(String lastname, String lastName) throws InvalidUserException {
        try {
            Pattern pattern = Pattern.compile(LAST_NAME_PATTERN);
            return pattern.matcher(lastName).matches();
        } catch (NullPointerException e) {
            throw new InvalidUserException("Please enter valid input");
        }
    }

        public boolean validateEmail(String email, String EMAIL_PATTERN) throws InvalidUserException {
            try {
                Pattern pattern = Pattern.compile(EMAIL_PATTERN);
                return pattern.matcher(email).matches();
            } catch (NullPointerException e) {
                throw new InvalidUserException("Please enter valid input");
            }
        }

        public boolean validatePhone(String PHONE_PATTERN, String phone) throws InvalidUserException {
             try {
               Pattern pattern = Pattern.compile(PHONE_PATTERN);
               return pattern.matcher(phone).matches();
            } catch (NullPointerException e) {
                throw new InvalidUserException("Please enter valid input ");
            }
    }
        public boolean validatePassword(String PASSWORD_PATTERN, String password) throws InvalidUserException {
        try {
            Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
            return pattern.matcher(password).matches();
        }catch (NullPointerException e ){
            throw new InvalidUserException("Please enter valid input ");
        }
    }
        public boolean multipleEmailvalidate(String email) throws InvalidUserException {
            try {
                if (Pattern.matches(EMAIL_PATTERN, email)) {
                    return true;
                } else {
                    return false;
                }
            }catch (NullPointerException e){
                throw new InvalidUserException("Please enter valid input ");
            }
    }

}