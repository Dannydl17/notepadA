package notepadApp.utils;

public class Constants {
    public static final String BLANK_FIELD_MESSAGE = "This Field Cannot Be Blank";
    public static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[a-zA-Z]).{8,15}$";
    public static final String INVALID_PASSWORD_MESSAGE = """
                Invalid Password: Password Should Pass The Following Criteria.
                1. Password Must Contain At Least 1 Lowercase Alphabet.
                2. Password Must Contain At Least 1 Uppercase Alphabet.
                3. Password Must Contain At Least 1 Special Character from these: @#$%^&+=.
                4. Password Must Contain At Least 1 Digit.
                5. Password Must Not Be Lesser Than 8 Characters
                6. Password Must Not Be More Than 15 Characters
                """;
    public static final String DUPLICATE_USER_MESSAGE = "Duplicate entry 'email@native.semicolon.africa";
}
