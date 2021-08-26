package regex;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.List;

public class TestUserValidator {
    @Test
    public void givenFirstName_ShouldReturn_True() {
        boolean result=false;
        try {
            @SuppressWarnings("deprecation")
			ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(InvalidUserException.class);
            UserValidator userValidator = new UserValidator();
            result = userValidator.validateFirstName("^[A-Z]{1}[a-z]{2,}$", "Arungb");
        }
        catch (InvalidUserException e){
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
    @Test
    public void givenLastName_WhenLastNameStartsWithCapitalLetter_ShouldReturn_True() {
        boolean result =false;
        try {
            @SuppressWarnings("deprecation")
			ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(InvalidUserException.class);
            UserValidator userValidator = new UserValidator();
            result = userValidator.validateLastName("^[A-Z]{1}[a-z]{2,}$", "Biradar");
        }catch (InvalidUserException e){
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
    @Test
    public void givenEmail_WhenEmailStartsWithSmallLetter_ShouldReturn_True() {
        boolean result =true;
        try {
            @SuppressWarnings("deprecation")
			ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(InvalidUserException.class);
            UserValidator userValidator = new UserValidator();
            result = userValidator.validateEmail("^[a-zA-Z0-9\\\\-\\\\+\\\\.]+.([a-zA-Z0-9])*@([a-z0-9]+.[a-z]{2,}.([a-z]{2,})?)$","arungbbiradar24@gmail.com");
        }catch (InvalidUserException e){
            e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
    @Test
    public void givenPhoneNumber_WhenPhoneNumberIsFollowedByCountryCode_True() {
        boolean result =false;
        try {
            @SuppressWarnings("deprecation")
			ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(InvalidUserException.class);
            UserValidator userValidator = new UserValidator();
            result = userValidator.validatePhone("^[1-9][0-9]+[ ]{0,1}+[1-9][0-9]{9}$","91 9604445258");
        }catch (InvalidUserException e){
             e.printStackTrace();
        }
        Assert.assertTrue(result);
    }
    @Test
    public void givenPassword_WhenPasswordHaveAtleastOneCapitalLetter_ShouldReturn_True() {
        boolean result =false;
            try {
                @SuppressWarnings("deprecation")
				ExpectedException expectedException = ExpectedException.none();
                expectedException.expect(InvalidUserException.class);
                 UserValidator userValidator = new UserValidator();
                 result = userValidator.validatePassword("(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%!]{1}).{8,}","Arungb@12345678");
            }catch (InvalidUserException e){
                e.printStackTrace();
            }
        Assert.assertTrue(result);
    }
    //UseCase11-Parameterised Test to validate multiple entry for the Email Address.
    @RunWith(Parameterized.class)
    public static class TestFormRegistration
    {
        String emailId;
        boolean expectedResult;
        private UserValidator emailVariable;
        UserValidator formObject = new UserValidator();
        public TestFormRegistration(String emailId, boolean expectedResult)
        {
            this.emailId = emailId;
            this.expectedResult = expectedResult;
        }
        @Before
        public void initialize()
        {
            emailVariable = new UserValidator();
        }
        @Parameterized.Parameters
        public static List<Object[]> emails()
        {
            return Arrays.asList(new Object[][] { {"Arungb@gmail.com", true}, {"Arungb@gmail.co.in",true}, {"arungbgmail.com", false}});
        }
        @Test
        public void testEmailId() throws InvalidUserException {
            try {
                System.out.println("parameter email is->" + emailId);
                Assert.assertEquals(expectedResult, emailVariable.multipleEmailvalidate(emailId));
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        }
    }
}