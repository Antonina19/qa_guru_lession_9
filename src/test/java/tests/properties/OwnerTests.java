package tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static config.Credentials.credentials;
import static java.lang.String.format;

@Tag("properties")
public class OwnerTests {
    @Test
    void readCredentialsTest() {
        String login = credentials.login();
        String password = credentials.password();

        System.out.println(login);
        System.out.println(password);

        String message = format("I try to login as %s with password %s", login, password);
        System.out.println(message);
    }
}
